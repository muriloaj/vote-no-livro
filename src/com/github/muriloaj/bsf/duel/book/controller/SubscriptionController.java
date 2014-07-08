package com.github.muriloaj.bsf.duel.book.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.muriloaj.bsf.duel.book.dao.UserDAO;
import com.github.muriloaj.bsf.duel.book.model.User;

@Controller
public class SubscriptionController {

	@RequestMapping("/subscription")
	public String index() {
		return "duelBook/subscriptionForm";
	}	
		
	@RequestMapping("/enroll")
	public String adiciona(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			List<ObjectError> erros = result.getAllErrors();
			for (ObjectError erro : erros) {
				System.out.println("ERROR: " + erro.getDefaultMessage());
			}
			return "duelBook/subscriptionForm";
		}

		new UserDAO().update(user);
		
		return "duelBook/subscriptionClose";
	}


}
