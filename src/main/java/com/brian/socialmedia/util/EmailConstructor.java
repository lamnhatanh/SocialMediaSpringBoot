package com.brian.socialmedia.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.brian.socialmedia.model.AppUser;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailConstructor {

	@Autowired
	private Environment env;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	// Need: starter mail, jakarta mail from com.sun.mail, and starter thymeleaf
	// Create context for setting variable and add them to the thymeleaf template
	public MimeMessagePreparator constructNewUserEmail(AppUser user, String password) {
		Context context = new Context();
		context.setVariable("user", user);
		context.setVariable("password", password);
		String text = templateEngine.process("newUserEmailTemplate", context);
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub
				MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
				// Don't want to send to junk folder, set priority to 1
				email.setPriority(1);
				// Send you user email
				email.setTo(user.getEmail());
				email.setSubject("Welcome To Orchard");
				email.setText(text, true);
				// Sender from
				email.setFrom(new InternetAddress(env.getProperty("support.email")));
			}			
		};
		return messagePreparator;
	}
	
	public MimeMessagePreparator constructResetPasswordEmail(AppUser user, String password) {
		Context context = new Context();
		context.setVariable("user", user);
		context.setVariable("password", password);
		String text = templateEngine.process("resetPasswordEmailTemplate", context);
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
				email.setPriority(1);
				email.setTo(user.getEmail());
				email.setSubject("New Password - Orchard");
				email.setText(text, true);
				email.setFrom(new InternetAddress(env.getProperty("support.email")));
			}
		};
		return messagePreparator;
	}

	public MimeMessagePreparator constructUpdateUserProfileEmail(AppUser user) {
		Context context = new Context();
		context.setVariable("user", user);
		String text = templateEngine.process("updateUserProfileEmailTemplate", context);
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
				email.setPriority(1);
				email.setTo(user.getEmail());
				email.setSubject("Profile Update - Orchard");
				email.setText(text, true);
				email.setFrom(new InternetAddress(env.getProperty("support.email")));
			}
		};
		return messagePreparator;
	}
	
}
