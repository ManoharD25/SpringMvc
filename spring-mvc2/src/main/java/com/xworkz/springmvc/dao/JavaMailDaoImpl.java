package com.xworkz.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Repository;

import com.xworkz.springmvc.dto.MailDto;

@Repository
public class JavaMailDaoImpl implements JavaMailDao {

	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sendMail(MailDto mailDto) {
		boolean isSent = false;
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

			simpleMailMessage.setFrom("Manohard7@outlook.com");
			simpleMailMessage.setTo(mailDto.getMailId());
			simpleMailMessage.setSubject(mailDto.getSubject());
			simpleMailMessage.setText(mailDto.getMessage());

			javaMailSender.send(simpleMailMessage);
			
//			this.mailSender.send(simpleMailMessage);
			isSent = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isSent;
	}

}
