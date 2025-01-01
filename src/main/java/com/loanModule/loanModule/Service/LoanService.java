package com.loanModule.loanModule.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanModule.loanModule.Dao.CustomerDAO;
import com.loanModule.loanModule.Dao.ResponseEligibility;
import com.loanModule.loanModule.Entity.Customer;
import com.loanModule.loanModule.Repository.CustomerRepository;


@Service
public class LoanService {

   @Autowired
   private CustomerRepository customerRepository;
   
   public Customer getCustomerById(Long customerId) {
       // Fetch customer by ID. If not found, throw an exception or handle it appropriately.
       return customerRepository.findById(customerId)
               .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
   }

 

  
//   public ResponseEligibility checkLoanEligibility(CustomerDAO customerDao) {
//       ResponseEligibility newResponse = new ResponseEligibility();
//       
//       // Fetch customer data
//       Optional<Customer> customerOptional = customerRepository.findById(customerDao.getCustomerId());
//       if (!customerOptional.isPresent()) {
//           newResponse.setIsApproved("Rejected");
//           newResponse.setResponseMessages("You are not an existing customer.");
//           return newResponse;
//       }
//
//       Customer customer = customerOptional.get();
//
//       // Eligibility logic
//       StringBuilder rejectionReasons = new StringBuilder();
//       boolean eligible = true;
//
//       // 1. Minimum Credit Score
//       if (customerDao.getCreditScore() < 650) {
//           eligible = false;
//           rejectionReasons.append("Credit score below 650. ");
//       }
//
//       // 2. Outstanding Loan Limit
//       if (customerDao.getTotalDebt() > 10000) {
//           eligible = false;
//           rejectionReasons.append("Outstanding loans exceed $10,000. ");
//       }
//
//       // 3. Income-to-Debt Ratio (IDR)
//       double yearlyIncome = 50000; // Example; fetch from DB or API if needed
//       double idr = customerDao.getTotalDebt() / yearlyIncome;
//       if (idr >= 0.40) {
//           eligible = false;
//           rejectionReasons.append("Income-to-Debt Ratio exceeds 40%. ");
//       }
//
//       // 4. Employment Status
//       if ("Unemployed".equalsIgnoreCase(customer.getEmploymentStatus())) {
//           eligible = false;
//           rejectionReasons.append("Employment status is Unemployed. ");
//       }
//
//       // 5. Account Age Check (1 year minimum)
//       LocalDate currentDate = LocalDate.now();  // Define currentDate as the current date
//
//       LocalDate accountCreatedDate = customer.getAccountCreationDate();  // This is already LocalDate
//       long accountAgeInMonths = ChronoUnit.MONTHS.between(accountCreatedDate, currentDate);
//
//       if (accountAgeInMonths < 12) {
//           eligible = false;
//           rejectionReasons.append("Account age is less than 1 year. ");
//       }
//
//       if (eligible) {
//           newResponse.setIsApproved("Approved");
//           newResponse.setResponseMessages("You are eligible for a loan in the current cycle.");
//           // Update loan status and return response
//           customer.setLoanStatus("Approved");
//           customer.setEmploymentStatus(customerDao.getEmploymentStatus());
//           customer.setCreditScore(customerDao.getCreditScore());
//           customer.setTotalDebt(customerDao.getTotalDebt());
//           customerRepository.save(customer);
//       } else {
//           newResponse.setIsApproved("Rejected");
//           newResponse.setResponseMessages(rejectionReasons.toString());
//           // Update loan status to "Rejected" in the database when rejected
//           customer.setLoanStatus("Rejected");
//           customer.setEmploymentStatus(customerDao.getEmploymentStatus());
//           customer.setCreditScore(customerDao.getCreditScore());
//           customer.setTotalDebt(customerDao.getTotalDebt());
//           customerRepository.save(customer);
//       }
//
//       return newResponse;
//   }
	public ResponseEligibility checkLoanEligibility(CustomerDAO customerDao) {
		ResponseEligibility newResponse = new ResponseEligibility();

		// Fetch customer data
		Optional<Customer> customerOptional = customerRepository.findById(customerDao.getCustomerId());
		if (!customerOptional.isPresent()) {
			newResponse.setIsApproved("Rejected");
			newResponse.setResponseMessages("You are not an existing customer.");
			return newResponse;
		}

		Customer customer = customerOptional.get();

		// Eligibility logic
		StringBuilder rejectionReasons = new StringBuilder();
		boolean eligible = true;

		// 1. Minimum Credit Score
		if (customerDao.getCreditScore() < 650) {
			eligible = false;
			rejectionReasons.append("Credit score below 650. ");
		}

		// 2. Outstanding Loan Limit
		if (customerDao.getTotalDebt() > 10000) {
			eligible = false;
			rejectionReasons.append("Outstanding loans exceed $10,000. ");
		}

		// 3. Income-to-Debt Ratio (IDR)
		double yearlyIncome = 50000; // Example; fetch from DB or API if needed
		double idr = customerDao.getTotalDebt() / yearlyIncome;
		if (idr >= 0.40) {
			eligible = false;
			rejectionReasons.append("Income-to-Debt Ratio exceeds 40%. ");
		}

		// 4. Employment Status
		if ("Unemployed".equalsIgnoreCase(customer.getEmploymentStatus())) {
			eligible = false;
			rejectionReasons.append("Employment status is Unemployed. ");
		}

		// 5. Account Age Check (1 year minimum)
		LocalDate currentDate = LocalDate.now(); // Define currentDate as the current date

		LocalDate accountCreatedDate = customer.getAccountCreationDate(); // This is already LocalDate

		if (accountCreatedDate == null) {
			eligible = false;
			rejectionReasons.append("Account creation date is missing. ");
		} else {
			long accountAgeInMonths = ChronoUnit.MONTHS.between(accountCreatedDate, currentDate);

			if (accountAgeInMonths < 12) {
				eligible = false;
				rejectionReasons.append("Account age is less than 1 year. ");
			}
		}

		// Final check and response setting
		if (eligible) {
			newResponse.setIsApproved("Approved");
			newResponse.setResponseMessages("You are eligible for a loan in the current cycle.");
			// Update loan status and return response
			customer.setLoanStatus("Approved");
			customer.setEmploymentStatus(customerDao.getEmploymentStatus());
			customer.setCreditScore(customerDao.getCreditScore());
			customer.setTotalDebt(customerDao.getTotalDebt());
			customerRepository.save(customer);
		} else {
			newResponse.setIsApproved("Rejected");
			newResponse.setResponseMessages(rejectionReasons.toString());
			// Update loan status to "Rejected" in the database when rejected
			customer.setLoanStatus("Rejected");
			customer.setEmploymentStatus(customerDao.getEmploymentStatus());
			customer.setCreditScore(customerDao.getCreditScore());
			customer.setTotalDebt(customerDao.getTotalDebt());
			customerRepository.save(customer);
		}

		return newResponse;
	}

}