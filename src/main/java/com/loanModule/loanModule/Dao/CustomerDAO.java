package com.loanModule.loanModule.Dao;

import java.time.LocalDate;

public class CustomerDAO {

	private Long customerId; // Assuming it's needed for future use
	private Long creditScore;
	private Double totalDebt;
	private String employmentStatus;
	private LocalDate accountCreationDate;

	// Default constructor
	public CustomerDAO() {
	}

	// Constructor with parameters
	public CustomerDAO(Long customerId, Long creditScore, Double totalDebt, String employmentStatus,
			LocalDate accountCreationDate) {
		this.customerId = customerId;
		this.creditScore = creditScore;
		this.totalDebt = totalDebt;
		this.employmentStatus = employmentStatus;
		this.accountCreationDate = accountCreationDate;
	}

	// Getters and Setters
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public LocalDate getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(LocalDate accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}
}
