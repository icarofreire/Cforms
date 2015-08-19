/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author icaro
 */
public class Forms {

    public static void GTK(){
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception e){}
    }
    
    public static void criar_formulario(){
        GTK();
        new config().setVisible(true);
    }
    
    public static void exibir_tabela(){
        GTK();
        new tabela().setVisible(true);
    }
    
    public static String[] vs_to_array(Vector<String> vs, int indice_comeco){
        
        String[] arr = new String[(vs.size()-indice_comeco)+2];
        for (int i = indice_comeco; i < vs.size(); i++) {
            arr[i] = new String();
            arr[i] = vs.elementAt(i);
        }
        return arr;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //criar_formulario();
        //exibir_tabela();
        //GTK();AboutDialog.main(args);
        
        
        
        //GTK();new formulario("cadastro-de-clientes");
        //GTK();new formulario("farmacia");
        GTK();new formulario("marcadorias");
        
        //GTK();new config_novo();
        
        
        /*
        ler_log_formulario l = new ler_log_formulario();
        l.ler("farmacia");
        l.exibir();
        */
        
        /*Vector<String> vs = new Vector<String>();
        
        vs.add("87ggf");
        vs.add("1ggf");
        vs.add("2ggf");
        vs.add("3ggf");
        vs.add("4ggf");
        vs.add("5ggf");
        vs.add("6ggf");
        String[] ss = vs.subList(0, 3).toArray(new String[]{});
        
        //String[] ss = vs_to_array(vs, 3);
        for (int i = 0; i < ss.length; i++) {
            System.out.println("Selecionado: " + ss[i] );
        }*/
        
        
        
    }
    
}
