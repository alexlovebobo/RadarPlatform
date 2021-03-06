package casic.ht3.smartcity.radarplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import casic.ht3.smartcity.radarplatform.Customer;
import casic.ht3.smartcity.radarplatform.CustomerRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/customer") // This means URL's start with /demo (after Application path)
public class CustomerController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private CustomerRepository customerRepository;
	
	@PostMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewCustomer (@RequestParam String name
			, @RequestParam String address
			, @RequestParam String gender
			, @RequestParam String phone_num
			, @RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Customer n = new Customer();
		n.setName(name);
		n.setAddress(address);
		n.setGender(gender);
		n.setPassword(password);
		n.setPhone_num(phone_num);
		customerRepository.save(n);
		return "Saved";
	}
	@GetMapping(path="/delete")
	public @ResponseBody String deleteCustomer(@RequestParam String id) {
		// This returns a JSON or XML with the users
		customerRepository.delete(Integer.valueOf(id));
		return "deleted";
	}	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Customer> getAllUsers() {
		// This returns a JSON or XML with the users
		return customerRepository.findAll();
	}
}
