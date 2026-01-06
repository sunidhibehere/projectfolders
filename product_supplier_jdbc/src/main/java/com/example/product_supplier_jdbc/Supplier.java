package com.example.product_supplier_jdbc;

public class Supplier {
	private final long supplierId;
    private final String supplierName;
    private final String contactInfo;

    public Supplier(long supplierId, String supplierName, String contactInfo) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contactInfo = contactInfo;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public String toString() {
        return "Supplier{id=%d, name='%s', contact='%s'}".formatted(
                supplierId, supplierName, contactInfo);
    }
}
