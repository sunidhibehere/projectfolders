package com.hibernate;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="payment_type")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double amount;
	public Long getId() {
		return id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
