package com.xworkz.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.springmvc.dao.JavaMailDao;
import com.xworkz.springmvc.dto.MailDto;

@Service
public class MailServicesImpl implements MailService {

	@Autowired
	private JavaMailDao javaMailDao; 
	
	public boolean validateJavaMailService(MailDto mailDto) {

		boolean isMailSend = this.javaMailDao.sendMail(mailDto);
		
		return isMailSend;
	}

}
