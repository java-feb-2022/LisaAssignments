// This is a domain model that represents our data, it doesn't hold any business logic. It just represents how it's going to look like and how it's going to be retrieved

package com.lisa.relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="licenses")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, message="Number must be at least 1 character long")
    private Integer number;
    
    @NotNull
    private Date expirationDate;
    
    @NotNull
    @Size(min = 1, message="State must be at least 1 character long")
    private String state;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    
    
    //GETTERS AND SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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