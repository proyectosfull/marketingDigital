package com.marketing.dig.zdto;

import java.io.Serializable;

import com.marketing.dig.zdto.RequestExample.RequestExampleBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class RequestOV implements Serializable{
		
		private static final long serialVersionUID = 2627322985525L;
		private String ordenVerificacion;
}
