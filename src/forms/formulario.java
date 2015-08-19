/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.java.dev.designgridlayout.DesignGridLayout;

/**
 *
 * @author icaro
 */
public class formulario extends JFrame {
 
    private ButtonGroup radios; 
    private Vector<ButtonGroup> v_radios = new Vector<ButtonGroup>();//OK
    
    private JCheckBox[] checks; 
    private Vector<JCheckBox[]> v_checks = new Vector<JCheckBox[]>();//OK
    
    private JComboBox drop;
    private Vector<JComboBox> v_drop = new Vector<JComboBox>();//OK
    
    private JTextField[] campos; 
    private Vector<JTextField[]> v_campos = new Vector<JTextField[]>();//OK
    
    private String[] id_campos;
    private Vector<String[]> v_id_campos = new Vector<String[]>();//OK
    
    private JTextArea[] textos;
    private Vector<JTextArea[]> v_textos = new Vector<JTextArea[]>();//OK
    
    private String[] id_textos;
    Vector<String[]> v_id_textos = new Vector<String[]>();//OK
    
    private montar_componentes mc = new montar_componentes();
    private JScrollPane scrollpane;
 
    public formulario(String arquivo_log_formulario) {
        super("Formulario");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        if( new File("logforms" + File.separator + arquivo_log_formulario).exists() ){
            inicio(arquivo_log_formulario);
            setVisible(true);
        }else{
            System.out.println("Arquivo '"+ arquivo_log_formulario + "' não encontrado na pasta de descrições dos formulários(logforms).");
        }
    }
    
    
    public void inicio(String arquivo_log_formulario) {
        JPanel painel_central = new JPanel();
        painel_central.setLayout(new BoxLayout(painel_central, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(painel_central);
        scrollPane.setViewportView(painel_central);
        getContentPane().add(scrollPane);
        
        DesignGridLayout layout = new DesignGridLayout(this);
 
        ler_log_formulario l = new ler_log_formulario();
        l.ler(arquivo_log_formulario);
        
        setTitle(l.lista_vs.elementAt(2).firstElement());
        
        for(int i=0; i<l.lista_vs.size(); i++)
        {
            for(int j=0; j<l.lista_vs.elementAt(i).size(); j++)
            {
                int indice = j;
                String obj = l.lista_vs.elementAt(i).elementAt(j);
                
                    
                    if(obj.equalsIgnoreCase(config.txt_campo))
                    {
                        Vector<String> vs = l.lista_vs.elementAt(i);
                        if(!vs.elementAt(l.descriçao_dos_componentes).isEmpty()){
                            mc.descricao(layout, vs.elementAt(4));
                        }
                        String[] tt = vs.subList(l.indice_nomes_dos_componentes, vs.size()).toArray(new String[]{});
                        campos = mc.campos_texto(layout, tt);
                        id_campos = tt;
                        
                        /* todos os elementos serao armazenados num vetor, para depois serem passados
                        para um unico array, e todos os dados serem capiturados. O mesmo, com os nomes 
                        de cada titulo do componente, para serem usados como identificadores de cada componente de 
                        texto. 
                        Do contrario, cada elemento estava substituindo o mesmo elemento do mesmo tipo, no laco anterior; */
                        v_campos.add(campos); 
                        v_id_campos.add(id_campos);
                    }
                    
                    if(obj.equalsIgnoreCase(config.radio))
                    {
                        Vector<String> vs = l.lista_vs.elementAt(i);
                        String[] tt = vs.subList(l.indice_nomes_dos_componentes, vs.size()).toArray(new String[]{});
                        radios = mc.selecao(layout, vs.elementAt(l.descriçao_dos_componentes) ,tt);
                        v_radios.add(radios);
                    }
                    
                    if(obj.equalsIgnoreCase(config.option))
                    {
                        Vector<String> vs = l.lista_vs.elementAt(i);
                        
                        List<String> ls = vs.subList(l.indice_nomes_dos_componentes, vs.size());
                        ls.add(0, "...");
                        ls.toArray(new String[]{"..."});
                        String[] tt = ls.toArray(new String[]{});
                        
                        drop = mc.drop(layout, vs.elementAt(l.descriçao_dos_componentes)+":", tt);
                        v_drop.add(drop);
                    }
                    
                    if(obj.equalsIgnoreCase(config.txt_area))
                    {
                        Vector<String> vs = l.lista_vs.elementAt(i);
                        if(!vs.elementAt(l.descriçao_dos_componentes).isEmpty()){
                            mc.descricao(layout, vs.elementAt(4));
                        }
                        String[] tt = vs.subList(l.indice_nomes_dos_componentes, vs.size()).toArray(new String[]{});
                        textos = mc.textos(layout, tt);
                        id_textos = tt;
                        v_textos.add(textos);
                        v_id_textos.add(id_textos);
                    }
                    
                    if(obj.equalsIgnoreCase(config.check))
                    {
                        Vector<String> vs = l.lista_vs.elementAt(i);
                        String[] tt = vs.subList(l.indice_nomes_dos_componentes, vs.size()).toArray(new String[]{});
                        checks = mc.botao_check(layout, vs.elementAt(l.descriçao_dos_componentes)+":", tt);
                        v_checks.add(checks);
                    }

                
                
            }//System.out.println("***");
        }
        
        
        JButton salvar = new JButton("Cadastrar");
        JButton cancelar = new JButton("Cancelar");
        layout.emptyRow();
        layout.row().center().add(salvar).add(cancelar);
        
        
        /* Passa todos os componentes de um vetor de componentes para um unico array,
        para que todos os elementos seram interpretados/tratados; Inclusive, o nome de identificaçao de cada um deles;
        */

        vet_to_array var = new vet_to_array();
        JTextField[] campos__ = var.v_p_array(v_campos);
        
        String[] ids__ = var.v_p_array_S(v_id_campos);
        
        ButtonGroup[] radios__ = var.v_p_array_R(v_radios);
        
        JCheckBox[] checks__ = var.v_p_array_C(v_checks);
        
        JComboBox[] drop__ = var.v_p_array_D(v_drop);
        
        JTextArea[] textos__ = var.v_p_array_T(v_textos);
        
        String[] id_textos__ = var.v_p_array_S(v_id_textos);
        
        ActionListener es = new evento_enviar(radios, checks, drop, campos__, textos, ids__, id_textos);
        salvar.addActionListener(es);
        
        ActionListener ec = new evento_cancelar();
        cancelar.addActionListener(ec);
        
    }
    
    
    
    class evento_cancelar implements ActionListener {
      public void actionPerformed(ActionEvent ex) {
        dispose();
      }
    }// fim class evento_cancelar.
    
}
