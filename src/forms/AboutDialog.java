/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author icaro
 */
public class AboutDialog extends JDialog implements ActionListener {
    
    /* coloca os componentes no centro da tela. */
    public void centro(JComponent c){
        c.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
  public AboutDialog(JFrame parent, String title, String message) {
    super(parent, title, true);
    if (parent != null) {
      Dimension parentSize = parent.getSize(); 
      Point p = parent.getLocation(); 
      setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
    }
    
    JPanel painel_central = new JPanel();
    painel_central.setLayout(new BoxLayout(painel_central, BoxLayout.Y_AXIS));
    JScrollPane scrollPane = new JScrollPane(painel_central);
    scrollPane.setViewportView(painel_central);
    
    JPanel messagePane = new JPanel();
    messagePane.add(new JLabel(message));
    getContentPane().add(messagePane);
    JPanel buttonPane = new JPanel();
    JButton button = new JButton("OK"); 
    buttonPane.add(button); 
    button.addActionListener(this);
    
    for(int i=0;i<20; i++)
    {
        JButton b = new JButton("ok");
        this.centro(b);
        painel_central.add(b);
        painel_central.add(Box.createRigidArea(new Dimension(10, 10))); // adiciona espaço entre os componentes;
    }
    
    
    getContentPane().add(scrollPane);
    
    getContentPane().add(buttonPane, BorderLayout.SOUTH);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(400, 800);
    setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
    setVisible(false); 
    dispose(); 
  }
  public static void main(String[] a) {
    AboutDialog dlg = new AboutDialog(new JFrame(), "Formulario", "message");
  }
}