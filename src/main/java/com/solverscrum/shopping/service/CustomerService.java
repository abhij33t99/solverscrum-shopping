package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Customer;
import com.solverscrum.shopping.exception.CustomerException;
import com.solverscrum.shopping.repository.CustomerRepository;
import com.solverscrum.shopping.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ValidList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerVo> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerVo> customerVos = customers.stream()
                .map(CustomerService::convertToCustomerVo)
                .collect(Collectors.toList());
        return customerVos;
    }

    public CustomerVo getCustomerById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty())
            throw new CustomerException("Customer not found with id :"+id);
        return convertToCustomerVo(customer.get());
    }
    //save/update instead of add
    public String addCustomers(ValidList<CustomerVo> customerVos) {
        List<Customer> customers = customerVos.getList().stream()
                        .map(CustomerService::convertToCustomer)
                                .collect(Collectors.toList());
        customerRepository.saveAll(customers);
        return "Saved all customers";
    }

    public String modifyCustomer(CustomerVo customerVo){
        Optional<Customer> customer1 = customerRepository.findById(customerVo.getCustomerId());
        //always use block for if else
        if (customer1.isEmpty()){
            throw new CustomerException("Customer not found with id :"+customerVo.getCustomerId());
        }
        else {
            Customer customer = convertToCustomer(customerVo);
            customerRepository.save(customer);
        }
        //message should be moved to properties file
        return "Updated!";
    }

    private static Customer convertToCustomer(CustomerVo customerVo) {
        Customer customers = new Customer();
        customers.setCustomerName(customerVo.getCustomerName());
        customers.setAddress(customerVo.getAddress());
        customers.setCity(customerVo.getCity());
        customers.setPostalCode(customerVo.getPostalCode());
        customers.setCountry(customerVo.getCountry());
        return customers;
    }

    public static CustomerVo convertToCustomerVo(Customer customer){
        CustomerVo customerVo = new CustomerVo();
        customerVo.setCustomerId(customer.getCustomerId());
        customerVo.setCustomerName(customer.getCustomerName());
        customerVo.setCity(customer.getCity());
        customerVo.setCountry(customer.getCountry());
        customerVo.setAddress(customer.getAddress());
        customerVo.setPostalCode(customer.getPostalCode());
        return customerVo;
    }
}
