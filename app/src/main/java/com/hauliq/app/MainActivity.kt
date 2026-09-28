package com.hauliq.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.firebase.database.FirebaseDatabase
import com.hauliq.app.core.navigation.NavGraph
import com.hauliq.app.core.navigation.Screen
import com.hauliq.app.core.theme.HaulIQTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.hauliq.app.presentation.seeder.SeederViewModel
import com.hauliq.app.data.remote.FirebaseSeeder
import android.widget.Toast

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Firebase Connection Test
        testFirebaseConnection()

        setContent {
            HaulIQTheme {
                val seederViewModel: SeederViewModel = hiltViewModel()
                val context = LocalContext.current
                
                LaunchedEffect(Unit) {
                    seederViewModel.seedingStatus.collect { status ->
                        when(status) {
                            is FirebaseSeeder.SeedingStatus.Progress -> {
                                Log.d("FirebaseSeeder", "Progress: ${status.percentage}% - ${status.message}")
                            }
                            is FirebaseSeeder.SeedingStatus.Success -> {
                                Log.d("FirebaseSeeder", "Seeding successful")
                            }
                            is FirebaseSeeder.SeedingStatus.Failure -> {
                                Toast.makeText(context, "Seeding failed: ${status.error}", Toast.LENGTH_LONG).show()
                            }
                            else -> {}
                        }
                    }
                }

                MainAppScreen()
            }
        }
    }

    private fun testFirebaseConnection() {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.reference

        // Read the root node once to verify connection
        myRef.get().addOnSuccessListener {
            Log.d("FirebaseTest", "Firebase Connected Successfully")
        }.addOnFailureListener {
            Log.e("FirebaseTest", "Connection Failed: ${it.message}")
        }
    }
}

// Data holder for bottom navigation items
data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector
)

// Data holder for drawer items
data class DrawerNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    // Determine if we should show scaffolding (bars & menus)
    val showScaffolding = (currentRoute != null && 
            currentRoute != Screen.Splash.route && 
            currentRoute != Screen.Login.route && 
            currentRoute != Screen.Register.route && 
            currentRoute != Screen.ForgotPassword.route)

    // Bottom Navigation destinations
    val bottomNavItems = listOf(
        BottomNavItem("Home", Screen.Dashboard.route, Icons.Default.Home),
        BottomNavItem("Inventory", Screen.Inventory.route, Icons.Default.Inventory2),
        BottomNavItem("Orders", Screen.Orders.route, Icons.Default.ShoppingCart),
        BottomNavItem("Analytics", Screen.Analytics.route, Icons.Default.BarChart),
        BottomNavItem("Profile", Screen.Profile.route, Icons.Default.AccountCircle)
    )

    // Drawer destinations
    val drawerNavItems = listOf(
        DrawerNavItem("Dashboard", Screen.Dashboard.route, Icons.Default.GridView),
        DrawerNavItem("Inventory", Screen.Inventory.route, Icons.Default.Inventory2),
        DrawerNavItem("AI Assistant", Screen.AiAssistant.route, Icons.Default.AutoAwesome),
        DrawerNavItem("Suppliers", Screen.Suppliers.route, Icons.Default.Business),
        DrawerNavItem("Transactions", Screen.Transactions.route, Icons.Default.History),
        DrawerNavItem("Analytics", Screen.Analytics.route, Icons.Default.BarChart),
        DrawerNavItem("Notifications", Screen.Notifications.route, Icons.Default.Notifications),
        DrawerNavItem("Settings", Screen.Settings.route, Icons.Default.Settings)
    )

    // Dynamic Top Bar Title
    val topBarTitle = when {
        currentRoute == Screen.Dashboard.route -> "Dashboard Overview"
        currentRoute == Screen.Inventory.route -> "Inventory Management"
        currentRoute == Screen.Orders.route -> "Orders"
        currentRoute?.startsWith("product_details") == true -> "Product Specifications"
        currentRoute?.startsWith("add_product") == true -> "Product Configuration"
        currentRoute == Screen.Scanner.route -> "SKU Laser Scanner"
        currentRoute == Screen.Suppliers.route -> "Suppliers Registry"
        currentRoute == Screen.Transactions.route -> "Transactions Log"
        currentRoute == Screen.Analytics.route -> "Analytics Dashboard"
        currentRoute == Screen.Reports.route -> "Intake Reports"
        currentRoute == Screen.AiAssistant.route -> "Smart AI Assistant"
        currentRoute == Screen.Notifications.route -> "System Alerts"
        currentRoute == Screen.Profile.route -> "Profile Management"
        currentRoute == Screen.Settings.route -> "Settings"
        else -> "HaulIQ"
    }

    if (showScaffolding) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier.width(320.dp),
                    drawerContainerColor = MaterialTheme.colorScheme.surface
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF0F172A)) // Branding Color
                            .padding(horizontal = 24.dp, vertical = 40.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_hauliq_logo),
                                contentDescription = null,
                                modifier = Modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(
                                    text = "HAULIQ",
                                    style = MaterialTheme.typography.headlineSmall,
                                    fontWeight = FontWeight.Black,
                                    color = Color.White,
                                    letterSpacing = 2.sp
                                )
                                Text(
                                    text = "Enterprise Edition",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White.copy(alpha = 0.6f)
                                )
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    drawerNavItems.forEach { item ->
                        val isSelected = currentRoute == item.route
                        NavigationDrawerItem(
                            label = { Text(item.title, fontWeight = FontWeight.Bold) },
                            selected = isSelected,
                            icon = { Icon(imageVector = item.icon, contentDescription = null) },
                            onClick = {
                                coroutineScope.launch { drawerState.close() }
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                            shape = RoundedCornerShape(12.dp)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))
                    
                    // Logout button
                    NavigationDrawerItem(
                        label = { Text("Logout", color = MaterialTheme.colorScheme.error, fontWeight = FontWeight.Bold) },
                        selected = false,
                        icon = { Icon(imageVector = Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null, tint = MaterialTheme.colorScheme.error) },
                        onClick = {
                            coroutineScope.launch { drawerState.close() }
                            navController.navigate(Screen.Login.route) {
                                popUpTo(0) { inclusive = true }
                            }
                        },
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 24.dp),
                        shape = RoundedCornerShape(12.dp)
                    )
                }
            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = topBarTitle,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleLarge
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                coroutineScope.launch { drawerState.open() }
                            }) {
                                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.background
                        )
                    )
                },
                bottomBar = {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface,
                        tonalElevation = 8.dp
                    ) {
                        bottomNavItems.forEach { item ->
                            val isSelected = currentRoute == item.route
                            NavigationBarItem(
                                selected = isSelected,
                                onClick = {
                                    navController.navigate(item.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                label = { Text(item.title, fontWeight = FontWeight.Bold) },
                                icon = { Icon(imageVector = item.icon, contentDescription = null) },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = MaterialTheme.colorScheme.primary,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                                )
                            )
                        }
                    }
                }
            ) { paddingValues ->
                NavGraph(
                    navController = navController,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    } else {
        // No drawer/bar scaffold for Login, Register, Splash
        NavGraph(
            navController = navController
        )
    }
}
