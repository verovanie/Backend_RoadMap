package com.backend.roadMap.RestController;


import com.backend.roadMap.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;

    // Define @PostConstruct to load the data - only once
    @PostConstruct
    public void loadData(){
        theStudent = new ArrayList<>();

        theStudent.add(new Student("Shubham", "Singh"));
        theStudent.add(new Student("Arjun", "Patel"));
        theStudent.add(new Student("Ishaan", "Singh"));

    }

    // Define Endpoint "/student" - return list of students
    @GetMapping("/student")
    public List<Student> getStudents(){

        return theStudent;
    }

    // Define Endpoint to retrieve a single student Data
    @GetMapping("/student/{studentID}")
    public Student getStudent(@PathVariable int studentID){

        return theStudent.get(studentID);
    }

}
