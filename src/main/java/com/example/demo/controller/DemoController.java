package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DemoController {
    private List<Person> students=new ArrayList<>();
    private AtomicLong nextId=new AtomicLong();//this one will make sure that ID is creating automatically.

    @GetMapping("/greetings")
    public String getHelloMessage(){
        return "Hello Emray";
    }


    @PostMapping ("/students")
    public Person createNewStudents(@RequestBody Person  student){
        student.setId(nextId.incrementAndGet());
        students.add(student);
        return student;
        }


}
