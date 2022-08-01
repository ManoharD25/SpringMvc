package com.xworkz.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.xworkz.springmvc.dto.MailDto;

@Repository
public interface JavaMailDao {

	boolean sendMail(MailDto mailDto);


}
