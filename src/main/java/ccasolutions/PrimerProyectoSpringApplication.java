package ccasolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Esta es la clase principal de la aplicacion 
//Es donde arranca la aplicacion cuando se ejecuta
//Es donde se ejecuta el metodo main y donde corre la aplicacion SpringBoot
//Debe tener la anotacion @SpringBootApplication

@SpringBootApplication
public class PrimerProyectoSpringApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(PrimerProyectoSpringApplication.class, args);
	}
}


//De aqui, vamos al archivo application.properties en src/main/resources para configurar todo el tema de la conexion a base de datos
//Dale a Run As... Spring Boot Application y en teoria deberia correr bien
//En la consola, entre otra muchas cosas, tiene que salir algo estilo esto:
//Tomcat started on port 8080 (http) with context path '/'

//Una vez esto funciona, creamos un nuevo package, que va a ser el package modelo con la clase mensaje en su interior, vamos para allá
//OJO MUY IMPORTANTE: los packages han de estar dentro del package ccasolutions
//Es decir, que el package modelo ha de ser: package ccasolutions.modelo
//Ya que si no es asi, no llega a leerse

//Siguiente paso, vamos a crear lo que se llama "Estructura de respuestas"
//De nuevo, un nuevo package llamado respuesta, que es el que va a almacenar la clase respuesta

//Siguiente paso, vamos a crear el servicio de guardar los mensajes
//Para ello, como siempre, un nuevo package, el packageDAO, donde se introducen todas las interfaces para el acceso a datos
//DAO: Data Access Object

//Siguiente, package para las clases de servicio, que son las que van a tener todo el codigo de los metodos
//Como siempre, package, creamos una interfaz en la que se va a declarar todos los metodos que la clase de servicio tendra
//Y luego una clase que implemente esa interfaz y a la que se le inyecta la que tiene los metodos CRUD, y en ella se implementan los metodos

//Siguiente, package para la clase controladora
//Es decir, el punto de entrada para que cualquier otra aplicacion externa pueda consumir los servicios

//Algo importante es configurar el CORS, que basicamente son denegaciones entre el traspaso de datos por tema de seguridad
//Siempre se configuran en el backend y han de permitirse los CORS, se hace en el Controlador

//Total por resumir

//1 - Se crea la clase del objeto tipo con el que vamos a trabajar

//2 - Se crea la clase de respuesta, que es la clase que va a almacenar, por un lado los datos que se manejen y por otro los metadatos

//3 - Servicios

//	- IMensajeDAO para implementar el CRUD
//	- IMensajeServicio para declarar los metodos que llamara el controlador
//	- MensajeServicio donde se implementan los metodos del IMensajeServicio

//4 - Controlador, para que otras aplicaciones puedan consumir los servicios.

//¿Se puede hacer que los metodos de IMensajeSevicio se implementen directamente en el Controlador y asi ahorrarse la clase MensajeServicio? SI

//De hecho se pueden hacer todos los metodos directamente en el controlador, ver el metodo borrarMensaje.

















