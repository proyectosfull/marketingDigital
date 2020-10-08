package com.marketing.dig.zdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import com.marketing.dig.zdto.PruebaDTO;
import com.marketing.dig.zdto.TipoIncidenciaDTO;

@Component("pruebaDAO")
public class PruebaDAO  implements IPruebaDAO{
	
private NamedParameterJdbcTemplate jdbcTemplate;
private SimpleJdbcCall procReadActor;


	
	@Autowired
	@Qualifier("dataSource")
	private void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		 this.procReadActor = new SimpleJdbcCall(dataSource).withSchemaName("catalogo").withCatalogName("RUV").withProcedureName("ObtenerEstatusPagos");
		
	}

	@Override
	public List<PruebaDTO> consultaCatalogoOfer() {
		return jdbcTemplate.query("select * from CatalogoEstatusOferente", new RowMapper<PruebaDTO>() {

			@Override
			public PruebaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PruebaDTO cat =  PruebaDTO.builder()
								 .id(rs.getInt("id"))
								 .descripcion(rs.getString("descripcion"))
								 .build();		 
						          
				
				return cat;
			}
			
			
		});
	}
	
	
	@Override
	public List<TipoIncidenciaDTO> consultaTipoInc() throws SQLException {
		// TODO Auto-generated method stub
		Map outs = procReadActor.execute();
		
		 ArrayList<TipoIncidenciaDTO> keyList = new ArrayList<TipoIncidenciaDTO>(outs.values());
		
		return keyList;
	       
	}
}
