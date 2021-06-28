package org.sine95.kernel.validator.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.sine95.kernel.base.errores.IError;
import org.sine95.kernel.validator.ISingleValidator;

import com.juanma.twitterCli.errores.ErrorCampoObligatorio;


public class ObligatorioValidator implements ISingleValidator {

	private String clase;
	private String campo;
	
	

	public ObligatorioValidator() {
		super();
	}

	public ObligatorioValidator(String clase, String campo) {
		super();
		this.clase = clase;
		this.campo = campo;
	}

	@Override
	public void init(Map<String, Object> params) {
		clase = (String) params.get("clase");
		campo = (String) params.get("campo");
		
	}

	@Override
	public List<IError> validate(Object obj) {
		List<IError> res=new ArrayList<IError>();
		BeanMap bean=new BeanMap(obj);
		if(bean.get(campo)==null)
		{
			IError err=new ErrorCampoObligatorio(clase, campo);
			res.add(err);
		}
		return res;
	}

}
