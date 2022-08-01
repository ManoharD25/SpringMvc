package com.xworkz.springmvc.services;

import org.springframework.stereotype.Service;

import com.xworkz.springmvc.dto.MailDto;

@Service
public interface MailService {


	boolean validateJavaMailService(MailDto mailDto);

}
