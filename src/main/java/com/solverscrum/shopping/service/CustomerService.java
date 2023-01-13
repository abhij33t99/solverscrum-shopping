package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Customer;
import com.solverscrum.shopping.exception.CustomerException;
import com.solverscrum.shopping.repository.CustomerRepository;
import com.solverscrum.shopping.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solverscrum.shopping.utils.ValidList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//annotations java 5
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerVo> getCustomers() {
//        Generics, type inference java 5
        List<Customer> customers = customerRepository.findAll();
        //stream Java 8
        List<CustomerVo> customerVos = customers.stream()
                .map(CustomerService::convertToCustomerVo)
                .collect(Collectors.toList());
        return customerVos;
    }

    public CustomerVo getCustomerById(Integer id) {
        //optional Java 8
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty())
            throw new CustomerException("Customer not found with id :"+id);
        return convertToCustomerVo(customer.get());
    }
    //save/update instead of add
    public String saveCustomers(ValidList<CustomerVo> customerVos) {
        //stream Java 8
        List<Customer> customers = customerVos.getList().stream()
                        .map(CustomerService::convertToCustomer)
                                .collect(Collectors.toList());
        customerRepository.saveAll(customers);
        return "Added customer successfully !!";
    }

    public String updateCustomer(Integer id ,CustomerVo customerVo){
//        optional java 8
        Optional<Customer> customer1 = customerRepository.findById(id);
        //always use block for if else
        if (customer1.isEmpty()){
            throw new CustomerException("Customer not found with id :"+customerVo.getCustomerId());
        }
        else {
            Customer customer = customer1.get();
            customer.setCustomerName(customerVo.getCustomerName());
            customer.setCity(customerVo.getCity());
            customer.setCountry(customerVo.getCountry());
            customer.setAddress(customerVo.getAddress());
            customer.setPostalCode(customerVo.getPostalCode());
            customerRepository.save(customer);
        }
        //message should be moved to properties file
        return "Updated customer with id : "+id +" !!";
    }

    public String deleteCustomer(Integer id){
        customerRepository.deleteById(id);
        return "Deleted customer with id : "+id;
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
