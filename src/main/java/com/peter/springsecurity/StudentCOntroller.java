package com.peter.springsecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentCOntroller {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Peter",60),
            new Student(2,"July",100)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("/students")
    public Student addStudents(@RequestBody Student student){
       students.add(student);
       return  student;
    }

    @GetMapping("/all/{id}")
    public Student getAllStudentById(@PathVariable("id") int id) {
       return students.stream()
               .filter(student -> student.getId() == id)
               .findFirst().orElse(null);

    }

    @GetMapping("/csrf-token")
   public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
   }

}
