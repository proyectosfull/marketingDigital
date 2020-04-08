package com.marketing.dig.service;

import java.sql.SQLException;
import java.util.List;

import com.marketing.dig.zdto.PruebaDTO;
import com.marketing.dig.zdto.ResponseOV;
import com.marketing.dig.zdto.TipoIncidenciaDTO;

public interface IPruebaService {
	public List<PruebaDTO> consultaCatalogoOfer() throws SQLException;
	public ResponseOV consultaServicioRest(String ov) throws Exception;
	
	public List<TipoIncidenciaDTO> consultaCatalogoInc() throws Exception;
}
