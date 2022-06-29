package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService){
        this.demoService = demoService;
    }

    @Value("${test.value}")
    private String val;

    @RequestMapping(value = "/display", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String displayMessage(){
        return "HELLO FROM SPRING BOOT " + val;
    }

    @GetMapping("/show/{name}")
    public String showMessage(@PathVariable String name){
        return "HELLO FROM SPRING BOOT AGAIN: " + name;
    }

    @GetMapping("/view")
    public String viewMessage(@RequestParam(value = "name", required = false) String name){
        return "HELLO FROM SPRING BOOT AGAIN & AGAIN: " + name;
    }

    @GetMapping("/list/items")
    public List<String> getListOfItems(){
        return demoService.getListOfItems();
    }

    @GetMapping("/map/items")
    public Map<String, Integer> getMapOfItems(){
        return demoService.getMapOfItems();
    }

    @GetMapping("/test")
    public ResponseEntity<String> testMessage(){
        return ResponseEntity.ok().body("HELLO FROM SPRING BOOT AGAIN & AGAIN & AGAIN");
    }

    @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> student(){
        Student student = new Student("Space", 777);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }



}
