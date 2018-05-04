package com.ejsistemas.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ejsistemas.cursomc.services.DBService;
import com.ejsistemas.cursomc.services.EmailService;
import com.ejsistemas.cursomc.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String stratagy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException{
		if(!"create".equals(stratagy)){
			return false;
		}
		
		dbService.instanteateTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService(){
		return new SmtpEmailService();
	}
}
