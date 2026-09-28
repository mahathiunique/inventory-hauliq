package com.hauliq.app.core.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0015\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0015\u001c\u001d\u001e\u001f !\"#$%&\'()*+,-./0\u00a8\u00061"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "About", "AddProduct", "AiAssistant", "Analytics", "CreateOrder", "Dashboard", "ForgotPassword", "Inventory", "Login", "Notifications", "OrderDetails", "Orders", "ProductDetails", "Profile", "Register", "Reports", "Scanner", "Settings", "Splash", "Suppliers", "Transactions", "Lcom/hauliq/app/core/navigation/Screen$About;", "Lcom/hauliq/app/core/navigation/Screen$AddProduct;", "Lcom/hauliq/app/core/navigation/Screen$AiAssistant;", "Lcom/hauliq/app/core/navigation/Screen$Analytics;", "Lcom/hauliq/app/core/navigation/Screen$CreateOrder;", "Lcom/hauliq/app/core/navigation/Screen$Dashboard;", "Lcom/hauliq/app/core/navigation/Screen$ForgotPassword;", "Lcom/hauliq/app/core/navigation/Screen$Inventory;", "Lcom/hauliq/app/core/navigation/Screen$Login;", "Lcom/hauliq/app/core/navigation/Screen$Notifications;", "Lcom/hauliq/app/core/navigation/Screen$OrderDetails;", "Lcom/hauliq/app/core/navigation/Screen$Orders;", "Lcom/hauliq/app/core/navigation/Screen$ProductDetails;", "Lcom/hauliq/app/core/navigation/Screen$Profile;", "Lcom/hauliq/app/core/navigation/Screen$Register;", "Lcom/hauliq/app/core/navigation/Screen$Reports;", "Lcom/hauliq/app/core/navigation/Screen$Scanner;", "Lcom/hauliq/app/core/navigation/Screen$Settings;", "Lcom/hauliq/app/core/navigation/Screen$Splash;", "Lcom/hauliq/app/core/navigation/Screen$Suppliers;", "Lcom/hauliq/app/core/navigation/Screen$Transactions;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$About;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class About extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.About INSTANCE = null;
        
        private About() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$AddProduct;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "createRoute", "", "productId", "barcode", "app_debug"})
    public static final class AddProduct extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.AddProduct INSTANCE = null;
        
        private AddProduct() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.Nullable()
        java.lang.String productId, @org.jetbrains.annotations.Nullable()
        java.lang.String barcode) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$AiAssistant;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class AiAssistant extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.AiAssistant INSTANCE = null;
        
        private AiAssistant() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Analytics;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Analytics extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Analytics INSTANCE = null;
        
        private Analytics() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$CreateOrder;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class CreateOrder extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.CreateOrder INSTANCE = null;
        
        private CreateOrder() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Dashboard;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Dashboard extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Dashboard INSTANCE = null;
        
        private Dashboard() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$ForgotPassword;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class ForgotPassword extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.ForgotPassword INSTANCE = null;
        
        private ForgotPassword() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Inventory;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Inventory extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Inventory INSTANCE = null;
        
        private Inventory() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Login;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Login extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Login INSTANCE = null;
        
        private Login() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Notifications;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Notifications extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Notifications INSTANCE = null;
        
        private Notifications() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$OrderDetails;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "createRoute", "", "orderId", "app_debug"})
    public static final class OrderDetails extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.OrderDetails INSTANCE = null;
        
        private OrderDetails() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String orderId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Orders;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Orders extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Orders INSTANCE = null;
        
        private Orders() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$ProductDetails;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "createRoute", "", "productId", "app_debug"})
    public static final class ProductDetails extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.ProductDetails INSTANCE = null;
        
        private ProductDetails() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String productId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Profile;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Profile extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Profile INSTANCE = null;
        
        private Profile() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Register;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Register extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Register INSTANCE = null;
        
        private Register() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Reports;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Reports extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Reports INSTANCE = null;
        
        private Reports() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Scanner;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Scanner extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Scanner INSTANCE = null;
        
        private Scanner() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Settings;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Settings extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Splash;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Splash extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Splash INSTANCE = null;
        
        private Splash() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Suppliers;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Suppliers extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Suppliers INSTANCE = null;
        
        private Suppliers() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/core/navigation/Screen$Transactions;", "Lcom/hauliq/app/core/navigation/Screen;", "()V", "app_debug"})
    public static final class Transactions extends com.hauliq.app.core.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.hauliq.app.core.navigation.Screen.Transactions INSTANCE = null;
        
        private Transactions() {
        }
    }
}