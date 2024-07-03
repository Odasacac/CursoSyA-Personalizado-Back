package ccasolutions.controlador;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ccasolutions.modelo.Mensaje;
import ccasolutions.respuesta.Respuesta;
import ccasolutions.servicios.IMensajeServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

//La anotacion @RestController indica que va a ser un servicio Rest, es decir, responde solicitudes Http y devuelve datos tipo JSON
//La anotacion @RequestMapping("url") especifica el prefijo de la URL base para todos los endpoints en esta clase
//La anotacion @GetMapping("url)", indica que es un metodo get y continua la url
//La anotacion @CrossOrigin es para indicar los origines que queremos que la aplicacion permita
//La anotación @RequestBody indica que el parámetro del método de un controlador debe estar vinculado al cuerpo de la solicitud HTTP entrante

@CrossOrigin (origins= {"http://localhost:4200"}) //El 4200 es el puerto que escucha una aplicacion Angular por defecto
@RestController
@RequestMapping("/api/v1") //Lo que viene antes del / sería algo estilo localhost:8080
public class MensajeControlador 
{
	@Autowired
	private IMensajeServicio servicio; //Basicamente haciendo esto tenemos todos los metodos de la interfaz, implementados ademas
	
	
	@GetMapping("/mensajes")
	public ResponseEntity<Respuesta> buscarMensaje()
	{
		ResponseEntity<Respuesta> respuesta = servicio.buscar();
		return respuesta;
	}
	
	@PostMapping("/mensajes")
	public ResponseEntity<Respuesta> guardarMensaje(@RequestBody Mensaje mensaje)
	{
		ResponseEntity<Respuesta> respuesta = servicio.guardar(mensaje);
		return respuesta;
	}
}
