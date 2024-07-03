
package modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//En este package modelo, vamos a tener las clases de los objetos que seran almacenados en la base de datos
//Vamos a usar varias anotaciones:

//@Entity: definimos esta clase como una entidad
//Es decir, se prepara esta clase para interactuar de manera estructurada y eficiente con una base de datos relacional
//Debe ser mapeada a una tabla en una base de datos relacional. Cada instancia de la clase corresponde a una fila en la tabla.
//Sin @Entity, Hibernate no reconocerá la clase como una entidad y no creará la tabla correspondiente en la base de datos.

//@Table(name="nombreTabla"): le decimos el nombre de la tabla que queremos que tenga esta entidad

//@Data: para poder acceder a los metodos de Lombok

//@Id: para indicar que el campo Id de la tabla sera el atributo inmediatamente inferior

//@GeneratedValue(strategy = GenerationType.IDENTITY): para indicar que el id se autogenere cada vez que se realice un nuevo registro

@Data
@Entity
@Table(name="mensaje")
public class Mensaje implements Serializable
{	
	//El motivo por el que implementa la interfaz Serializable es para que los datos puedan ser transportados
	
	//Hay que generar un ID por defecto
	private static final long serialVersionUID = -466339413645963704L;
	
	
	//Ahora creamos los campos que tendra esta clase
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; //Esto es obligatorio si o si para que tenga un identificador en la tabla
	private String nombre;
	private String correo;
	private String academia;
	private String mensaje;
	
	//Para los metodos Getters y Setter se puede hacer manual
	//O recurrir a la libreria Lombok que nos genera además algunos métodos interesantes
	//Hay que importarla en el IDE y en el pom.xml
	
	//Para importarlo en el IDE: Vamos a internet: https://projectlombok.org/
	//Install, Spring Tool Suite, Via Eclipse Plugin Installer y ahi te dice como
	//Que básicamente es pegando esta url: https://projectlombok.org/p2 en Help -> Install New Software aqui en el IDE
	//Se selecciona, next y listo, hay que reiniciar el IDE
	
	//Para importarlo en el POM: También, en https://projectlombok.org/
	//Install -> Build Tools -> Maven
	//Y ahi coger el XML para copiarlo en <dependencies> del archivo POM
	//Pero del contenido, sustituir esto:
	//<version>1.18.34</version>
	//<scope>provided</scope>
	//Por esto:
	//<optional>true</optional>
	//Y basicamente quedaria:
	/*
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
	*/
	//Listo
}

//Si ahora iniciamos el proyecto, debería aparecer en la consola que se ha creado la tabla mensaje
