
package com.sine95.tweetsrv.service.crud.validator;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.errores.IError;
import org.sine95.kernel.base.service.IValidator;
import org.sine95.kernel.validator.ISingleValidator;
import org.sine95.kernel.validator.impl.*;

import com.sine95.tweetsrv.domain.*;
import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.service.crud.ConfigurationServiceCRUD;

////START_{Import}
////END_{Import}
@SuppressWarnings("unused")
public class ConfigurationValidator implements IValidator< Configuration >  {

protected List<ISingleValidator> validadoresUpdate=new ArrayList<ISingleValidator>();
	protected List<ISingleValidator> validadoresInsert=new ArrayList<ISingleValidator>();
	protected Map<String,List<ISingleValidator>> validadoresInsertPorCampo=new HashMap<String, List<ISingleValidator>>();
	protected Map<String,List<ISingleValidator>> validadoresUpdatePorCampo=new HashMap<String, List<ISingleValidator>>();
	
	protected ConfigurationServiceCRUD servicio = null;

	public ConfigurationValidator(ConfigurationServiceCRUD servicio) {
		super();

		genValidadoresDefectoCampoId();

		genValidadoresDefectoCampoKeyid();

		genValidadoresDefectoCampoValue();

		genValidadoresDefectoCampoType();

		genValidadoresDefectoCampoDescription();

		this.servicio = servicio;

		////START_{constructor}
		////END_{constructor}
	}
	

		private void genValidadoresDefectoCampoId()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Configuration","id");
		
			lstUpdate.add(obligatorio);
			//lstInsert.add(obligatorio);


			////START_{genValidadoresDefectoCampoId}
			////END_{genValidadoresDefectoCampoId}
			
			validadoresUpdatePorCampo.put("id", lstUpdate);
			validadoresInsertPorCampo.put("id", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoKeyid()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Configuration","keyid");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			////START_{genValidadoresDefectoCampoKeyid}
			////END_{genValidadoresDefectoCampoKeyid}
			
			validadoresUpdatePorCampo.put("keyid", lstUpdate);
			validadoresInsertPorCampo.put("keyid", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoValue()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Configuration","value");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			////START_{genValidadoresDefectoCampoValue}
			////END_{genValidadoresDefectoCampoValue}
			
			validadoresUpdatePorCampo.put("value", lstUpdate);
			validadoresInsertPorCampo.put("value", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoType()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Configuration","type");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			////START_{genValidadoresDefectoCampoType}
			////END_{genValidadoresDefectoCampoType}
			
			validadoresUpdatePorCampo.put("type", lstUpdate);
			validadoresInsertPorCampo.put("type", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoDescription()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Configuration","description");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			////START_{genValidadoresDefectoCampoDescription}
			////END_{genValidadoresDefectoCampoDescription}
			
			validadoresUpdatePorCampo.put("description", lstUpdate);
			validadoresInsertPorCampo.put("description", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}


@Override
	public List<IError> validateInsert(Configuration obj) {
		List<IError> res=new ArrayList<IError>();
		////START_{validateInsert}
		res.addAll(validateInsertDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		////END_{validateInsert}
		return res;
	}

	@Override
	public List<IError> validateUpdate(Configuration obj) {
		List<IError> res=new ArrayList<IError>();
		////START_{validateUpdate}
		res.addAll(validateUpdateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		////END_{validateUpdate}
		return res;
	}

	

	@Override
	public List<IError> validateDelete(Configuration obj) {
		List<IError> res=new ArrayList<IError>();
		////START_{validateDelete}
		//Realizar las comprobaciones que sean necesarias
		////END_{validateDelete}
		return res;
	}
	
	private List<IError> validateUpdateDefecto(Configuration obj) {
		List<IError> res=new ArrayList<IError>();
		for(ISingleValidator valid: validadoresUpdate)
		{
			res.addAll(valid.validate(obj));
		}
		return res;
	}
	private List<IError> validateInsertDefecto(Configuration obj) {
		List<IError> res=new ArrayList<IError>();
		for(ISingleValidator valid: validadoresInsert)
		{
			res.addAll(valid.validate(obj));
		}
		return res;
	}

////START_{Others}

////END_{Others}

/*
////DELETE_START
////DELETE_END
*/
}
