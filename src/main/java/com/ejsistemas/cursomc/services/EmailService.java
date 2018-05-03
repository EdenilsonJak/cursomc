package com.ejsistemas.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.ejsistemas.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
