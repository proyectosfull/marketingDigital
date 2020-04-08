package com.marketing.dig.zdto;

import java.io.Serializable;

import com.marketing.dig.zdto.PruebaDTO.PruebaDTOBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class RequestExample implements Serializable{
	
	private static final long serialVersionUID = 2627322985565L;
	private int ids;
	private String descripcions;

}
