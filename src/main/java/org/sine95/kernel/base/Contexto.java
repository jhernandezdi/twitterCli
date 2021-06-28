package org.sine95.kernel.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Contexto implements Map<String, Object> {
	/*-------------Parte Constantes--------*/
	public static final String REQUEST="request";
	public static final String RESPONSE="response";
	public static final String TICKET="ticket";
	public static final String STRTICKET="strTicket";
	public static final String SKIP_RECALCULATE_SESSION_EXPIRES="skipRecalculateSessionExpires";
	public static final String LOGIN="login";
	public static final String GRUPOS="grupos";
	public static final String CLAVE_SEGURIDAD = "clave_seguridad";
	public static final String URL_SOLICITADA = "url_solicitada";
	public static final String ID_SESION = "id_sesion";
	/*---------Fin Parte Constantes--------*/
	
	
	/*------------Parte estática--------*/
	private static Map<Long,Contexto> contextos=new HashMap<Long, Contexto>();
	
	public static Contexto init()
	{
		long id = Thread.currentThread().getId();
		Contexto ctx=new Contexto();
		contextos.put(id, ctx);
		return ctx;
	}
	
	public static void close() {
		
		Contexto ctx=Contexto.get();
		if(ctx!=null)
		{
			ctx.clear();
			long id = Thread.currentThread().getId();
			contextos.remove(id);
		}
	}
	
	public static Contexto get()
	{
		long id = Thread.currentThread().getId();
		return contextos.get(id);
	}
	/*----------------------------------*/
	/*----------Parte no estática-------*/
	private Map<String,Object> data=new HashMap<String, Object>();
	
	private Contexto()
	{
		super();
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public boolean containsKey(Object key) {
		return data.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return data.containsValue(value);
	}

	public Object get(Object key) {
		return data.get(key);
	}

	public Object put(String key, Object value) {
		return data.put(key, value);
	}

	public Object remove(Object key) {
		return data.remove(key);
	}

	public void putAll(Map<? extends String, ? extends Object> m) {
		data.putAll(m);
	}

	public void clear() {
		data.clear();
	}

	public Set<String> keySet() {
		return data.keySet();
	}

	public Collection<Object> values() {
		return data.values();
	}

	public Set<Entry<String, Object>> entrySet() {
		return data.entrySet();
	}

	public boolean equals(Object o) {
		return data.equals(o);
	}

	public int hashCode() {
		return data.hashCode();
	}

	public Object getOrDefault(Object key, Object defaultValue) {
		return data.getOrDefault(key, defaultValue);
	}

	public void forEach(BiConsumer<? super String, ? super Object> action) {
		data.forEach(action);
	}

	public void replaceAll(BiFunction<? super String, ? super Object, ? extends Object> function) {
		data.replaceAll(function);
	}

	public Object putIfAbsent(String key, Object value) {
		return data.putIfAbsent(key, value);
	}

	public boolean remove(Object key, Object value) {
		return data.remove(key, value);
	}

	public boolean replace(String key, Object oldValue, Object newValue) {
		return data.replace(key, oldValue, newValue);
	}

	public Object replace(String key, Object value) {
		return data.replace(key, value);
	}

	public Object computeIfAbsent(String key, Function<? super String, ? extends Object> mappingFunction) {
		return data.computeIfAbsent(key, mappingFunction);
	}

	public Object computeIfPresent(String key,
			BiFunction<? super String, ? super Object, ? extends Object> remappingFunction) {
		return data.computeIfPresent(key, remappingFunction);
	}

	public Object compute(String key, BiFunction<? super String, ? super Object, ? extends Object> remappingFunction) {
		return data.compute(key, remappingFunction);
	}

	public Object merge(String key, Object value,
			BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
		return data.merge(key, value, remappingFunction);
	}

	@SuppressWarnings("unchecked")
	public <T> T getAs(String key) {
		return (T)data.get(key);
	}
	
	public String getAsString(String key) {
		return (String)data.get(key);
	}
}
