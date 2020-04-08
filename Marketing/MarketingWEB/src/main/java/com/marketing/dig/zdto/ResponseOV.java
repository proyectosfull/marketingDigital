package com.marketing.dig.zdto;

import java.io.Serializable;

import com.marketing.dig.zdto.RequestOV.RequestOVBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class ResponseOV implements Serializable{
	
	private static final long serialVersionUID = 2627322985525L;
	private String errorCode;
	private String httpStatus;
	private String errorMessage;
}
