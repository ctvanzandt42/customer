package com.example.customer.utils;


import com.example.customer.model.Customer;

import java.util.List;

public class CustomerTestUtils {

    public static Customer createTestCustomer() {
        String fn = Long.toString(System.currentTimeMillis());
        String ln = Long.toString(System.currentTimeMillis());
        String p = Long.toString(System.currentTimeMillis());
        String e = Long.toString(System.currentTimeMillis()) + "@gmail.com";

        Customer customer = new Customer();
        customer.setFirstName(fn);
        customer.setLastName(ln);
        customer.setPhone(p);
        customer.setEmail(e);
        return customer;
    }


    public static Customer findInList(List<Customer> customers, String first, String last, String phone, String email) {
        for (Customer customer : customers) {
            if (customer.getFirstName().equals(first) &&
                    customer.getLastName().equals(last) &&
                    customer.getPhone().equals(phone) &&
                    customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }
}