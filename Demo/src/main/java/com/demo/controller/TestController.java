package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/back")
public class TestController {
	@RequestMapping(value="/test")
	public String test(){
		System.out.println("呵呵");
		return "index";
	}
}
