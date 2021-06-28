# twitterCli
Para lanzar la pr�ctica primero hay que compilar el proyecto desde maven.
Ejecutar
	mvn
 
Este script genera un .war en el directorio /target

Para ejecutar desde l�nea de comandos:
	java -jar <nombre del war>
	
Hay un peque�o .bat para ello
	run.bat
	
Una vez arrancado, empezar� a cargar tweets en la BD, seg�n los criterios espcificados en el fichero de configuraci�n:

	src\main\resources\ConfigurationData.json
	
Los par�metros de inter�s a efectos de la pr�ctica son:
	NumMinSuscriptoresUsuarioParaPersistir
	IdiomasPermitidosParaPersistir
	MaxNumHashTags
	
La BD es org.hsqldb. Es una BD SQL en memoria que viene embebida en Spring.

El acceso a los servicios vendr� a trav�s de las siguientes urls:

	http://localhost:8080/api/gestiontweets.Tweets              (Get)
	http://localhost:8080/api/gestiontweets.ValidarTweet/200    (Put) --> Cambiar el valor (200) por el id del tweet. Es un id secuencial, no el id real del tweet. Est� hecho as� para facilitar el uso del api rest en las pruebas
	http://localhost:8080/api/gestiontweets.TweetsValidos       (Get)
	http://localhost:8080/api/gestiontweets.HashtagsMasUsados   (Post) --> Poner content-type = application/json. Requiere un par�metro en el body: {"maxHashtags":<num_m�ximo>}  ; donde <num_m�ximo> es el n�mero m�ximo de hashtags que se devuelven. Si no se especifica (null), se toma el valor indicado en el fichero de configuraci�n