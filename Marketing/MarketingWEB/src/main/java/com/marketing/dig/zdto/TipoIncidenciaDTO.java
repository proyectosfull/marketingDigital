package com.marketing.dig.zdto;

import java.io.Serializable;

import com.marketing.dig.zdto.PruebaDTO.PruebaDTOBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class TipoIncidenciaDTO implements Serializable{
	
	private static final long serialVersionUID = 2672922985565L;
	private int id;
	private String valor;

}
