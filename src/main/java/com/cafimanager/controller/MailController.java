package com.cafimanager.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafimanager.mail.EmailService;
import com.cafimanager.mail.Mail;

import freemarker.template.TemplateException;

@Controller
@RequestMapping("/admin/mail")
public class MailController {

	@Autowired
    private EmailService emailService;
	
	@GetMapping("/")
	public String sms( Model model ) {
		
		Mail mail = new Mail();
        mail.setFrom("***********");
        mail.setTo("***********");
        mail.setSubject("free 11");

        Map model1 = new HashMap();
        model1.put("name", "Memorynotfound.com");
        model1.put("location", "Belgium");
        model1.put("signature", "https://memorynotfound.com");
        mail.setModel(model1);
        

        try {
			emailService.sendSimpleMessage(mail);
		} catch (MessagingException | IOException | TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/admin/ville";
	}
	
}
