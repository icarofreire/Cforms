/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author icaro
 */
public class vet_to_array {
    
    
    public JTextField[] v_p_array(Vector<JTextField[]> v_campos){
        int tam=0, ind = 0;
        for(int i=0; i<v_campos.size(); i++){
            tam += v_campos.elementAt(i).length;
        }
        JTextField[] campos__ = new JTextField[tam];
        for(int i=0; i<v_campos.size(); i++){
            for(int j=0; j<v_campos.elementAt(i).length; j++){
                campos__[ind] = v_campos.elementAt(i)[j];
                ind++;
            }
        }
        return campos__;
    }
    
    public String[] v_p_array_S(Vector<String[]> v_campos){
        int tam=0, ind = 0;
        for(int i=0; i<v_campos.size(); i++){
            tam += v_campos.elementAt(i).length;
        }
        String[] campos__ = new String[tam];
        for(int i=0; i<v_campos.size(); i++){
            for(int j=0; j<v_campos.elementAt(i).length; j++){
                campos__[ind] = v_campos.elementAt(i)[j];
                ind++;
            }
        }
        return campos__;
    }
    
    public ButtonGroup[] v_p_array_R(Vector<ButtonGroup> v_campos){
        int tam=v_campos.size(), ind = 0;
        
        ButtonGroup[] campos__ = new ButtonGroup[tam];
        for(int i=0; i<v_campos.size(); i++){
                campos__[ind] = v_campos.elementAt(i);
                ind++;
        }
        return campos__;
    }
    
    public JCheckBox[] v_p_array_C(Vector<JCheckBox[]> v_campos){
        int tam=0, ind = 0;
        for(int i=0; i<v_campos.size(); i++){
            tam += v_campos.elementAt(i).length;
        }
        JCheckBox[] campos__ = new JCheckBox[tam];
        for(int i=0; i<v_campos.size(); i++){
            for(int j=0; j<v_campos.elementAt(i).length; j++){
                campos__[ind] = v_campos.elementAt(i)[j];
                ind++;
            }
        }
        return campos__;
    }
    
    public JComboBox[] v_p_array_D(Vector<JComboBox> v_campos){
        int tam=v_campos.size(), ind = 0;
        
        JComboBox[] campos__ = new JComboBox[tam];
        for(int i=0; i<v_campos.size(); i++){
                campos__[ind] = v_campos.elementAt(i);
                ind++;
        }
        return campos__;
    }
    
    public JTextArea[] v_p_array_T(Vector<JTextArea[]> v_campos){
        int tam=0, ind = 0;
        for(int i=0; i<v_campos.size(); i++){
            tam += v_campos.elementAt(i).length;
        }
        JTextArea[] campos__ = new JTextArea[tam];
        for(int i=0; i<v_campos.size(); i++){
            for(int j=0; j<v_campos.elementAt(i).length; j++){
                campos__[ind] = v_campos.elementAt(i)[j];
                ind++;
            }
        }
        return campos__;
    }
    
}
