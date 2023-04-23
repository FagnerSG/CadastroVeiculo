package arcade.project.cadastroveiculo;

import java.util.Scanner;
import conexao.Conexao;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import org.mariadb.jdbc.Connection;



public class CadastroVeiculo {

  public static void main(String[] args) throws SQLException {
    Scanner scn = new Scanner(System.in);
    
    Connection conn = (Connection) Conexao.conexao();


      int  opcao = 0;
      while(true){   
        System.out.println("Menu selecao:\n");
        System.out.println("1. Cadastrar veículo");
        System.out.println("2. Listar veículos cadastrados");
        System.out.println("3. Atualizar informações de um veículo");
        System.out.println("4. Excluir um veículo cadastrado");
        System.out.println("0. Sair");

        opcao = scn.nextInt();
        scn.nextLine();
      switch (opcao){

          case 1:
              // Cadastrar um novo veículo
              System.out.println("\nCadastrar um novo veículo:");

              // Lê os dados do veículo a ser cadastrado
              System.out.print("Placa: ");
              String placa = scn.next();
              System.out.print("RENAVAM: ");
              String renavam = scn.next();
              System.out.print("Ano: ");
              int ano = scn.nextInt();

              // Cria um objeto da classe Veiculo com os dados informados
              Veiculos novoVeiculo = new Veiculos(placa, renavam, ano);

              // Insere o novo veículo no banco de dados
              try {
                  novoVeiculo.inserir(conn);
                  System.out.println("Veículo cadastrado com sucesso.");
              } catch (SQLException e) {
                  System.out.println("Não foi possível cadastrar o veículo.");
                  System.out.println("Erro: " + e.getMessage());
              }
              break;


          case 2:
              // Listar os veículos cadastrados
              System.out.println("\nVeículos cadastrados:");

              // Busca os veículos no banco de dados
              try {
                  List<Veiculos> veiculos = Veiculos.listar(conn);

                  // Imprime os veículos encontrados
                  for (Veiculos veiculo : veiculos) {
                      System.out.println(veiculo.toString());
                  }
              } catch (Exception e) {
                  System.out.println("Não foi possível listar os veículos.");
                  System.out.println("Erro: " + e.getMessage());
              }
              break;

          case 3:
              System.out.println("\nAtualizar informações de um veículo:");
              System.out.print("Placa do veículo a ser atualizado: ");
              String placaAtualizar = scn.next();

              // Busca o veículo no banco de dados
              try {
                  Veiculos veiculoAtualizar = Veiculos.buscarPorPlaca(conn, placaAtualizar);

                  // Verifica se o veículo foi encontrado
                  if (veiculoAtualizar == null) {
                      System.out.println("Veículo não encontrado.");
                      break;
                  }

                  // Lê os novos dados do veículo
                  System.out.print("Novo RENAVAM (deixe em branco para manter o valor atual): ");
                  String novoRenavam = scn.next();
                  if (!novoRenavam.isEmpty()) {
                      veiculoAtualizar.setRenavam(novoRenavam);
                  }
                  System.out.print("Novo ano (deixe em branco para manter o valor atual): ");
                  String novoAno = scn.next();
                  if (!novoAno.isEmpty()) {
                      veiculoAtualizar.setAno(Integer.parseInt(novoAno));
                  }

                  // Atualiza os dados do veículo no banco de dados
                  try {
                      veiculoAtualizar.atualizar(conn);
                      System.out.println("Veículo atualizado com sucesso.");
                  } catch (Exception e) {
                      System.out.println("Não foi possível atualizar o veículo.");
                      System.out.println("Erro: " + e.getMessage());
                  }
              } catch (Exception e) {
                  System.out.println("Não foi possível buscar o veículo.");
                  System.out.println("Erro: " + e.getMessage());
              }
              break;
          


          case 4:
            System.out.println("\nExcluir um veículo cadastrado:");                    
                // Lê a placa do veículo a ser excluído
            System.out.print("Placa do veículo a ser excluído: ");
            String placaExcluir = scn.next();

            // Busca o veículo no banco de dados
            try {
                Veiculos veiculoExcluir = Veiculos.buscarPorPlaca(conn, placaExcluir);

                // Verifica se o veículo foi encontrado
                if (veiculoExcluir == null) {
                    System.out.println("Veículo não encontrado.");
                    break;
                }

                // Exclui o veículo do banco de dados
                try {
                    veiculoExcluir.excluir(conn);
                    System.out.println("Veículo excluído com sucesso.");
                } catch (SQLException e) {
                    System.out.println("Não foi possível excluir o veículo.");
                    System.out.println("Erro: " + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("Não foi possível buscar o veículo.");
                System.out.println("Erro: " + e.getMessage());
            }
            break;

            case 0:
                // Encerra o programa
                System.out.println("\nEncerrando o programa...");
                return;

            default:
                // Opção inválida
                System.out.println("\nOpção inválida.");
            }
          }
        } 
     
      
  
}
  

