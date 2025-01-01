package com.loanModule.loanModule.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Marks this class as a JPA Entity
@Table(name = "customer") // Maps the class to the "customer" table in the database
public class Customer {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID
    @Column(name = "customer_id") // Maps this field to the "customer_id" column
    private Long customerId;

    @Column(name = "store_id", nullable = false) // Maps this field to the "store_id" column
    private Long storeId;

    @Column(name = "first_name", length = 50, nullable = false) // Length limit for the column
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "address_id", nullable = false)
    private Long addressId;

    @Column(name = "active") // Boolean fields are mapped as tinyint(1) in most databases
    private Boolean active;    
    
    @Column(name = "authority_id")
    private Long authorityId;
    
    @Column(name = "credit_score")
    private Long creditScore;
    
    @Column(name = "total_debt")
    private Double totalDebt;
            
    @Column(name = "employment_status")
    private String employmentStatus;
    
    @Column(name = "loan_status")
    private String loanStatus;

    @Column(name = "account_creation_date", nullable = false)
	private LocalDate accountCreationDate;

	// Getter and Setter for accountCreationDate
	public LocalDate getAccountCreationDate() {
	    return accountCreationDate;
	}

	public void setAccountCreationDate(LocalDate accountCreationDate) {
	    this.accountCreationDate = accountCreationDate;
	}
    // Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public Long getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Long creditScore) {
		this.creditScore = creditScore;
	}

	public Double getTotalDebt() {
		return totalDebt;
	}

	public void setTotalDebt(Double totalDebt) {
		this.totalDebt = totalDebt;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

}

