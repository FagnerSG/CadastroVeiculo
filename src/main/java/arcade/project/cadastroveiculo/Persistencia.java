package arcade.project.cadastroveiculo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class Persistencia {
  
  private static final String novoVeiculos = "dados.data";
  
  public List<Veiculos> veiculos = new ArrayList<>();
  
  public static String urlDB = "";
  
  @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
  public void carregarDados() {
  try {
  Path file = Paths.get(novoVeiculos);
  
  if (!Files.exists(Paths.get(novoVeiculos))) {
    Files.createFile(Paths.get(novoVeiculos));
  } else {
    FileInputStream fis = new FileInputStream(file.toFile());
    ObjectInputStream ois = new ObjectInputStream(fis);
    
    veiculos = (List) ois.readObject();
    
    ois.close();
    fis.close();
  }
} catch (Exception e) {
  
}
}

  @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
  public void salvarDados() {
  try {
    Path file = Paths.get(novoVeiculos);
    
    FileOutputStream fos = new FileOutputStream(file.toFile());
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(novoVeiculos);
    
    oos.close();
    fos.close();
    
  } catch (Exception e){
    
  }          
  }
}
