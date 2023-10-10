/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Carros;
import model.Carro;
import java.util.Iterator;
import javax.swing.JOptionPane;
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
        
        this.view.getBtnExcluir().addActionListener((e) -> {
            excluirCarro();
        });
        
        this.view.getBtnVoltar().addActionListener((e) -> {
            sair();
        });
        
        this.view.getBtnEditar().addActionListener((e) -> {
            editar();
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
    
    private void excluirCarro(){
        
        if(view.getTbCarros().getSelectedRow() != -1){
            
            int linha = this.view.getTbCarros().getSelectedRow();
            String nome = (String) this.view.getTbCarros().getValueAt(linha, 0);
            
            int op = JOptionPane.showConfirmDialog(view, "Deseja excluir " + nome + "?");
            if(op == JOptionPane.YES_OPTION){
                Carro carro = carros.buscarCarroPorNome(nome);
                carros.excluirCarro(carro);
                JOptionPane.showMessageDialog(view, nome + " Excluído com Sucesso!");
                carregaTabela();
            }
            
        }
        else{
            JOptionPane.showMessageDialog(view, "Selecione uma linha primeiro!");
        }
 
    }

    private void editar() {
        JOptionPane.showInternalMessageDialog(view, "Não implementado ainda!");
    }
}
