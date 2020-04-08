package com.marketing.dig.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.marketing.dig.controllers.restclient.IRestClient;
import com.marketing.dig.zdao.IPruebaDAO;
import com.marketing.dig.zdto.PruebaDTO;
import com.marketing.dig.zdto.RequestOV;
import com.marketing.dig.zdto.ResponseOV;
import com.marketing.dig.zdto.TipoIncidenciaDTO;



@Service
public class PruebaService  implements IPruebaService{
	
	@Autowired
	private IPruebaDAO iPruebaDAO;
	
	@Autowired
	private IRestClient iRestClient;

	@Override
	public List<PruebaDTO> consultaCatalogoOfer() throws SQLException {
		
		return iPruebaDAO.consultaCatalogoOfer();
	}

	@Override
	public ResponseOV consultaServicioRest(String ov) throws Exception {
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap();
	     
	      headers.add("Accept-Language", "es");
	      
	      RequestOV ovs =  RequestOV.builder()
				 .ordenVerificacion(ov)
				 .build();	
		// instalar plugin marketplace Spring Tools 3 Add-On for Spring Tools 4
		//ResponseOV respov= iRestClient.executeRestService("https://www.ruv.org.mx/RuvAllServicesWEB/validarFechaTipoOV", "POST", headers, ovs, ResponseOV.class);
	      ResponseOV respov= iRestClient.executeRestService("https://www.ruv.org.mx/RuvAllServicesWEB/validaSIG", "POST", headers, ovs, ResponseOV.class);
		return respov;
	}

	@Override
	public List<TipoIncidenciaDTO> consultaCatalogoInc() throws Exception {
		
		return iPruebaDAO.consultaTipoInc();
	}

	

}
