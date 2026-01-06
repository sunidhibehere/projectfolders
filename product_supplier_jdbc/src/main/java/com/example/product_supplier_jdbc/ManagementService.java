package com.example.product_supplier_jdbc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ManagementService {
    private final SupplierDAO supplierDao;
    private final ProductDAO productDao;

    public ManagementService(SupplierDAO supplierDao, ProductDAO productDao) {
        this.supplierDao = supplierDao;
        this.productDao = productDao;
    }

    public long addSupplier(String name, String contactInfo) {
        try {
            return supplierDao.insertSupplier(name, contactInfo);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add supplier", e);
        }
    }

    public long addProductForSupplier(String name, BigDecimal price, long supplierId) {
        try {
            //if the supplier does not exist.
            Optional<Supplier> supplier = supplierDao.findById(supplierId);
            if (supplier.isEmpty()) {
                throw new IllegalArgumentException("Supplier " + supplierId + " does not exist");
            }
            return productDao.insertProduct(name, price, supplierId);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add product", e);
        }
    }

    public List<Product> listProductsBySupplier(long supplierId) {
        try {
            return productDao.findBySupplier(supplierId);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch products for supplier " + supplierId, e);
        }
    }

    public void updateProductPrice(long productId, BigDecimal newPrice) {
        try {
            int updated = productDao.updatePrice(productId, newPrice);
            if (updated == 0) {
                throw new IllegalArgumentException("Product " + productId + " not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update product price", e);
        }
    }

    
     //Delete a supplier and (because of ON DELETE CASCADE) also remove its products.
     
    public void deleteSupplier(long supplierId) {
        try {
            int deleted = supplierDao.deleteSupplier(supplierId);
            if (deleted == 0) {
                throw new IllegalArgumentException("Supplier " + supplierId + " not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete supplier " + supplierId, e);
        }
    }
}