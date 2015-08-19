/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.java.dev.designgridlayout.DesignGridLayout;
import net.java.dev.designgridlayout.ISpannableGridRow;

/**
 *
 * @author icaro
 */
public class config_novo extends JFrame {
    
    public config_novo() {
        super("Criar um formulario");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicio();
        setVisible(true);
    }
    
    public void inicio() {
        DesignGridLayout layout = new DesignGridLayout(this);
        JPanel painel_central = new JPanel();
        montar_componentes mc = new montar_componentes();
        
        JList lista = new JList();
        
        String[] tt1 = {"Nome","Titulo"};
        //mc.campos_texto2(layout, tt1);
        
        DefaultListModel lista_componentes = new DefaultListModel();
        lista_componentes.addElement("Nenhum Componente Adicionado.");
        lista.setModel(lista_componentes);
        
        JTextField campo1 = new JTextField();
        JTextField campo2 = new JTextField();
        layout.row().grid(new JLabel("Nome:")).add(campo1).grid(new JLabel("Titulo:")).add(campo2);
        
        
        /*JTextField campo1 = new JTextField();
        JTextField campo2 = new JTextField();
        layout.row().grid(new JLabel("Nome:")).add(campo1).grid(new JLabel("Titulo:")).add(campo2).add(lista);
        */
        
        //String[] des = {"Descriçao do Formulario"};
        //mc.textos2(layout, des);
        
        JTextArea texto = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(texto);

            layout.row().grid().add(new JLabel("Descriçao do Formulario:"));
            layout.row().grid().add(scrollPane).empty();
//.add(lista);
        
        
        String[] comps = {"Selecione um componente",
            "Campo de texto",
            "Botao de seleçao",
            "Botao de marcar",
            "Lista de opçoes",
            "Area de texto"};
        mc.drop(layout, "Selecione um componente", comps);
        
        JSpinner quantidade = new JSpinner();
        quantidade.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        
        layout.row().grid(new JLabel("Quantidade:")).add(quantidade);
        
        String[] titulos = {"Titulo dos componentes (Separados por \";\")"};
        mc.textos(layout, titulos);
        
        String[] bts = {"Adicionar Componente"};
        mc.botoes(layout, bts);
        
        
        layout.row().center().add(new JButton("Salvar Configuraçao")).add(new JButton("Cancelar"));
        
    }
    
}
