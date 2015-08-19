/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author icaro
 */
public class sobre {
    sobre(){
        JOptionPane.showMessageDialog(new JFrame(),
            "Desenvolvido por: Ícaro Martins.\n"+
            "Email: icarofre99@gmail.com\n"+
            "icaro.ns@hotmail.com",
            "Sobre",
            JOptionPane.PLAIN_MESSAGE);
    }
}
