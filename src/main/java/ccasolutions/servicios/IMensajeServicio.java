package ccasolutions.servicios;

import org.springframework.http.ResponseEntity;

import ccasolutions.modelo.Mensaje;
import ccasolutions.respuesta.Respuesta;


//Aqui vamos a declarar los metodos que usara la clase servicio que deberán ser implementados en MensajeServicio

//ResponseEntity<X> es una clase utilizada para representar toda la respuesta HTTP
//La X es para indicar el tipo del cuerpo de la respuesta, que en este caso es de tipo Respuesta


public interface IMensajeServicio
{
	public ResponseEntity <Respuesta> buscar();
	
	public ResponseEntity <Respuesta> guardar(Mensaje mensaje);
	
	public ResponseEntity <Respuesta> borrarPorId(Long id);
}
