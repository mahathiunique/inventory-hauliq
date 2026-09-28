# HaulIQ - Smart Warehouse & Inventory Management System

[![Android](https://img.shields.io/badge/Platform-Android-green.svg?logo=android)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Language-Kotlin%201.9-purple.svg?logo=kotlin)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4.svg?logo=jetpackcompose)](https://developer.android.com/jetpack/compose)
[![Architecture](https://img.shields.io/badge/Architecture-MVVM%20%2B%20Clean%20Architecture-orange.svg)]()
[![Database](https://img.shields.io/badge/Database-Room%20(SQLite)%20%2B%20Firebase-red.svg)]()
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

> **HaulIQ** is an intelligent, offline-first mobile warehouse and inventory management platform designed to empower modern logistics, storage hubs, and retail enterprises with predictive inventory intelligence, real-time tracking, barcode scanning, automated report generation, and supply chain visibility.

---

## 📌 Problem Statement

Traditional warehouse and inventory management workflows face severe challenges:
1. **Stockouts & Overstocking**: Inaccurate manual forecasting causes either lost sales due to depleted inventory or locked operating capital in dead-stock / stagnant items.
2. **Manual & Error-Prone Auditing**: Physical stock counts on clipboards and paper spreadsheets introduce counting errors, duplicate entries, and delayed reconciliation.
3. **Lack of Predictive Insights**: Supply chain operators struggle to identify which products are accelerating in velocity and need reordering before shelves are empty.
4. **Poor Offline Operability**: Remote warehouse facilities often suffer from spotty or nonexistent internet connectivity; cloud-only tools freeze and halt operations when disconnected.
5. **Slow Compliance & Reporting**: Generating audit-ready compliance sheets, valuation ledgers, and inventory distribution files is often slow and requires manual data entry into desktop software.

---

## 💡 The Solution

**HaulIQ** solves these operational bottlenecks by providing an intelligent, reactive, offline-first mobile operations center:
- **Offline-First Resilience**: Full operational capability powered by a local Room database, ensuring that stock adjustments, order fulfillment, and audits continue uninterrupted without internet access.
- **Predictive AI Intelligence**: On-device algorithmic rules and heuristics detect low-stock vulnerabilities, flag dead-stock capital traps, and dynamically calculate smart reorder points.
- **Instant Barcode/QR Scanning**: Fast optical recognition using CameraX and ML Kit for error-free receiving, picking, and stock adjustments.
- **Executive Audit & Report Exports**: Native on-device PDF generation and CSV data sheet compilation that can be downloaded to device storage and shared immediately via Android's native share sheet.
- **Visual Analytics**: Interactive data visualization of category distributions, inventory valuations, order lifecycles, and transaction history.

---

## 🌟 Novelty & Key Differentiators

| Feature | Traditional WMS | HaulIQ |
| :--- | :--- | :--- |
| **Forecasting & Alerts** | Reactive (notifies after stockout) | **Proactive & Predictive** (predicts stockouts based on velocity and thresholds) |
| **Dead-Stock Detection** | Manual inspection | **Automated Stagnant Item Flagging** to prevent capital depreciation |
| **Reorder Recommendations** | Fixed static rules | **Dynamic Smart Reorder Guidance** factoring in supplier and velocity |
| **Auditing & Reporting** | Desktop-dependent manual exports | **Instant 1-Click Mobile PDF & CSV Generation** with executive KPI headers |
| **Network Dependency** | Cloud-dependent; fails when offline | **Resilient Offline-First Architecture** with Room persistence |
| **Scanning Hardware** | Expensive industrial scanners ($500+) | **Integrated CameraX & ML Kit** running on standard mobile hardware |

---

## 🚀 Key Features

### 1. 📊 Executive Dashboard & AI Insights
- **KPI Metrics**: Real-time counts of total catalog items, inventory valuations ($), low-stock warnings, and out-of-stock items.
- **Smart AI Insights**: Cards highlighting critical stock shortages, high-demand items, and overstocked items with one-tap restocking triggers.

### 2. 📦 Inventory Management
- **Catalog Browsing**: Search, filter by category (Electronics, Machinery, Furniture, Office Supplies, Consumables), and sort by stock status.
- **Product Details**: SKU, barcode, unit cost, selling price, current quantity, minimum stock threshold, supplier details, and warehouse aisle coordinates.
- **Add / Edit Product**: Fast catalog entry creation with validation preventing duplicate SKUs.

### 3. 📈 Analytics Center & Data Visualizations
- **Category Distribution**: Canvas-drawn interactive donut/pie charts visualizing stock distribution across categories.
- **Financial Valuation**: Real-time calculation of total stored asset value and potential revenue.
- **Activity Timeline**: Chronological ledger of all inventory transactions (Sales, Purchases, Restocks, Adjustments).

### 4. 📄 Reports Center & Multi-Format Export
- **PDF Report Generation**: Native Android `PdfDocument` rendering formatted A4 documents complete with dark-slate company branding, executive KPI cards, inventory tables with stock level indicators, and transaction records.
- **CSV Data Sheets**: Structured tabular comma-separated spreadsheets containing comprehensive product attributes, pricing, and quantities.
- **Direct Device Storage & Sharing**: Files are saved directly to `/sdcard/Download/HaulIQ/` and opened in the native Android system share sheet (Email, Drive, WhatsApp, Print).

### 5. 📷 Barcode & QR Code Scanner
- High-speed camera scanner using **CameraX** and **Google ML Kit** for scanning product barcodes to instantly view or edit stock counts.

### 6. 🛒 Orders & Procurement Tracking
- Manage incoming purchases, customer sales orders, shipment tracking, and order fulfillment status pipelines.

---

## 🛠️ Technology Stack & Why It Was Chosen

| Technology | Purpose | Why It Was Chosen |
| :--- | :--- | :--- |
| **Kotlin 1.9** | Primary Language | Modern, concise, null-safe language officially endorsed by Google for robust Android development. |
| **Jetpack Compose** | Declarative UI | Enables rapid development of dynamic, state-driven, reactive user interfaces with modern Material 3 design tokens. |
| **MVVM + Clean Architecture** | Design Pattern | Clean separation between UI (Presenters/Screens), Business Logic (Domain Models/Repositories), and Data (Room/Firebase), ensuring maintainability and testability. |
| **Android Room (SQLite)** | Local Persistence | Provides robust, type-safe SQLite database caching (`hauliq_database`) ensuring offline-first reliability and sub-millisecond query execution. |
| **Kotlin Coroutines & Flow** | Asynchronous Programming | Reactive, asynchronous data streaming that keeps the UI responsive during heavy disk I/O, report compilation, and background computations. |
| **Dagger Hilt** | Dependency Injection | Standardized, compile-time dependency injection simplifying repository wiring, database providers, and ViewModel lifecycles. |
| **Android PdfDocument & MediaStore API** | Document Generation | Generates vector-sharp PDF documents natively on the device without heavy third-party commercial SDKs and saves safely via scoped storage. |
| **CameraX & Google ML Kit** | Optical Scanning | High-performance, device-agnostic camera control paired with Google's on-device barcode scanning ML model. |
| **Firebase Realtime Database** | Cloud Sync / Remote DB | Scalable cloud database client configured for cross-device syncing and remote warehouse backups. |

---

## 📋 Prerequisites

Before running the project, ensure you have the following installed:

- **Operating System**: macOS, Windows 10/11, or Linux
- **Java Development Kit (JDK)**: **JDK 17** (e.g. OpenJDK 17, Temurin 17, or JetBrains JBR 17)
- **Android Studio**: Android Studio **Hedgehog (2023.1.1)**, **Iguana (2023.2.1)**, **Ladybug**, or newer
- **Android SDK**:
  - `compileSdk`: **34** (Android 14)
  - `targetSdk`: **34** (Android 14)
  - `minSdk`: **24** (Android 7.0 Nougat or higher)
- **Android Emulator or Physical Device**:
  - Android 8.0 (API level 26) or higher recommended (e.g., Pixel 7 / Pixel 8 emulator).

---

## ⚙️ How to Setup & Run

### 1. Clone the Repository
```bash
git clone https://github.com/mahathiunique/inventory-hauliq.git
cd inventory-hauliq
```

### 2. Open in Android Studio
1. Launch Android Studio.
2. Select **Open** and choose the `inventory-hauliq` (or `haulIQ`) directory.
3. Allow Gradle to download dependencies and sync the project automatically.

### 3. Configure JDK 17
1. In Android Studio, navigate to:  
   **Settings / Preferences** > **Build, Execution, Deployment** > **Build Tools** > **Gradle**.
2. Under **Gradle JDK**, ensure **JDK 17** (or Java 17) is selected.

### 4. Run on Emulator or Physical Device
- Click the **Run** button (`Shift + F10`) in Android Studio.
- Alternatively, run via terminal:
```bash
# Build the Debug APK
./gradlew assembleDebug

# Install on a connected device/emulator via ADB
adb install -r app/build/outputs/apk/debug/app-debug.apk

# Launch the app
adb shell am start -n com.hauliq.app/.MainActivity
```

---

## 📂 Project Architecture

```
app/src/main/java/com/hauliq/app/
├── core/
│   ├── components/      # Reusable Compose UI widgets, buttons, shimmer loaders
│   ├── theme/           # Color palettes, Typography, Material 3 Dark/Light themes
│   └── utils/           # ReportExporter (PDF/CSV), Formatters, Constants
├── data/
│   ├── local/           # Room Database, DAOs (Inventory, Orders, Transactions)
│   ├── mapper/          # Entity-to-Domain Model bidirectional mappers
│   ├── remote/          # Firebase Realtime Database repositories & seeders
│   └── repository/      # Room & Firebase repository implementations
├── di/                  # Dagger Hilt dependency injection modules (AppModule, FirebaseModule)
├── domain/
│   ├── model/           # Core domain entities (Product, Order, Transaction, Report)
│   └── repository/      # Repository interface contracts
└── presentation/
    ├── ai/              # AI Assistant screen & smart insights
    ├── analytics/       # Analytics Center, KPI metrics, Charts, Export triggers
    ├── auth/            # Authentication, Splash, Login, Registration
    ├── dashboard/       # Executive Dashboard overview
    ├── inventory/       # Catalog list, Add/Edit product, Detail view
    ├── orders/          # Sales & Purchase order management
    ├── reports/         # Reports Center, audit log history, document export
    └── scanner/         # CameraX Barcode & QR scanner
```

---

## 👩‍💻 Developed By

**Mahathi M**  
*HaulIQ - Smart Warehouse & Inventory Management Platform*
