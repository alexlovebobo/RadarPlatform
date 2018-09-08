package casic.ht3.smartcity.radarplatform;

import org.springframework.data.repository.CrudRepository;

import casic.ht3.smartcity.radarplatform.Customer;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
