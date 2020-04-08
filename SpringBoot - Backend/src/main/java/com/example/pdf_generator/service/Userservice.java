package com.example.pdf_generator.service;

import com.example.pdf_generator.model.UserDetail;
import org.springframework.stereotype.Service;

@Service
public class Userservice {


    public UserDetail dumbdata(){
        UserDetail dummy=new UserDetail();
        dummy.setName("Aprajita");
        dummy.setAge("23");
        dummy.setCountry("India");
        return dummy;
    }
}
