package arcade.project.cadastroveiculo;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JOptionPane;
import jakarta.persistence.EntityManager;


public class CadastroVeiculo {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Persistencia persistencia = new Persistencia();
    
    int  op = 0;
    
    do {
      
      System.out.println("Menu\n");
      System.out.println("1 - Cadastrar Veiculo" + "\n2 - Listas de Veiculos" 
              + "\n3 - Excluir Veiculo" + "\n0 - Sair");
      
      op = scn.nextInt();
      
      switch (op) {
        case 1:
          persistencia.carregarDados();
          try {
              Veiculos veiculo = new Veiculos();
              veiculo.getPlaca();
              veiculo.getRenavam();
              veiculo.getAno();
              
              System.out.println("Digite Placa");
              String getPlaca = scn.next();
              em.getTransaction().begin();
              veiculo.setPlaca(getPlaca);
              em.persist(p);
              em.getTransaction().commit();
          } catch (Exception ex){
            em.getTransation().rollback();
          }
          em.close();
        break;
          
        case 2:
          List<Veiculos> listarVeiculos = s.createQuery("selecionar Veiculo", Veiculos.class).getResultList();
          
          for (Veiculos pl: listarVeiculos) {
            System.out.println(pl.getId() = " = " + pl.getPlaca());
            if (pl.getRenavam() != null) {
              System.out.println("Renavam = " +  pl.getRenavam());
            }
          }
        break;
        
        case 3:
          s.getTransaction().begin();
          System.out.println("digite a Placa do Veiculo");
          String placa = sc.nextLong();
          Veiculos veiculo = s.find(Veiculos.class, ide);
          s.remove(veiculo);
          s.getTransaction().commit();
        break;
      
      } while (op !=0);
      
    } 
  }
}
