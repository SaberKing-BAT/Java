package com.lyc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HellowController {
    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        return "Hello world!";

    }
}
