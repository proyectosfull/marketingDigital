package com.marketing.dig.zdao;

import java.sql.SQLException;
import java.util.List;

import com.marketing.dig.zdto.PruebaDTO;
import com.marketing.dig.zdto.TipoIncidenciaDTO;

public interface IPruebaDAO {
	public List<PruebaDTO> consultaCatalogoOfer() throws SQLException;
	public List<TipoIncidenciaDTO> consultaTipoInc() throws SQLException;
}
