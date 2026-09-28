package com.hauliq.app.presentation.scanner

import android.Manifest
import android.content.pm.PackageManager
import android.util.Size
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import java.util.concurrent.Executors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScannerScreen(
    viewModel: BarcodeScannerViewModel,
    onNavigateToProductDetails: (String) -> Unit,
    onNavigateToAddProduct: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val uiState by viewModel.uiState.collectAsState()
    val isFlashEnabled by viewModel.isFlashEnabled.collectAsState()

    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            hasCameraPermission = granted
        }
    )

    LaunchedEffect(Unit) {
        if (!hasCameraPermission) {
            launcher.launch(Manifest.permission.CAMERA)
        }
    }

    LaunchedEffect(uiState) {
        when (val state = uiState) {
            is ScannerUiState.Success -> {
                if (state.productExists && state.productId != null) {
                    onNavigateToProductDetails(state.productId)
                } else {
                    onNavigateToAddProduct(state.barcode)
                }
                viewModel.resetScanner()
            }
            else -> {}
        }
    }

    var showManualEntryDialog by remember { mutableStateOf(false) }
    var manualBarcode by remember { mutableStateOf("") }

    if (showManualEntryDialog) {
        AlertDialog(
            onDismissRequest = { showManualEntryDialog = false },
            title = { Text("Manual Barcode Entry") },
            text = {
                OutlinedTextField(
                    value = manualBarcode,
                    onValueChange = { manualBarcode = it },
                    label = { Text("Barcode Number") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            },
            confirmButton = {
                Button(onClick = {
                    if (manualBarcode.isNotBlank()) {
                        viewModel.onManualBarcodeSubmit(manualBarcode)
                        showManualEntryDialog = false
                    }
                }) {
                    Text("Submit")
                }
            },
            dismissButton = {
                TextButton(onClick = { showManualEntryDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        if (hasCameraPermission) {
            CameraPreview(
                isFlashEnabled = isFlashEnabled,
                onBarcodeDetected = { viewModel.onBarcodeDetected(it) }
            )

            // Scanning Overlay
            ScannerOverlay()

            // Controls
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = onNavigateBack,
                        modifier = Modifier.background(Color.Black.copy(alpha = 0.5f), CircleShape)
                    ) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
                    }

                    IconButton(
                        onClick = { viewModel.toggleFlash() },
                        modifier = Modifier.background(Color.Black.copy(alpha = 0.5f), CircleShape)
                    ) {
                        Icon(
                            imageVector = if (isFlashEnabled) Icons.Default.FlashOn else Icons.Default.FlashOff,
                            contentDescription = "Flash",
                            tint = if (isFlashEnabled) Color.Yellow else Color.White
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Align barcode within the frame",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { showManualEntryDialog = true },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.2f)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Default.Keyboard, contentDescription = null, tint = Color.White)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Enter Barcode Manually", color = Color.White)
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(Icons.Default.CameraAlt, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(64.dp))
                Spacer(modifier = Modifier.height(16.dp))
                Text("Camera permission is required to scan barcodes", color = Color.White, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = { launcher.launch(Manifest.permission.CAMERA) }) {
                    Text("Grant Permission")
                }
            }
        }
    }
}

@Composable
fun CameraPreview(
    isFlashEnabled: Boolean,
    onBarcodeDetected: (String) -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    
    var camera by remember { mutableStateOf<androidx.camera.core.Camera?>(null) }

    LaunchedEffect(isFlashEnabled) {
        camera?.cameraControl?.enableTorch(isFlashEnabled)
    }

    AndroidView(
        factory = { ctx ->
            val previewView = PreviewView(ctx)
            val executor = Executors.newSingleThreadExecutor()
            cameraProviderFuture.addListener({
                val cameraProvider = cameraProviderFuture.get()
                val preview = Preview.Builder().build().also {
                    it.setSurfaceProvider(previewView.surfaceProvider)
                }

                val selector = CameraSelector.DEFAULT_BACK_CAMERA

                val imageAnalysis = ImageAnalysis.Builder()
                    .setTargetResolution(Size(1280, 720))
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                    .build()

                imageAnalysis.setAnalyzer(executor, BarcodeAnalyzer(
                    onBarcodeDetected = { barcode ->
                        onBarcodeDetected(barcode)
                    },
                    onError = {
                        // Log or handle error
                    }
                ))

                try {
                    cameraProvider.unbindAll()
                    camera = cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        selector,
                        preview,
                        imageAnalysis
                    )
                } catch (e: Exception) {
                    // Log or handle Error
                }
            }, ContextCompat.getMainExecutor(ctx))
            previewView
        },
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun ScannerOverlay() {
    val infiniteTransition = rememberInfiniteTransition(label = "scanner_animation")
    val lineY by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "line_y"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            val frameSize = width * 0.7f
            val left = (width - frameSize) / 2
            val top = (height - frameSize) / 2
            val right = left + frameSize
            val bottom = top + frameSize

            // Background with hole
            drawRect(color = Color.Black.copy(alpha = 0.5f))
            
            // Frame corners
            val strokeWidth = 4.dp.toPx()
            val cornerLength = 40.dp.toPx()
            
            // Top Left
            drawLine(Color.White, Offset(left, top), Offset(left + cornerLength, top), strokeWidth)
            drawLine(Color.White, Offset(left, top), Offset(left, top + cornerLength), strokeWidth)
            
            // Top Right
            drawLine(Color.White, Offset(right, top), Offset(right - cornerLength, top), strokeWidth)
            drawLine(Color.White, Offset(right, top), Offset(right, top + cornerLength), strokeWidth)
            
            // Bottom Left
            drawLine(Color.White, Offset(left, bottom), Offset(left + cornerLength, bottom), strokeWidth)
            drawLine(Color.White, Offset(left, bottom), Offset(left, bottom - cornerLength), strokeWidth)
            
            // Bottom Right
            drawLine(Color.White, Offset(right, bottom), Offset(right - cornerLength, bottom), strokeWidth)
            drawLine(Color.White, Offset(right, bottom), Offset(right, bottom - cornerLength), strokeWidth)
            
            // Animated Line
            val linePos = top + (bottom - top) * lineY
            drawLine(
                color = Color.Red,
                start = Offset(left + 10.dp.toPx(), linePos),
                end = Offset(right - 10.dp.toPx(), linePos),
                strokeWidth = 2.dp.toPx()
            )
        }
    }
}
