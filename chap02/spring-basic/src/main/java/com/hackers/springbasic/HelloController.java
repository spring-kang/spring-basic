package com.hackers.springbasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
