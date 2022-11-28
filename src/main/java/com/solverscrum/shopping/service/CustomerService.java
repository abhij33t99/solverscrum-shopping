package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Customers;
import com.solverscrum.shopping.exceptions.CustomerNotFoundException;
import com.solverscrum.shopping.repository.CustomerRepository;
import com.solverscrum.shopping.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerVo> getCustomers() {
        List<Customers> customers = customerRepository.findAll();
        List<CustomerVo> customerVos = customers.stream()
                .map(CustomerService::convertToCustomerVo)
                .collect(Collectors.toList());
        return customerVos;
    }

    public CustomerVo getCustomerById(Integer id) throws CustomerNotFoundException {
        Optional<Customers> customer = customerRepository.findById(id);
        if (customer.isEmpty())
            throw new CustomerNotFoundException(id);
        return convertToCustomerVo(customer.get());
    }

    public String addCustomers(ValidList<CustomerVo> customerVos) {
        List<Customers> customers = customerVos.getList().stream()
                        .map(CustomerService::convertToCustomer)
                                .collect(Collectors.toList());
        customerRepository.saveAll(customers);
        return "Saved all customers";
    }

    public String modifyCustomer(CustomerVo customerVo) throws CustomerNotFoundException {
        Customers customer = convertToCustomer(customerVo);
        Optional<Customers> customer1 = customerRepository.findById(customer.getCustomerId());
        if (customer1.isEmpty())
            throw new CustomerNotFoundException(customer.getCustomerId());
        else
            customerRepository.save(customer);
        return "Updated!";
    }

    private static Customers convertToCustomer(CustomerVo customerVo) {
        Customers customers = new Customers();
        customers.setCustomerName(customerVo.getCustomerName());
        customers.setAddress(customerVo.getAddress());
        customers.setCity(customerVo.getCity());
        customers.setPostalCode(customerVo.getPostalCode());
        customers.setCountry(customerVo.getCountry());
        return customers;
    }

    public static CustomerVo convertToCustomerVo(Customers customer){
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
