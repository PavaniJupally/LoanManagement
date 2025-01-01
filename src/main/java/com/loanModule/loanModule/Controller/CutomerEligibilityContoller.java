package com.loanModule.loanModule.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanModule.loanModule.Dao.CustomerDAO;
import com.loanModule.loanModule.Dao.ResponseEligibility;
import com.loanModule.loanModule.Entity.Customer;
import com.loanModule.loanModule.Service.LoanService;

@RestController
@CrossOrigin
@RequestMapping("v1/users")
public class CutomerEligibilityContoller {
	
	
	@Autowired
	private LoanService loanService;
	
	 @GetMapping("/{id}")
	 public Customer getCustomerById(@PathVariable Long id) {
	        return loanService.getCustomerById(id);
	 }

		@PostMapping("/eligibility")
		public ResponseEligibility checkLoanEligibility(@RequestBody CustomerDAO customerData) {
			return loanService.checkLoanEligibility(customerData);
		}
//	 @PostMapping("/eligibility")
//	 public ResponseEligibility checkLoanEligibility(@RequestBody CustomerDAO customerData) {
//			// Convert CustomerDAO to Customer entity
//			Customer customer = new Customer();
//			customer.setCreditScore(customerData.getCreditScore());
//			customer.setTotalDebt(customerData.getTotalDebt());
//			customer.setEmploymentStatus(customerData.getEmploymentStatus());
//			customer.setAccountCreationDate(customerData.getAccountCreationDate());
//
//			// Use the service to check loan eligibility
//			return loanService.checkLoanEligibility(customer);
//	 }

	
	 
	@GetMapping("hi")
     public String welcome() {
		return "Hi currently you in welcome CutomerEligibilityContoller..!!!!";
	}
	
	
	@GetMapping("bye")
    public String bye() {
		return "Hi currently you in bye CutomerEligibilityContoller..!!!!";
	}
}

