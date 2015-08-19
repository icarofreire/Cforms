/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import static forms.config.convertToListModel;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import net.java.dev.designgridlayout.DesignGridLayout;
import net.java.dev.designgridlayout.ISpannableGridRow;

/**
 *
 * @author icaro
 */
public class montar_componentes {
    
    public ButtonGroup radios;
    
    public void descricao(DesignGridLayout layout, String titulo){
        layout.row().grid(new JLabel(titulo));
    }
    
    public JTextField[] campos_texto(DesignGridLayout layout, String[] titulos){
        int quantidade = titulos.length;
        JTextField[] campos = new JTextField[quantidade];
                
        if((quantidade%2) == 0)//par
        {
            for(int i=0; i<titulos.length; i+=2){
                JTextField campo1 = new JTextField();
                JTextField campo2 = new JTextField();
                campos[i] = campo1;
                campos[i+1] = campo2;
                layout.row().grid(new JLabel(titulos[i]+":")).add(campo1).grid(new JLabel(titulos[i+1]+":")).add(campo2);
            }
        }else{// impar
            for(int i=0; i<titulos.length-1; i+=2){
                JTextField campo1 = new JTextField();
                JTextField campo2 = new JTextField();
                campos[i] = campo1;
                campos[i+1] = campo2;
                layout.row().grid(new JLabel(titulos[i]+":")).add(campo1).grid(new JLabel(titulos[i+1]+":")).add(campo2);
            }
            JTextField campo_fin = new JTextField();
            campos[titulos.length-1] = campo_fin;
            layout.row().grid(new JLabel(titulos[titulos.length-1]+":")).add(campo_fin);
        }
        return campos;
    }
    
    public JTextArea[] textos(DesignGridLayout layout, String[] titulos){
        int quantidade = titulos.length;
        JTextArea[] textos = new JTextArea[quantidade];
        
        for(int i=0; i<titulos.length; i++){
            JTextArea texto = new JTextArea();
            textos[i] = texto;
            JScrollPane scrollPane = new JScrollPane(texto);

            layout.row().grid().add(new JLabel(titulos[i]+":"));
            layout.row().grid().add(scrollPane).empty();
        }
        return textos;
    }
    
    public ButtonGroup selecao(DesignGridLayout layout, String titulo_explicativo, String[] titulos){
        int quantidade = titulos.length;
        JRadioButton[] __radios = new JRadioButton[quantidade];
        
        JPanel pp = new JPanel();
        radios = new ButtonGroup();
        
        layout.row().grid().add(new JLabel(titulo_explicativo));
        
        for(int i=0; i<titulos.length; i++)
        {
            JRadioButton r = new JRadioButton(titulos[i], false);
            __radios[i] = r;
            radios.add(r);
            pp.add(r);
        }
        layout.row().grid().add(pp);
        return radios;
    }
    
    
    private ListModel convertToListModel(String[] nList)
    {
        return (new JComboBox(nList).getModel());
    }
    
    public JComboBox drop(DesignGridLayout layout, String titulo, String[] opcoes){
        
        JComboBox ll = new JComboBox();
        ll.setModel((ComboBoxModel) convertToListModel(opcoes));
        layout.row().grid(new JLabel(titulo)).add(ll);
        return ll;
    }
    
    public void botoes(DesignGridLayout layout, String[] titulos){
        ISpannableGridRow is = layout.row().grid();
        for(int i=0; i<titulos.length; i++){
            is.add( new JButton(titulos[i]) );
        }
    }
    
    public JCheckBox[] botao_check(DesignGridLayout layout, String titulo_explicativo, String[] titulos){
        int quantidade = titulos.length;
        JCheckBox[] __checks = new JCheckBox[quantidade];
        
        ISpannableGridRow is = layout.row().grid(new JLabel(titulo_explicativo));
        
        for(int i=0; i<titulos.length; i++){
            JCheckBox check = new JCheckBox(titulos[i]);
            __checks[i] = check;
            is.add( check );
        }
        return __checks;
    }
    
    
    
}
