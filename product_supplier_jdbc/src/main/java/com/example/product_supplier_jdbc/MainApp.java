package com.example.product_supplier_jdbc;

import java.util.List;
import java.math.BigDecimal;

public class MainApp {
	public static void main(String[] args) {
        try {
            DatabaseManager.initializeSchema();

            ManagementService service = new ManagementService(
                    new SupplierDAO(),
                    new ProductDAO()
            );

            // 1) Add new suppliers (returns generated IDs).
            long acmeId = service.addSupplier("Acme Corp", "acme@example.com");
            long globexId = service.addSupplier("Globex Ltd", "contact@globex.test");
            System.out.println("Created suppliers -> Acme:" + acmeId + " Globex:" + globexId);
            
            // 2) Add products linked to a supplier. The service verifies the supplier exists first.
            long widgetId = service.addProductForSupplier("Widget", new BigDecimal("12.50"), acmeId);
            long gadgetId = service.addProductForSupplier("Gadget", new BigDecimal("9.99"), acmeId);
            long doohickeyId = service.addProductForSupplier("Doohickey", new BigDecimal("5.25"), globexId);
            System.out.println("Products added -> " + widgetId + ", " + gadgetId + ", " + doohickeyId);

            // 3) Retrieve all products for a given supplier (Acme).
            List<Product> acmeProducts = service.listProductsBySupplier(acmeId);
            System.out.println("Acme product catalog:");
            acmeProducts.forEach(p -> System.out.println("  " + p));
            
            // 4) Update a product price (and show the result with a fresh read).
            service.updateProductPrice(widgetId, new BigDecimal("14.00"));
            System.out.println("Updated widget price. Fresh read:");
            service.listProductsBySupplier(acmeId).forEach(p -> System.out.println("  " + p));

            // 5) Delete a supplier and observe cascading product deletion (FK ON DELETE CASCADE).
            service.deleteSupplier(acmeId);
            System.out.println("Deleted Acme; querying its products should now return empty:");
            service.listProductsBySupplier(acmeId).forEach(p -> System.out.println("  " + p));
            System.out.println("Globex remains intact:");
            service.listProductsBySupplier(globexId).forEach(p -> System.out.println("  " + p));

            System.out.println("Demo complete.");
        } catch (Exception e) {
            // Loud failure so we can see exactly what went wrong during a demo run.
            e.printStackTrace();
        }
    }     
}
