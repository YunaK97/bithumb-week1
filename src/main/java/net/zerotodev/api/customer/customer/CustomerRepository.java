package net.zerotodev.api.customer.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);
}
