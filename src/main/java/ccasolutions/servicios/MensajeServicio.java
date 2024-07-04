package ccasolutions.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ccasolutions.dao.IMensajeDao;
import ccasolutions.modelo.Mensaje;
import ccasolutions.respuesta.Respuesta;

//Esta clase implementa la interfaz IMensajeServicio y por tanto implementa los metodos que hay en ella
//Ademas, hay que añadir la notacion @Service, lo que permite identificarla como una clase de Servicio, para optimizar vaya 

//Aqui se une un poco todo, esta clase implementa la interfaz IMensajeServicio donde se declararon los metodos que se van a usar
//Y ademas instancia un objeto tipo interfaz IMensajeDao para acceder a los metodos CRUD, esto es asi si o si
//Es decir, para acceder a los metodos de CurdRepository, esta interfaz o la que se use ha de ser inyectada como dependencia
//Si se implementa va a obligar a implementar los metodos y ya no se pueden usar, tiene que hacerse inyectando dependencias

//La notacion @Autowired se utiliza para realizar la inyección de dependencias automáticamente en los componentes de la aplicación.
//La notacion @Transactional simplifica la gestión de transacciones en aplicaciones Spring evitando que se hagan de forma manual

@Service
public class MensajeServicio implements IMensajeServicio
{

	//Inyectamos la dependencia de IMensajeDao para usar los metodos del CrudRepository
	@Autowired
	private IMensajeDao mensajeDao;
	
	
	//Una vez los metodos esten implementados aqui, hay que ir al controlador y llamarlos desde alli
	
	
	
	
	
	
	
	
	//1 - Vamos a implementar el metodo buscar(), declarado en la interfaz
	@Override
	@Transactional (readOnly=true)
	public ResponseEntity<Respuesta> buscar() 
	{
		//Para ello, primero instanciamos un objeto respuesta
	
		Respuesta respuesta = new Respuesta();
		
		//Luego en un try/catch
		
		
		try
		{
			//Declaramos una lista de Mensajes que sera rellenada con lo que se obtenga del metodo findAll de la interfaz que realmente es del CrudRepository
			//El problema es que el metodo findAll devuelve un Iterable, por eso hacemos un casting a una List: (List<Mensaje>)
			
			List <Mensaje> mensaje = (List<Mensaje>) mensajeDao.findAll();
			
			//Y ahora con la lista llena de los mensajes, se actualiza la lista del objeto respuesta
			
			respuesta.setMensaje(mensaje);
			
			//Finalmente, llenamos el metadata
			
			respuesta.setMetadata("Respuesta OK", "00", "Mensajes obtenidos con éxito");
			
		}
		catch (Exception e)
		{
			respuesta.setMetadata("Respuesta NOK", "01", "Error al obtener los mensajes: " + e);
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
		
		//Se devuelve un objeto ResponseEntity tipo respuesta con un codigo Http 200
		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK) ;
		
		
	}

	
	
	
	
	
	
	
	
	
	//2 - Vamos a implementar el metodo guardar(), declarado en la interfaz
	@Override
	@Transactional
	public ResponseEntity<Respuesta> guardar(Mensaje mensaje) 
	{
		//Para ello, primero instanciamos un objeto respuesta
	
		Respuesta respuesta = new Respuesta();
		
		//E instanciamos una lista de objetos Mensaje
		
		List <Mensaje> lista = new ArrayList<>();
		
		try
		{
			//Declaramos un objeto Mensaje con el nombre mensajeGuardado
			//Y lo rellenamos con lo que devuelve el metodo save() del CrudRepository habiendole pasado el objeto mensaje como parametro
			//El metodo save() devuelve el mismo tipo de objeto que se le pasa como argumento
			Mensaje mensajeGuardado = mensajeDao.save(mensaje);
			
			
			//Ahora validamos
			if (mensajeGuardado != null)
			{
				//Si mensajeGuardado no es nulo, es decir si se almaceno correctamente
				//Añadimos este objeto a la lista y la añadimos al objeto respuesta
				
				lista.add(mensajeGuardado);
				respuesta.setMensaje(lista);
				respuesta.setMetadata("Respuesta OK", "00", "Mensaje guardado con éxito");
			}
			else
			{
				respuesta.setMetadata("Respuesta NOK", "02", "Mensaje no guardada");
				return new ResponseEntity<Respuesta>(respuesta, HttpStatus.BAD_REQUEST) ;
			}
			
		}
		catch (Exception e)
		{
			respuesta.setMetadata("Respuesta NOK", "01", "Error al guardar el mensaje: " + e);
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
		
		
		
		return new ResponseEntity <Respuesta>(respuesta, HttpStatus.OK);
	}









	//3 - Implementamos el metodo borrar()
	//OJO que en este caso lo he hecho directamente todo en MensajeControlador
	//Pero el metodo sería así
	@Override
	@Transactional
	public ResponseEntity<Respuesta> borrarPorId(Long id) 
	{
		//Para ello, primero instanciamos un objeto respuesta
		
		Respuesta respuesta = new Respuesta();
		
		//Luego en un try/catch
		
		
		try
		{
			mensajeDao.deleteById(id);
			respuesta.setMetadata("Respuesta OK", "001", "Mensaje eliminado");
			
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
