package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Customers;
import com.solverscrum.shopping.exceptions.CustomerNotFoundException;
import com.solverscrum.shopping.repository.CustomerRepository;
import com.solverscrum.shopping.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customers> getCustomers(){
        return customerRepository.findAll();
    }

    public Customers getCustomerById(Integer id) throws CustomerNotFoundException {
        Optional<Customers> customer = customerRepository.findById(id);
        if(customer.isEmpty())
            throw new CustomerNotFoundException(id);
        return customer.get();
    }

    public String addCustomers(List<CustomerVo> customerVos){
        List<Customers> customers = new ArrayList<>();
        for(CustomerVo customerVo : customerVos){
            customers.add(convertToCustomer(customerVo));
        }
        customerRepository.saveAll(customers);
        return "Saved all customers";
    }

    public String modifyCustomer(Customers customer) throws CustomerNotFoundException {
        Optional<Customers> customer1 = customerRepository.findById(customer.getCustomerId());
        if(customer1.isEmpty())
            throw new CustomerNotFoundException(customer.getCustomerId());
        else
            customerRepository.save(customer);
        return "Updated!";
    }

    public static Customers convertToCustomer(CustomerVo customerVo){
        Customers customers = new Customers();
        customers.setCustomerName(customerVo.getCustomerName());
        customers.setAddress(customerVo.getAddress());
        customers.setCity(customerVo.getCity());
        customers.setPostalCode(customerVo.getPostalCode());
        customers.setCountry(customerVo.getCountry());
        return customers;
    }
}
