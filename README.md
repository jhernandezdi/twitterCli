# twitterCli
Para lanzar la práctica primero hay que compilar el proyecto desde maven.
Ejecutar
	mvn
 
Este script genera un .war en el directorio /target

Para ejecutar desde línea de comandos:
	java -jar <nombre del war>
	
Hay un pequeño .bat para ello
	run.bat
	
Una vez arrancado, empezará a cargar tweets en la BD, según los criterios espcificados en el fichero de configuración:

	src\main\resources\ConfigurationData.json
	
Los parámetros de interés a efectos de la práctica son:
	NumMinSuscriptoresUsuarioParaPersistir
	IdiomasPermitidosParaPersistir
	MaxNumHashTags
	
La BD es org.hsqldb. Es una BD SQL en memoria que viene embebida en Spring.

El acceso a los servicios vendrá a través de las siguientes urls:

	http://localhost:8080/api/gestiontweets.Tweets              (Get)
	http://localhost:8080/api/gestiontweets.ValidarTweet/200    (Put) --> Cambiar el valor (200) por el id del tweet. Es un id secuencial, no el id real del tweet. Está hecho así para facilitar el uso del api rest en las pruebas
	http://localhost:8080/api/gestiontweets.TweetsValidos       (Get)
	http://localhost:8080/api/gestiontweets.HashtagsMasUsados   (Post) --> Poner content-type = application/json. Requiere un parámetro en el body: {"maxHashtags":<num_máximo>}  ; donde <num_máximo> es el número máximo de hashtags que se devuelven. Si no se especifica (null), se toma el valor indicado en el fichero de configuración