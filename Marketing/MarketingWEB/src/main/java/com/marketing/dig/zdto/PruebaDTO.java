package com.marketing.dig.zdto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class PruebaDTO implements Serializable{
	
	private static final long serialVersionUID = 2629922985565L;
	private int id;
	private String descripcion;
}
