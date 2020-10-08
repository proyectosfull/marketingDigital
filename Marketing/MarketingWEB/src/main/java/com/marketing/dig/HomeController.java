package com.marketing.dig;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marketing.dig.controllers.PruebaController;
import com.marketing.dig.service.IPruebaService;
import com.marketing.dig.zdto.PruebaDTO;
import com.marketing.dig.zdto.RequestExample;
import com.marketing.dig.zdto.ResponseOV;
import com.marketing.dig.zdto.TipoIncidenciaDTO;

@Controller
@RequestMapping("home")
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(PruebaController.class);
	
	
	// https://www.javatpoint.com/spring-security-xml-example
	
	@Autowired
	private IPruebaService service;
	
	@GetMapping(value = "gohome")
	public String goHome() {
		return "homes/home";
	}
	
	@GetMapping(value = "goStore")
	public String goStore() throws Exception {
		//logger.info("store ="+ service.consultaCatalogoInc().toString());
		List<TipoIncidenciaDTO> prueba = service.consultaCatalogoInc();
		return "homes/home";
	}
	
	
	@ResponseBody
	@PostMapping(value = "/search/home")
	public List<PruebaDTO> getSearchResultViaAjax(@RequestBody RequestExample search) throws SQLException {
		 // ejemplo ajax
		logger.info("/search/home ="+search.toString());
		
		List<PruebaDTO> result = service.consultaCatalogoOfer();
		//logic
		return result;

	}
	
	@GetMapping(value = "gorest")
	public String goRest(Model model) throws Exception {
		
		// ejecutamos servicio
		//ResponseOV ovserv = service.consultaServicioRest("50227869001");
		ResponseOV ovserv = service.consultaServicioRest("50196552004");
		model.addAttribute("ov", ovserv);
		return "homes/servrest";
	}
	
	

}
