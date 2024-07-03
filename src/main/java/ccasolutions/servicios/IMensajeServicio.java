package ccasolutions.servicios;

import org.springframework.http.ResponseEntity;

import ccasolutions.modelo.Mensaje;
import ccasolutions.respuesta.Respuesta;


//Aqui vamos a declarar los metodos que usara la clase servicio que deberán ser implementados en MensajeServicio
//ResponseEntity es una interfaz que permite dar una estructura de respuesta http
public interface IMensajeServicio
{
	public ResponseEntity <Respuesta> buscar();
	
	public ResponseEntity <Respuesta> guardar(Mensaje mensaje);
	
	public ResponseEntity <Respuesta> borrar(Long id);
}
