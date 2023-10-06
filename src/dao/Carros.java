/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucminas.pm.guijava.dao;

import com.pucminas.pm.guijava.model.Carro;
import java.util.ArrayList;

/**
 *
 * @author danil
 */
public class Carros {

    private ArrayList<Carro> carros;
    private static Carros instance;

    private Carros() {
        this.carros = new ArrayList<>();
        carregaCarros();
    }

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
        
        // ler o arquivo txt e instanciar todos os carros e jogar no arraylist
    }
    
    private void persisteCarro(Carro carro){
        // codigo para salvar o carro no arquivo texto
    }
}
