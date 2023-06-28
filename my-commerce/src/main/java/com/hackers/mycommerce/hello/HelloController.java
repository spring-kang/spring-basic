package com.hackers.mycommerce.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello/v1")
    @ResponseBody
    public HelloStudentDto helloApi(@RequestParam("name")String name) {
        return helloService.getStudent(name);
    }

    @PostMapping("/hello/v1")
    @ResponseBody
    public ResponseEntity<HelloStudentDto> helloApiPost(@RequestBody HelloStudent student) {
        return ResponseEntity.ok().body(helloService.saveStudent(student.getName()));
    }

}
