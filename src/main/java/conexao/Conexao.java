package conexao;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
  
  public Connection getConexao(){    
    try {
      Connection conn = DriverManager.getConnection(
              "jdbc:mariadb://localhost:3360/baseveiculos",
              "root",
              "secret");
        return conn;      
    } catch (Exception e){
      System.out.println("Não foi possível estabelecer uma conexão!" + e.getMessage());
    }
    return null;
  } 
}

