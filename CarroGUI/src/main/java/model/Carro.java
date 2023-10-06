package model;

import java.io.Serializable;

/**
 *
 * @author danil
 */
// Precisamos implementar a interface Serializable 
public class Carro implements Serializable{
    
    private String nome;
    private String marca;

    public Carro(String nome, String marca) {
        this.nome = nome;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return nome + "%" + marca;
    }
}
