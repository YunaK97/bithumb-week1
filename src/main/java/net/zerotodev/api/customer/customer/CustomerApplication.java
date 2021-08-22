package net.zerotodev.api.customer.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication @RequiredArgsConstructor
public class CustomerApplication implements CommandLineRunner {
    private final CustomerRepository customRespository;
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customRespository.deleteAll();
        customRespository.save(new Customer("1","Alice","Smith"));
        customRespository.save(new Customer("2","Bob","Smith"));
        customRespository.save(new Customer("3","Tom","Cruise"));
        System.out.println("고객 이름 전부 찾기");
        for(Customer customer: customRespository.findAll()){
            System.out.println(customer);
        }
        System.out.println("Tom 이라는 이름으로 찾기");
        Customer cus= customRespository.findByFirstName("Tom");
            System.out.println(customRespository.findByFirstName("Tom"));
        System.out.println("성으로 찾기");
         List<Customer> customerList =customRespository.findByLastName("Smith");
         for(Customer customer:customerList ){
             System.out.println(customer);
         }

    }
}
