/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Carros;
import model.Carro;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import view.ListarCarroView;

/**
 *
 * @author danil
 */
public class ListarCarroController {
    
    private ListarCarroView view;
    private Carros carros;

    public ListarCarroController() {
    
        this.carros = Carros.getInstance();
        this.view = new ListarCarroView();
        
        carregaTabela();
        
        
        
        this.view.getBtnVoltar().addActionListener((e) -> {
            sair();
        });
        
        this.view.setVisible(true);
        
    }
    
    private void sair() {
        this.view.dispose();
    }
    
    private void carregaTabela(){
        Object colunas[] = {"Nome", "Marca"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
       
        tm.setNumRows(0);
        Iterator<Carro> it = carros.getCarros().iterator();
        while (it.hasNext()) {
            Carro c = it.next();
            String carro = c.toString();
            String linha[] = carro.split("%");
            tm.addRow(new Object[]{linha[0], linha[1]});
        }
        view.getTbCarros().setModel(tm);
    }
}
