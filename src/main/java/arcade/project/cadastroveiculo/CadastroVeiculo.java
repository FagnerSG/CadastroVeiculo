package arcade.project.cadastroveiculo;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import conexao.Conexao;


public class CadastroVeiculo {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    Conexao conectar = new Conexao();
    Persistencia persistencia = new Persistencia();
    
    conectar.getConexao();
    
    int  opcao = 4;
    
    do {
      
      System.out.println("Menu\n");
      System.out.println("""
                         1 - Cadastrar Veiculo
                         2 - Listas de Veiculos
                         3 - Excluir Veiculo
                         4 - Sair""");
      
      opcao = scn.nextInt();
      
      switch (opcao) {
        case 1 -> {
          persistencia.carregarDados();
          
          try {           
              Class.forName("org.mariadb.jdbc.Driver");
              Veiculos veiculo = new Veiculos();
              veiculo.getPlaca();
              veiculo.getRenavam();
              veiculo.getAno();

              System.out.println("Digite Placa");
              String placa = scn.next();
              veiculo.setPlaca(placa);
              
              System.out.println("\nDigite Renavam");
              int renavam = scn.nextInt();
              veiculo.setRenavam(renavam);
              
              persistencia.veiculos.add(veiculo);
              persistencia.salvarDados();
              //getTransaction().commit();
              } catch (Exception ex){
              em.getTransation().rollback();
            }
          break;
         } 
          
        case 2 -> {
          List<Veiculos> listarVeiculos = s.createQuery("selecionar Veiculo", Veiculos.class).getResultList();
          
          for (Veiculos pl: listarVeiculos) {
            System.out.println(pl.getId() = " = " + pl.getPlaca());
            if (pl.getRenavam() != null) {
              System.out.println("Renavam = " +  pl.getRenavam());
            }
          }
          break;
        }
        
        case 3 -> {
          s.getTransaction().begin();
          System.out.println("digite a Placa do Veiculo");
          String placa = scn.nextLine();
          Veiculos veiculo = s.find(Veiculos.class, id);
          s.remove(veiculo);
          s.getTransaction().commit();
          }
        
        }break;
      
      } while (opcao != 4);
     
    } 
    
  }
  

