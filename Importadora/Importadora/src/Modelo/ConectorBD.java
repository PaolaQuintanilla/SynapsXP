package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorBD{
private Connection conexion;
private Statement sentencia;
//Datos para la conexion a la BD
private final String servidor ="localhost";
private final String BD ="importadora";
private final String usuario="root";
private final String clave="";
private final String URL="jdbc:mysql://"+servidor+"/"+BD;
// Metodo constructor, que inicializa los atributos internos del conector de BD
public ConectorBD(){
	this.conexion=null;
	this.sentencia=null;
}
/*
Metodo para crear la comunicacion con la BD
return true cuando la conexion se crea correctamente,
y false cuando no es posible
*/
public boolean conectar(){
	boolean estado=false;
try{
	//levantar la conexion con la bd
	Class.forName("com.mysql.jdbc.Driver");
	try{
		//Estacer la conexion con la BD
		conexion =DriverManager.getConnection(URL,usuario,clave);
		estado=true;
	}catch(SQLException ex){
		System.err.println("Error: Conector BD.conectar()" );
		System.err.println("Al intentar la conexion a la BD");
		System.out.println(ex.getMessage());
	}
    }catch(ClassNotFoundException cex){
		System.err.println("Error: Conector BD.conectar()" );
		System.err.println("No se encontro el Driver de conexion con MySQL" );
		System.err.println(cex.getMessage());
	}
return estado;
}
/*
Para ejecutar sentencias SQL  insert, update,delete
*/
public boolean consulta(String sql){
	boolean estado = false;
try{
	sentencia =conexion.createStatement();
	sentencia.execute(sql);
	sentencia.close();
	estado=true;
	}catch(SQLException sqle){
		System.err.println("Error: ConectorBD.ejecutar(sql)");
		System.err.println(sqle.getMessage());
	}
	return estado;
}
/*
Este metodo me permite ejecutar la sentencia: SELECT
el parametro sql me indica la consulta select que se le va a pasar al metodo
*/

public ResultSet seleccionar(String sql){
	ResultSet resultado=null;
	try{
		sentencia = conexion.createStatement();
		resultado = sentencia.executeQuery(sql);
		
	}catch(SQLException sqle){
		System.err.println("Error: ConectorBD seleccionar(sql)");
		System.err.println(sqle.getMessage());
	}
	return resultado;
}
/*
Para cerrar la conexion de forma correcta con la base de datos
verificanco que exista la conexion
*/
public void desconectar(){
	try{
		if(conexion!=null){
			conexion.close();
			conexion=null;
		}
	}catch(SQLException sqle){
		System.err.println("Error: ConectorBD.desconectar()");
		System.err.println(sqle.getMessage());
	}	
}
//Retorna la conexion actual que este establecida, return conexion
public Connection getConnection(){
	return conexion;
}
}
	


