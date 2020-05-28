package pers.huangyuhui.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	@RequestMapping("/NewFile")
	public String test() {
		return "/NewFile";
	}
}
