package com.hackers.mycommerce.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("id") String id) {
        return "hello! " + id;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("id") String id) {
        Hello hello = new Hello();
        hello.setId(id);
        return hello;
    }

    @GetMapping("hello-view")
    public String hello(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("data" , name);
        return "hello";
    }

    static class Hello {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

}
