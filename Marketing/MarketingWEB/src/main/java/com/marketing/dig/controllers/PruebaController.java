package com.marketing.dig.controllers;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marketing.dig.service.IPruebaService;
import com.marketing.dig.zdto.PruebaDTO;

@Controller
@RequestMapping("prueba")
public class PruebaController {
	
	@Autowired
	private IPruebaService iPruebaService;
	
	
	
	
	@Value( "${merketing.saludo}" )
	private String saludo;
	
	
	private final Logger logger = LoggerFactory.getLogger(PruebaController.class);
	
	@GetMapping(value = "catalogo")
	public String getCatalogo(Model model, 
			@ModelAttribute("resultado") String resultado) throws Exception {
		logger.info("ejecutando servicio ="+saludo);
		/*
		 if(true)
		    {
		        throw new Exception("This error message if for demo only.");
		    }
		   */ 
		 
		List<PruebaDTO> cat = iPruebaService.consultaCatalogoOfer();
		model.addAttribute("cat", cat);
		return "homes/prueba";
	}

}
