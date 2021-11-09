package com.entities;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Product {
@Id

	private String modelNumber;
	private String productName;
	private String productCategoryName; // washing machine , TV,AC,SmartPhone
	private LocalDate dateofPurchase;
	private int warrentyYears;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Complaint> complaints=new ArrayList<Complaint>();
	
	public List<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(Complaint complaints) {
		this.complaints.add(complaints) ;
	}
	private LocalDate warrantyDate; // should be auto generated
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public LocalDate getDateofPurchase() {
		return dateofPurchase;
	}
	public void setDateofPurchase(LocalDate dateofPurchase) {
		this.dateofPurchase = dateofPurchase;
	}
	public int getWarrentyYears() {
		return warrentyYears;
	}
	public void setWarrentyYears(int warrentyYears) {
		this.warrentyYears = warrentyYears;
	}
	public LocalDate getWarrantyDate() {
		return warrantyDate;
	}
	public void setWarrantyDate(LocalDate warrantyDate) {
		this.warrantyDate = warrantyDate;
	}
	@Override
	public String toString() {
		return "Product [modelNumber=" + modelNumber + ", productName=" + productName + ", productCategoryName="
				+ productCategoryName + ", dateofPurchase=" + dateofPurchase + ", warrentyYears=" + warrentyYears
				+ ", complaints=" + complaints + ", warrantyDate=" + warrantyDate + "]";
	}
	
	
	
}

