package com.juanma.twitterCli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.juanma.twitterCli.config.StartAppConfiguration;
import com.juanma.twitterCli.repository.UtilDB;
import com.juanma.twitterCli.service.ln.ClienteTwitterLNService;

@Component
public class StartUpApp implements ApplicationListener<ContextRefreshedEvent>{

	private final Logger log = LoggerFactory.getLogger(StartUpApp.class);
	
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		log.info("Se ha iniciado la Applicacion");
		
		
		ApplicationContext appCon = event.getApplicationContext();
		StartAppConfiguration sac=appCon.getBean(StartAppConfiguration.class);
		
		UtilDB utilDB=appCon.getBean(UtilDB.class);
		
		
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			URL uFile = classLoader.getResource("ConfigurationData.json");
			InputStream openStream = uFile.openStream();
			String contenido=IOUtils.toString(openStream,"UTF-8" );
			
			utilDB.insert(contenido);
			
		} catch (IOException | ParseException e) {

			e.printStackTrace();
			System.exit(128);
		}
		
		if("S".equalsIgnoreCase(sac.getExecuteInit()))
		{
			// Arrancamos el servicio que enlaza con Twitter
			ClienteTwitterLNService clienteTwitterService = appCon.getBean(ClienteTwitterLNService.class);
			clienteTwitterService.InitCli();
			boolean end = false;
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader (isr);
			while (!end) {
				String texto;
				try {
					texto = br.readLine();
					if (texto.equals("Q")) {
						end = true;
					} else {
						clienteTwitterService.SendTwit(texto);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
