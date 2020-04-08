package com.marketing.dig.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler({NullPointerException.class, Exception.class})
	public ModelAndView handleException(Exception ex)
	{
	    
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("error");
	    modelAndView.addObject("message", ex.getMessage());
	    return modelAndView;
	}
}
