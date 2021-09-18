package com.swolBros.config;

import java.util.Properties;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@EnableJpaRepositories(basePackages="com.swolBros.repository")
@EntityScan(basePackages="com.swolBros.entity")
public class ApplicationConfig {
	
	
	@Bean
	
	public JavaMailSender getJavaMAilSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		
		
		mailSender.setUsername("jd629908@gmail.com");
		mailSender.setPassword("yuptoizobqtxrpmw");
		
		
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug","true");
		
		
		return mailSender;
		
	}
}
