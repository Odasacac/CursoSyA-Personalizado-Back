package ccasolutions.respuesta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ccasolutions.modelo.Mensaje;
import lombok.Data;

@Data
public class Respuesta 
{
	
	//Creamos una List de Mensajes
	
	private List <Mensaje> mensaje;
	
	//Luego se declara una variable privada llamada metadata que es un ArrayList de HashMap con claves y valores de tipo String.
	
	private ArrayList <HashMap<String, String>> metadata = new ArrayList<>();
	
	//Un ArrayList, esto deberias saberlo, es un Array pero dinamico en su estructura
	//Es decir, que no se define su tamaño al inicio sino que va variando si se añaden o eliminan elementos
	
	//Un HashMap es una estructura de datos que almacena pares clave-valor
	//Es decir, que puedes asociar una clave única con un valor correspondiente
	//En este caso, el HashMap relaciona Strings con Strings
	

	
	//En este caso el set vamos a modificar el setMetadata	
	//La idea va a ser crear un HashMap que se rellenerá con los parametros que se le pasan al metodo
	//Y una vez creado este HashMap, se añade al ArrayList metadata
	public void setMetadata(String type, String code, String date) 
	{
		//Para ello, vamos a crear un HashMap local String String		
		HashMap<String, String> map = new HashMap<String, String>();
		
		//En este HashMap vamos a ir ingresando los valores con el metodo put		
		map.put("type", type);
		map.put("code", code);
		map.put("date", date);
		
		//Y ahora se le añade a metadata este HashMap relleno		
		metadata.add(map);
		
		//Este metodo setMetadata no restablece el valor de metadata cada vez que se llama
		//Lo que hace es ir añadiendo mas informacion
	}
	
}


//Esto el MaestroLeal lo hace mas complejo, hace tres clases:
//1 - MensajeResponse: Que contiene solo el metadata
//2 - ResponseRest: Que contiene solo la lista
//3 - MensajeResponseRest: Que hereda ResponseRest y que instancia MensajeResponse
//Yo lo he hecho todo en una misma clase