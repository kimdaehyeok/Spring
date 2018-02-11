package com.spring.example.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.example.restful.dao.CustomerDAO;
import com.spring.example.restful.model.Customer;

/* POST : POST를 통해 해당 URI를 요청하면 리소스를 생성합니다.
 * GET : GET를 통해 해당 리소스를 조회합니다. 리소스를 조회하고 해당 도큐먼트에 대한 자세한 정보를 가져온다.
 * PUT : PUT를 통해 해당 리소스를 수정합니다.
 * DELETE : DELETE를 통해 리소스를 삭제합니다.
 * */
@RestController
public class CustomerRestController
{
    @Autowired
    private CustomerDAO customerDAO;
    
    @GetMapping("/customers")
    public List getCustomers()
    {
        return customerDAO.list();
    }
    
    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id)
    {
        
        Customer customer = customerDAO.get(id);
        if (customer == null)
        {
            System.out.println("null");
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity(customer, HttpStatus.OK);
    }
    
    @PostMapping(value = "/customers")
    public ResponseEntity createCustomer(@RequestBody Customer customer)
    {
        
        customerDAO.create(customer);
        
        return new ResponseEntity(customer, HttpStatus.OK);
    }
    
    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id)
    {
        
        if (null == customerDAO.delete(id))
        {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity(id, HttpStatus.OK);
        
    }
    
    @PutMapping("/customers/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer)
    {
        
        customer = customerDAO.update(id, customer);
        
        if (null == customer)
        {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity(customer, HttpStatus.OK);
    }
}
