package ccasolutions.controlador;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ccasolutions.modelo.Mensaje;
import ccasolutions.respuesta.Respuesta;
import ccasolutions.servicios.IMensajeServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

//La anotacion @RestController indica que va a ser un servicio Rest, es decir, responde solicitudes Http y devuelve datos tipo JSON
//La anotacion @RequestMapping("url") especifica el prefijo de la URL base para todos los endpoints en esta clase
//La anotacion @GetMapping("url)", indica que es un metodo get y continua la url
//La anotacion @CrossOrigin es para indicar los origines que queremos que la aplicacion permita
//La anotación @RequestBody indica que el parámetro del método de un controlador debe estar vinculado al cuerpo de la solicitud HTTP entrante
//la anotación @PathVariable se usa para vincular una parte de la URL a un parámetro del método

@CrossOrigin (origins= {"http://localhost:4200"}) //El 4200 es el puerto que escucha una aplicacion Angular por defecto
@RestController
@RequestMapping("/api/v1") //Lo que viene antes del / sería algo estilo localhost:8080
public class MensajeControlador 
{
	
	
	
	@Autowired
	private IMensajeServicio servicio; //Basicamente haciendo esto tenemos todos los metodos de la interfaz, implementados ademas
	
	//Esto es para el metodo borrar, que lo vamos a hacer aqui directamente
	@Autowired
	private CrudRepository<Mensaje, Long> CR;
	
	
	
	
	
	
	
	
	
	//Metodo buscar todos los mensajes
	@GetMapping("/mensajes")
	public ResponseEntity<Respuesta> buscarMensaje()
	{
		ResponseEntity<Respuesta> respuesta = servicio.buscar();
		return respuesta;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//Metodo guardar un mensaje
	@PostMapping("/mensajes")
	public ResponseEntity<Respuesta> guardarMensaje(@RequestBody Mensaje mensaje)
	{
		ResponseEntity<Respuesta> respuesta = servicio.guardar(mensaje);
		return respuesta;
	}
	
	
	
	
	
	
	
	
	
	//Metodo borrar un mensaje
	//Aqui vamos a hacer algo que esta mal hecho
	//Que es poner aqui el metodo para ahorrarnos todo el tema del (I)MensajeServicio y del IMensajeDao
	//Por lo que solo haria falta el CrudRepository
	//Le ponemos aqui el @Transactional
	@Transactional
	@DeleteMapping("/mensajes/{id}")
	public ResponseEntity<Respuesta> borrarMensaje(@PathVariable Long id)
	{
		
		//Para ello, primero instanciamos el objeto respuesta
		
			Respuesta respuesta = new Respuesta();
		
		//Luego en un try/catch llamamos al metodo deleteById del CrudRepository		
		
		try
		{
			CR.deleteById(id);
			respuesta.setMetadata("Respuesta OK", "01", "Mensaje eliminado");
			
		}
		catch (Exception e)
		{
			respuesta.setMetadata("Respuesta NOK", "01", "Error al eliminar el mensaje: " + e);
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
		
		//Se devuelve un objeto ResponseEntity tipo respuesta con un codigo Http 200
		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK) ;
	}
	
	
	
	
	
	
}
		
	

