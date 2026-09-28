package com.hauliq.app.domain.model

import java.util.Calendar

object SampleData {
    
    private val calendar = Calendar.getInstance()

    val suppliers = listOf(
        Supplier(
            id = "S001",
            name = "Global Tech Logistics",
            contactPerson = "Jane Doe",
            email = "jane.doe@globaltech.com",
            phone = "+1 (555) 019-2834",
            address = "120 Logistics Dr, San Jose, CA 95112",
            categoriesSupplied = listOf("Electronics", "Home Appliances"),
            totalProducts = 45
        ),
        Supplier(
            id = "S002",
            name = "Apex Office Solutions",
            contactPerson = "Mark Johnson",
            email = "m.johnson@apexoffice.com",
            phone = "+1 (555) 438-9012",
            address = "744 Enterprise Way, Suite 100, Chicago, IL 60611",
            categoriesSupplied = listOf("Office Supplies"),
            totalProducts = 18
        ),
        Supplier(
            id = "S003",
            name = "Prime Food Distributors",
            contactPerson = "Sarah Connor",
            email = "s.connor@primefood.com",
            phone = "+1 (555) 789-3210",
            address = "89 Food Hub Blvd, Dallas, TX 75201",
            categoriesSupplied = listOf("Food & Beverages", "Health & Wellness"),
            totalProducts = 62
        ),
        Supplier(
            id = "S004",
            name = "Summit Auto & Industrial",
            contactPerson = "Tom Cruise",
            email = "t.cruise@summitauto.com",
            phone = "+1 (555) 234-5678",
            address = "321 Industry Ave, Detroit, MI 48201",
            categoriesSupplied = listOf("Automotive & Industrial"),
            totalProducts = 29
        ),
        Supplier(
            id = "S005",
            name = "MedCare Pharmaceuticals",
            contactPerson = "Dr. Alice Smith",
            email = "contact@medcarepharma.com",
            phone = "+1 (555) 876-5432",
            address = "50 Biotech Way, Cambridge, MA 02139",
            categoriesSupplied = listOf("Health & Wellness"),
            totalProducts = 34
        )
    )

    val products = mutableListOf(
        Product(
            id = "P001",
            name = "High-Speed Wi-Fi Router AX6000",
            description = "Dual-band gigabit router with Wi-Fi 6 support, 8 external antennas, and smart network management capabilities.",
            barcode = "8806098239012",
            sku = "EL-ROT-AX60",
            category = "Electronics",
            price = 189.99,
            cost = 110.00,
            quantity = 42,
            unit = "pcs",
            supplierName = "Global Tech Logistics",
            batchNumber = "B24-0091",
            expiryDate = null
        ),
        Product(
            id = "P002",
            name = "Ergonomic Mesh Office Chair",
            description = "High back desk chair with adjustable lumbar support, 3D armrests, and dynamic tilt mechanism.",
            barcode = "4006381333931",
            sku = "OF-CHR-ERGO",
            category = "Furniture",
            price = 249.99,
            cost = 140.00,
            quantity = 8,  // Low stock!
            unit = "pcs",
            supplierName = "Apex Office Solutions",
            batchNumber = "B24-0102",
            expiryDate = null
        ),
        Product(
            id = "P003",
            name = "Organic Green Tea Extract (100 Caps)",
            description = "Natural antioxidant dietary supplement for metabolism support and immune booster.",
            barcode = "7613034948012",
            sku = "HW-GTE-100C",
            category = "Consumables",
            price = 19.99,
            cost = 8.50,
            quantity = 150,
            unit = "bottles",
            supplierName = "MedCare Pharmaceuticals",
            batchNumber = "B24-0555",
            expiryDate = getFutureTimestamp(90) // Expiry in 3 months
        ),
        Product(
            id = "P004",
            name = "Heavy Duty Hydraulic Jack 3-Ton",
            description = "Steel floor jack with dual piston quick lift system, safety valve, and rubber saddle pad.",
            barcode = "6901234567890",
            sku = "AU-JCK-3TON",
            category = "Machinery",
            price = 89.50,
            cost = 50.00,
            quantity = 3,  // Low stock!
            unit = "pcs",
            supplierName = "Summit Auto & Industrial",
            batchNumber = "B24-0144",
            expiryDate = null
        ),
        Product(
            id = "P005",
            name = "Premium Colombian Whole Bean Coffee 1kg",
            description = "Single-origin, medium roast coffee beans. Rich chocolate and caramel notes with a smooth finish.",
            barcode = "011110038596",
            sku = "FD-COF-COL1",
            category = "Consumables",
            price = 24.99,
            cost = 12.00,
            quantity = 85,
            unit = "bags",
            supplierName = "Prime Food Distributors",
            batchNumber = "B24-0812",
            expiryDate = getFutureTimestamp(150)
        ),
        Product(
            id = "P006",
            name = "Smart LED Bulb Pack of 4",
            description = "RGB dynamic lightbulbs, compatible with smart home assistance systems, dimmable via app.",
            barcode = "8809023456712",
            sku = "EL-LGT-RGB4",
            category = "Electronics",
            price = 39.99,
            cost = 20.00,
            quantity = 12,  // Low stock!
            unit = "packs",
            supplierName = "Global Tech Logistics",
            batchNumber = "B24-0990",
            expiryDate = null
        ),
        Product(
            id = "P007",
            name = "Ultra Slim Wireless Keyboard & Mouse",
            description = "Rechargeable peripheral combo with 2.4G stable wireless connection for desktops and laptops.",
            barcode = "4901234567894",
            sku = "OF-KBD-SLIM",
            category = "Office Supplies",
            price = 59.99,
            cost = 32.00,
            quantity = 28,
            unit = "sets",
            supplierName = "Apex Office Solutions",
            batchNumber = "B24-0081",
            expiryDate = null
        ),
        Product(
            id = "P008",
            name = "Multivitamin Capsules for Men (90 Count)",
            description = "Complete daily multivitamin complex promoting muscle function, physical energy, and cell health.",
            barcode = "7613030293422",
            sku = "HW-MVI-MEN9",
            category = "Consumables",
            price = 29.99,
            cost = 14.00,
            quantity = 110,
            unit = "bottles",
            supplierName = "MedCare Pharmaceuticals",
            batchNumber = "B24-0610",
            expiryDate = getFutureTimestamp(10) // EXPIRING SOON!
        ),
        Product(
            id = "P009",
            name = "Industrial Air Compressor 50L",
            description = "Quiet and powerful oil-free air compressor with 50-liter tank, perfect for industrial use.",
            barcode = "4900000000009",
            sku = "MA-CMP-50L",
            category = "Machinery",
            price = 450.00,
            cost = 300.00,
            quantity = 5,
            unit = "units",
            supplierName = "Summit Auto & Industrial",
            batchNumber = "B24-0010",
            expiryDate = null
        ),
        Product(
            id = "P010",
            name = "Curved Gaming Monitor 34\"",
            description = "Ultra-wide WQHD resolution, 144Hz refresh rate, 1ms response time for immersive gaming.",
            barcode = "8806098000001",
            sku = "EL-MON-34CU",
            category = "Electronics",
            price = 599.99,
            cost = 350.00,
            quantity = 0, // Out of Stock!
            unit = "pcs",
            supplierName = "Global Tech Logistics",
            batchNumber = "B24-0020",
            expiryDate = null
        ),
        Product(
            id = "P011",
            name = "Conference Table - Mahogany",
            description = "Large 10-seater wooden conference table with built-in cable management.",
            barcode = "4006381000011",
            sku = "FU-TBL-CONF",
            category = "Furniture",
            price = 899.00,
            cost = 500.00,
            quantity = 2,
            unit = "pcs",
            supplierName = "Apex Office Solutions",
            batchNumber = "B24-0030",
            expiryDate = null
        ),
        Product(
            id = "P012",
            name = "Laser Printer - All-in-One",
            description = "Multi-function wireless monochrome laser printer for printing, scanning, and copying.",
            barcode = "4006381000012",
            sku = "OF-PRN-LASR",
            category = "Office Supplies",
            price = 329.99,
            cost = 180.00,
            quantity = 15,
            unit = "pcs",
            supplierName = "Apex Office Solutions",
            batchNumber = "B24-0040",
            expiryDate = null
        ),
        Product(
            id = "P013",
            name = "Pneumatic Drill Set",
            description = "High-performance air-powered drill with multiple attachments for metal and wood.",
            barcode = "4900000000013",
            sku = "MA-DRL-PNEU",
            category = "Machinery",
            price = 120.00,
            cost = 70.00,
            quantity = 10,
            unit = "sets",
            supplierName = "Summit Auto & Industrial",
            batchNumber = "B24-0050",
            expiryDate = null
        ),
        Product(
            id = "P014",
            name = "Standing Desk - Motorized",
            description = "Adjustable height desk with memory presets and durable steel frame.",
            barcode = "4006381000014",
            sku = "FU-DSK-STAN",
            category = "Furniture",
            price = 450.00,
            cost = 250.00,
            quantity = 6,
            unit = "pcs",
            supplierName = "Apex Office Solutions",
            batchNumber = "B24-0060",
            expiryDate = null
        ),
        Product(
            id = "P015",
            name = "Mechanical Tool Chest 5-Drawer",
            description = "Mobile tool storage solution with heavy-duty casters and lockable drawers.",
            barcode = "4900000000015",
            sku = "AU-CST-5DRW",
            category = "Machinery",
            price = 280.00,
            cost = 160.00,
            quantity = 4,
            unit = "units",
            supplierName = "Summit Auto & Industrial",
            batchNumber = "B24-0070",
            expiryDate = null
        ),
        Product(
            id = "P016",
            name = "Whiteboard Markers - 12 Pack",
            description = "Low-odor dry erase markers in various colors for whiteboard use.",
            barcode = "4006381000016",
            sku = "OF-MKR-12PK",
            category = "Office Supplies",
            price = 12.50,
            cost = 4.00,
            quantity = 200,
            unit = "packs",
            supplierName = "Apex Office Solutions",
            batchNumber = "B24-0080",
            expiryDate = null
        ),
        Product(
            id = "P017",
            name = "Safety Goggles - Industrial Grade",
            description = "Impact-resistant safety eyewear with anti-fog coating and adjustable straps.",
            barcode = "4900000000017",
            sku = "AU-GGL-SAFE",
            category = "Machinery",
            price = 9.99,
            cost = 3.50,
            quantity = 75,
            unit = "pcs",
            supplierName = "Summit Auto & Industrial",
            batchNumber = "B24-0090",
            expiryDate = null
        ),
        Product(
            id = "P018",
            name = "HDMI 2.1 Cable 2m",
            description = "High-speed HDMI cable supporting 8K resolution and 120Hz refresh rate.",
            barcode = "8806098000018",
            sku = "EL-CBL-HD21",
            category = "Electronics",
            price = 19.99,
            cost = 7.00,
            quantity = 150,
            unit = "pcs",
            supplierName = "Global Tech Logistics",
            batchNumber = "B24-0100",
            expiryDate = null
        ),
        Product(
            id = "P019",
            name = "Office Stapler - Heavy Duty",
            description = "Reliable desktop stapler capable of binding up to 50 sheets of paper.",
            barcode = "4006381000019",
            sku = "OF-STP-HVY",
            category = "Office Supplies",
            price = 15.99,
            cost = 6.00,
            quantity = 45,
            unit = "pcs",
            supplierName = "Apex Office Solutions",
            batchNumber = "B24-0110",
            expiryDate = null
        ),
        Product(
            id = "P020",
            name = "Filing Cabinet - 3 Drawer",
            description = "Metal filing cabinet for legal-size document storage with central locking system.",
            barcode = "4006381000020",
            sku = "FU-CAB-3DRW",
            category = "Furniture",
            price = 189.00,
            cost = 100.00,
            quantity = 9,
            unit = "pcs",
            supplierName = "Apex Office Solutions",
            batchNumber = "B24-0120",
            expiryDate = null
        )
    )

    val transactions = listOf(
        Transaction("T001", "P001", "High-Speed Wi-Fi Router AX6000", TransactionType.PURCHASE, 50, getPastTimestamp(2), "Admin User"),
        Transaction("T002", "P002", "Ergonomic Mesh Office Chair", TransactionType.SALES, 5, getPastTimestamp(1), "John Clerk"),
        Transaction("T003", "P003", "Organic Green Tea Extract", TransactionType.PURCHASE, 100, getPastTimestamp(3), "Admin User"),
        Transaction("T004", "P005", "Colombian Coffee Bean 1kg", TransactionType.SALES, 15, getPastTimestamp(0), "Jane cashier"),
        Transaction("T005", "P004", "Hydraulic Jack 3-Ton", TransactionType.ADJUSTMENT, -2, getPastTimestamp(4), "Manager Alex")
    )

    val notifications = mutableListOf(
        NotificationItem(
            id = "N001",
            title = "Critical Low Stock Alert",
            message = "Product 'Heavy Duty Hydraulic Jack 3-Ton' is down to 3 pcs. Restock immediately.",
            timestamp = getPastTimestamp(0),
            priority = NotificationPriority.HIGH,
            isRead = false
        ),
        NotificationItem(
            id = "N002",
            title = "Product Expiration Warning",
            message = "Product 'Multivitamin Capsules for Men' (Batch B24-0610) expires in 10 days.",
            timestamp = getPastTimestamp(1),
            priority = NotificationPriority.WARNING,
            isRead = false
        ),
        NotificationItem(
            id = "N003",
            title = "Stock Received Successfully",
            message = "100 units of 'Organic Green Tea Extract' have been added to inventory under Batch B24-0555.",
            timestamp = getPastTimestamp(3),
            priority = NotificationPriority.INFO,
            isRead = true
        )
    )

    val reports = listOf(
        ReportItem("R001", ReportType.INVENTORY, "End-of-Month Stock Valuations", getPastTimestamp(7), "PDF", "2.4 MB"),
        ReportItem("R002", ReportType.SALES, "Q2 Sales Performance Report", getPastTimestamp(14), "Excel", "1.1 MB"),
        ReportItem("R003", ReportType.PURCHASE, "Supplier Intake Audit Log", getPastTimestamp(30), "PDF", "5.8 MB")
    )

    val analytics = AnalyticsSummary(
        salesTrend = listOf(
            ChartPoint("Jan", 12000f),
            ChartPoint("Feb", 15000f),
            ChartPoint("Mar", 18000f),
            ChartPoint("Apr", 14000f),
            ChartPoint("May", 22000f),
            ChartPoint("Jun", 29000f)
        ),
        inventoryTrend = listOf(
            ChartPoint("Jan", 45000f),
            ChartPoint("Feb", 42000f),
            ChartPoint("Mar", 48000f),
            ChartPoint("Apr", 55000f),
            ChartPoint("May", 50000f),
            ChartPoint("Jun", 48000f)
        ),
        fastMovingProducts = listOf(
            "Organic Green Tea Extract" to 124,
            "Colombian Whole Bean Coffee" to 95,
            "Smart LED Bulb Pack" to 60
        ),
        deadStockProducts = listOf(
            "Hydraulic Jack 3-Ton" to 2,
            "Office Chair Ergonomic" to 4
        ),
        turnRate = 4.2,
        monthlyRevenue = 29000.00
    )

    val activityLogs = listOf(
        ActivityLog("L001", "Stock Checked Out", getPastTimestamp(0), "5 units of Ergonomic Chair shipped to invoice #4229", LogType.STOCK_OUT),
        ActivityLog("L002", "New Batch Intake", getPastTimestamp(2), "100 bottles of Green Tea Extract registered under Batch B24-0555", LogType.STOCK_IN),
        ActivityLog("L003", "Low Stock Threshold Tripped", getPastTimestamp(2), "Heavy Duty Hydraulic Jack dropped below 15 units (Current: 3)", LogType.ALERT),
        ActivityLog("L004", "Supplier Profile Added", getPastTimestamp(5), "Apex Office Solutions profile added by system admin", LogType.SYSTEM)
    )

    private fun getPastTimestamp(daysAgo: Int): Long {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_YEAR, -daysAgo)
        return cal.timeInMillis
    }

    private fun getFutureTimestamp(daysAhead: Int): Long {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_YEAR, daysAhead)
        return cal.timeInMillis
    }
}
