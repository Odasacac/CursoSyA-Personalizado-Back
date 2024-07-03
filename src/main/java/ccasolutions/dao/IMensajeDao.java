package ccasolutions.dao;

import org.springframework.data.repository.CrudRepository;

import ccasolutions.modelo.Mensaje;

//Esta interfaz hereda la interfaz CrudRepository de SpringFramework que tiene todos los metodos para hacer CRUD a una base de datos
//Como parametros hay que pasarle la Entidad con la que trabajará y el tipo de clave primaria
//Recordar que establecimos como @Entity a la clase Mensaje y su atributo id es de tipo Long
public interface IMensajeDao extends CrudRepository<Mensaje, Long>
{
	//Aqui se añaden los metodos que no tiene CrudRepository

}

//Ya está, la idea con esto es que una clase implemente esta interfaz y puedan ejecutarse los métodos desde ella
//Esa clase no hereda directamente de CrudRepository porque hay metodos que no tiene implementados
//Entonces mejor tener esta interfaz con todos los metodos que irlos teniendo por ahi sueltos