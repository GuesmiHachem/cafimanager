package com.cafimanager.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafimanager.model.Delegation;
import com.cafimanager.model.Governorat;
import com.cafimanager.repository.DelegationRepository;
import com.cafimanager.sms.SendMessage;

@Controller
@RequestMapping("/admin/sms")
public class SmsController {

	@Autowired
	public SendMessage sendMessage;
	
	@GetMapping("/{to}/{message}")
	public String sms( Model model , @PathVariable("to") String to,@PathVariable("message")  String message) {
		try {
			//sendMessage.send("tel:+21654349839","tel:+216"+to,  message);
			sendMessage.send("tel:+216"+to,"tel:+21654349839",  message);
		//	mes.send("tel:+21697983181", "tel:+21697983181", "Bienvenu! hachem cv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/admin/ville";
	}
	
}
