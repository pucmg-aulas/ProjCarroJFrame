package dao;

import model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danil
 */
//Esta classe utiliza o método já implementado para armazenar e recuperar os arquivos serializados
public class Carros extends AbstractDAO implements Serializable{

    private List<Carro> carros;
    // Atributo da própria classe, estático, para implementar o Singleton
    private static Carros instance;
    
    //Endereço do arquivo serializado que contém a coleção de carros
    private final String localArquivo = "./src/main/java/data/Carros.dat";

    //Construtor privado, pois não podemos permitir mais de uma instância desta classe
    //que controla a coleção de carros do sistema (Singleton)
    private Carros() {
        this.carros = new ArrayList<>();
        carregaCarros();
    }

    //Método para recuperar a única instância de Carros
    public static Carros getInstance() {
        if (instance == null) {
            instance = new Carros();
        }
        return instance;
    }
    
    public void addCarro(Carro carro){
        this.carros.add(carro);
        persisteCarro(carro);
    }

    private void carregaCarros(){
        
        carros = super.leitura(localArquivo);
    }
    
    private void persisteCarro(Carro carro){
        super.grava(localArquivo, carros);
    }

    public List<Carro> getCarros() {
        return carros;
    }
    
    
}
