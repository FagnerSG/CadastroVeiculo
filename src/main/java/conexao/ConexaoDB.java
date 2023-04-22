package conexao;

import arcade.project.cadastroveiculo.Veiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoDB {
  private Conexao conexao;
  private Connection conn;
  
  public ConexaoDB (){
    this.conexao =  new Conexao();
    this.conn = this.conexao.getConexao();
  }
  
  public void inserir(Veiculos veiculo) throws SQLException {
    
    String sql = "INSERT INTO veiculos(placa, renavam, ano) VALUES " + "(?, ?, ?)";
    
    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, veiculo.getPlaca());
        stmt.setInt(2, veiculo.getRenavam());
        stmt.setInt(3, veiculo.getAno());        
        stmt.execute();
      } catch (Exception e){
        System.out.println("Erro ao inserir veiculo: " + e.getMessage());
      }    
  }
}
