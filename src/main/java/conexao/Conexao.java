package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {
  
  public static Connection conexao() throws SQLException{ 
    
    java.sql.Connection conn = null;
    
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3360/baseveiculos?useTimezone="
               + "true&serverTimezone=UTC&useBulkStmts=false","root","secret");
        return conn;      
    } catch (Exception e){
      System.out.println("Não foi possível estabelecer uma conexão!" + e.getMessage());
      } if (conn != null) {
            conn.close();
            conn = null;
    }
    return null;
    
   } 
  
}

