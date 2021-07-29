package com.example.demo.web;

import java.security.Principal;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/*
 * 
 *   - by path
 *   - by http-method
 *   - by path params
 *   - by presence /absence of request params
 *   - by presence /absence of request header
 * 	 - by request body media-type  
 * 
 * 
 * 
 *   HTTP methods
 *   
 *   	- GET,HEAD  ==> read-only
 *      - POST      ==> to create unknown/new-resource  | to do control operations like login,register
 *      - PUT       ==> to create / update known resources  
 *      - PATCH     ==> partial update on existing resources
 *      - DELETE    ==> to delete existing resources
 *      - OPTION    ==> to get permissions abt resource
 *      
 *      
 *      - CONNECT
 *      - TRACE
 *      
 *   --------------------------------------------------------------------
 *   
 *      
 *      @RequestParam
 * 
 */

class Todo{
	String title;
	boolean completed;
}

@RestController
public class WelcomeController {

//	
//	@GetMapping(path = "/",params = {"!name"},headers = {"!Accept-Language"})
//	public String welcome() {
//		return "welcome";
//	}
//
//	@PostMapping(path = {"/"},consumes = {"application/json"})
//	public  String create(@RequestBody Todo todo,BindingResult result) {
//		return "created";
//	}
	
	@GetMapping(path = {"/resource1"},produces = {"application/json"})
	public  String getJSON(Principal principal) {
		System.out.println(principal.getName()  +" accessing the /resource1");
		
//		String currentUser=SecurityContextHolder.getContext().getAuthentication().getName();
		
		boolean b=false;
		if(b)
			throw new ResourceNotFoundException("resource not found");
		return "JSON";
	}
	
	
//	public void reqMapping1(
//			@RequestParam(defaultValue = "Unknown") String name,
//			@RequestHeader(value = "Accept-Language") String lang,
//			@CookieValue String cookirValue,
//			@MatrixVariable int q,
//			@PathVariable String petId
//			) {
//		
//	}
//	
	
	
//	
//	@ResponseStatus(code = HttpStatus.NOT_FOUND)
//	@ExceptionHandler(value = {RuntimeException.class})
//	public String exceptionHandler(RuntimeException exception) {
//		return exception.getMessage();
//	}
	
	
	
	
	
//	public void reqMapping2(Principal principal) {
//	}
//	
//	public void reqMapping3(HttpServletRequest request,HttpServletResponse resp,HttpSession session) {
//	}
//	
//	public void reqMapping4(Model model) {
//		model.addAttribute("key", "value"); // request.setAttribute("key","value")
//	}
//	
//	public void reqMapping4(Map<String, String> model) {
//		model.put("key", "value"); // request.setAttribute("key","value")
//	}

	
	
}
