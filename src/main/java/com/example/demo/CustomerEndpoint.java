package com.example.demo;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

private CustomerRepository customerRepository;
@RestController
@Autowired
@RequestMapping("/Customer")
public class CustomerEndpoint {
    private CustomerRepository customerRepository;

    //GetMapping zwraca wszystkich klientów po ścieżce Customer
    @GetMapping("/Customer")
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    //GetMapping zwraca wszystkich klientów pościeżce Customer po danym ID
    @GetMapping("/Customer/{ID}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable(value = "ID") Long customerId)
            throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + customerId));
        return ResponseEntity.ok().body(customer);
    }
    //PostMapping służy do dodania kolejnego klienta do bazy
    @PostMapping("/Customer")
    public Customer createEmployee(@Valid @RequestBody Customer customer) {
        return  customerRepository.save(customer);
    }

    //PutMapping służy do zaktualizowania informacji o klliencie po danym ID

    @PutMapping("/Customer/{ID}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int ID,@RequestBody Customer customerDetails) {
        Customer updateCustomer = customerRepository.findById(ID)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + ID));

        updateCustomer.setName(customerDetails.getName());
        updateCustomer.setSurname(customerDetails.getSurname());
        updateCustomer.setTelephone(customerDetails.getTelephone());

        customerRepository.save(updateCustomer);

        return ResponseEntity.ok(updateCustomer);
    }

    //DeleteMapping służy do usunięcia klienta z bazy po wpisaniu jego ID
    @DeleteMapping("/Customer/{ID}")
    public String deleteById(@PathVariable("ID") int ID) {
        return "Delete by ID called";
    }
    }


