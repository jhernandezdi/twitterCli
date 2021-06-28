package org.sine95.kernel.validator.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.sine95.kernel.base.errores.IError;
import org.sine95.kernel.validator.ISingleValidator;

import com.juanma.twitterCli.errores.ErrorLongitudCampoCadena;

public class CadenaValidator implements ISingleValidator {

	private String clase;
	private String campo;
	private int maxlength;

	@Override
	public void init(Map<String, Object> params) {
		clase = (String) params.get("clase");
		campo = (String) params.get("campo");
		maxlength=(int) params.get("maxlength");
	}

	public CadenaValidator(String clase, String campo, int maxlength) {
		super();
		this.clase = clase;
		this.campo = campo;
		this.maxlength = maxlength;
	}

	public CadenaValidator() {
		super();
	}

	@Override
	public List<IError> validate(Object obj) {
		List<IError> res=new ArrayList<IError>();
		BeanMap bean=new BeanMap(obj);
		String cad=(String) bean.get(campo);
		if(cad!=null && cad.length()>maxlength)
		{
			IError err=new ErrorLongitudCampoCadena(clase, campo,maxlength);
			res.add(err);
		}
		return res;
	}

}
