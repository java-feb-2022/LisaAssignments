// This is a domain model that represents our data, it doesn't hold any business logic. It just represents how it's going to look like and how it's going to be retrieved

package com.lisa.fullcrudsavetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, message="Expenses must be at least 1 character.")
    private String expDescription;
    
    @NotNull
    @Size(min = 1, message="Vendor must be at least 1 character.")
    private String vendor;
    
    @NotNull(message="Must not be blank")
    @Min(value=1, message = "Must be at least 1 dollar")
    private Double amount;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Expense() {
    }
    
    public Expense(String expDescription, String vendor, Double amount) 	{
		this.expDescription = expDescription;
		this.vendor = vendor;
		this.amount = amount;
	}
    
    //GETTERS AND SETTERS

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpDescription() {
		return expDescription;
	}
	public void setExpDescription(String expDescription) {
		this.expDescription = expDescription;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	// right before it's created, save the date
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}