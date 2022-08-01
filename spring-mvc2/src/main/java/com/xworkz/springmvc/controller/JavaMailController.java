package com.xworkz.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.springmvc.dto.MailDto;
import com.xworkz.springmvc.services.MailService;

@Controller
public class JavaMailController {

	@Autowired
	private MailService mailService; 
	
	public JavaMailController() {
		System.out.println(getClass().getSimpleName() + " bean created");
	}

	@RequestMapping(value = "/getMailPage.mail")
	public String getMailPageController() {
		System.out.println("getMailPageController method called");
		return "Home";
	}
	
	@RequestMapping(value = "/sendJavaMailController.mail")
	public String sendJavaMailController(@ModelAttribute MailDto mailDto) {
		System.out.println(mailDto);
		boolean isMailSend = this.mailService.validateJavaMailService(mailDto);
		return "Home";
	}
	
	
}
