package org.sine95.kernel.util;

import java.io.IOException;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {

	public static String stringify(Object obj) throws JsonProcessingException
	{
		return stringify(obj, null);
	}

	@SuppressWarnings({ "unchecked" })
	public static Map<String, Object> toMap(Object obj) throws JsonProcessingException
	{
		ObjectMapper mapper = getMapper(null);
		return mapper.convertValue(obj, Map.class);
	}

	public static String stringify(Object obj, DateFormat dateFormat) throws JsonProcessingException
	{
		ObjectMapper mapper = getMapper(dateFormat);
		return mapper.writeValueAsString(obj);
	}
	private static ObjectMapper getMapper(DateFormat dateFormat) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		if (dateFormat!=null)
		{
			mapper.setDateFormat(dateFormat);
		}
		return mapper;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(Object obj,DateFormat dateFormat) throws JsonProcessingException
	{
		ObjectMapper mapper = getMapper(dateFormat);
		return mapper.convertValue(obj, Map.class);
	}

	public static <T> T toObject(Map<String, Object> data, Class<T> clase) throws JsonProcessingException, IOException
	{
		return toObject(data,clase,null); 
	}

	public static <T> T toObject(Map<String, Object> data, Class<T> clase, DateFormat dateFormat) throws JsonProcessingException, IOException
	{
		String sData = stringify(data,dateFormat);
		return parse(sData,clase,dateFormat); 
	}

	public static <T> T parse(String data,Class<T> clase) throws JsonParseException, JsonMappingException, IOException
	{
		return parse(data, clase, null);
	}
	

	public static <T> T parse(String data,Class<T> clase, DateFormat dateFormat) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = getMapper(dateFormat);
		return mapper.readValue(data, clase);
	}

	public static <T> Object copy(Object from,Class<T> to) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException
	{
		return copy(from,to,null);
	}

	public static <T> Object copy(Object from,Class<T> to, DateFormat dateFormat) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException
	{
		
		return parse(stringify(from,dateFormat),to,dateFormat);
	}
	
	public static Map<String,Object> parseMap(String data) throws JsonParseException, JsonMappingException, IOException
	{
		return parseMap(data,null);
	}

	public static Map<String,Object> parseMap(String data, DateFormat dateFormat) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = getMapper(dateFormat);
		return mapper.readValue(data, new TypeReference<Map<String,Object>>(){});
	}

 }
