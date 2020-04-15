package com.example.pdf_generator.service;

import com.example.pdf_generator.model.UserDetail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Userservice {


    public List<UserDetail> dumbdata(){
        List<UserDetail> listOfObjects=new ArrayList<>();
        UserDetail dummy=new UserDetail();
        dummy.setName("Aprajita");
        dummy.setAge("23");
        dummy.setCountry("India");
        listOfObjects.add(dummy);
        UserDetail dummy1=new UserDetail();
        dummy1.setName("SomeName");
        dummy1.setAge("22");
        dummy1.setCountry("Brazil");
        listOfObjects.add(dummy1);
        return listOfObjects;
    }
}
