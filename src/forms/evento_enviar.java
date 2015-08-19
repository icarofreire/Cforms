/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author icaro
 */
public class evento_enviar implements ActionListener {
    
    ButtonGroup radios;
    JCheckBox[] checks;
    JComboBox drop;
    JTextField[] campos;
    JTextArea[] textos;
    String[] id_campos;
    String[] id_textos;
        
    evento_enviar(ButtonGroup r, JCheckBox[] cb, JComboBox dr, JTextField[] cc, JTextArea[] txts, String[] id_camp, String[] id_texts) {
        this.radios = r;
        this.checks = cb;
        this.drop = dr;
        this.campos = cc;
        this.textos = txts;
        this.id_campos = id_camp;
        this.id_textos = id_texts;
    }
        
    public void actionPerformed(ActionEvent ex) {
         
        System.out.println("Opçao: " + radio_selecionado() );
        botoes_checados();
        System.out.println("Selecionado: " + selecionado_na_lista() );
        campos_texto_pequeno();
        campos_texto_grande();
        
        System.out.println("***");
    }
      
    private void botoes_checados(){
        if(checks != null){
          for (int i = 0; i < checks.length; i++) {
                String te = checks[i].getText();
                if(checks[i].isSelected()){
                    System.out.println("escolhido: " + te );
                }
          }
        }
    }
    
    private void campos_texto_pequeno(){
        if(campos != null){
          for (int i = 0; i < campos.length; i++) {
                String txt = campos[i].getText();
                System.out.println( id_campos[i] + ": " + txt );
          }
        }
    }
    
    private void campos_texto_grande(){
        if(textos != null){
          for (int i = 0; i < textos.length; i++) {
                String txt = textos[i].getText();
                System.out.println( id_textos[i] + ": " + txt );
          }
        }
    }
      
    private String radio_selecionado(){
        if(radios != null){
            String temp = getSelectedButtonText(radios);
            return (temp!=null)?(temp):("-1");
        }else{
            return "";
        }
    }
    
    private String selecionado_na_lista(){
        if(drop != null){
            String selecionado = (String) drop.getSelectedItem();
            return selecionado;
        }else{
            return "";
        }
    }
    
    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}