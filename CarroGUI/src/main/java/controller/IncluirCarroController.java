package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import dao.Carros;
import model.Carro;
import view.*;
import javax.swing.JOptionPane;


/**
 *
 * @author danil
 */
public class IncluirCarroController {
    
    private AddCarroView view;
    private Carros carros;

    public IncluirCarroController() {
        this.carros = Carros.getInstance();
        this.view = new AddCarroView();
        
        this.view.getBtnSalvar().addActionListener((e) -> {
            addCarro();
        });
        
        this.view.getBtnCancelar().addActionListener((e) -> {
            cancelar();
        });
        
        this.view.setTitle("Cadastrar Carro");
        
        this.view.setVisible(true);
        
    }
    
    public void addCarro(){
        
        String nome = view.getTxtNomeCarro().getText();
        String marca = view.getTxtMarcaCarro().getText();
        
        Carro c = new Carro(nome, marca);
        
        carros.addCarro(c);
        
        JOptionPane.showMessageDialog(view, "Carro salvo com sucesso!");
        
        //this.view.dispose();
        
        limparTela();
        
    }

    private void cancelar() {
        this.view.dispose();
    }
    
    private void limparTela(){
        
        this.view.getTxtNomeCarro().setText("");
        this.view.getTxtMarcaCarro().setText("");
    }
    
    
    
}
