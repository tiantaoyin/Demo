package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/front")
public class TestController1 {
	@RequestMapping(value="/test")
	public String test(){
		System.out.println("呵呵");
		return "index";
	}
}
