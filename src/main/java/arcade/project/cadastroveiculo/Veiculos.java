package arcade.project.cadastroveiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class Veiculos {

  static List<Veiculos> listar(org.mariadb.jdbc.Connection conn) {
    return null;    
  }

  static Veiculos buscarPorPlaca(org.mariadb.jdbc.Connection conn, String placaAtualizar) {
    return null;
  }

  
  private int id;
  private String placa;
  private String renavam;
  private int ano;

  Veiculos(String placa, String renavam, int ano) {
    
  }


  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getRenavam() {
    return renavam;
  }

  public void setRenavam(String renavam) {
    this.renavam = renavam;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  @Override
    public String toString() {
        return "Veiculos [placa=" + placa + ", renavam=" + renavam + ", ano=" + ano + "]";
    }

    // métodos para inserir, atualizar e excluir o veículo no banco de dados

    public void inserir(Connection conn) throws SQLException {
        String sql = "INSERT INTO veiculo (placa, renavam, ano) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, placa);
        stmt.setString(2, renavam);
        stmt.setInt(3, ano);
        stmt.executeUpdate();
        System.out.println("Veículo inserido com sucesso!");
    }

    public void atualizar(Connection conn) throws SQLException {
        String sql = "UPDATE veiculo SET renavam = ?, ano = ? WHERE placa = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, renavam);
        stmt.setInt(2, ano);
        stmt.setString(3, placa);
        stmt.executeUpdate();
        System.out.println("Veículo atualizado com sucesso!");
    }

    public void excluir(Connection conn) throws SQLException {
        String sql = "DELETE FROM veiculo WHERE placa = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, placa);
        stmt.executeUpdate();
        System.out.println("Veículo excluído com sucesso!");
    }
  
}
