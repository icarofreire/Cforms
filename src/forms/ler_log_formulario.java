/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author icaro
 */
public class ler_log_formulario {
    
    public int indice_titulo = 0;
    public int indice_descricao_formulario = 1;
    public int indice_tipo_componente = 2;
    public int indice_quantidade = 3;
    public int descriçao_dos_componentes = 4;
    public int indice_nomes_dos_componentes = 5;
    
    private String[] tipos_componentes = {
            "Campo de texto",
            "Botao de seleçao",
            "Lista de opçoes",
            "Area de texto"
        };
    
    /*
    Como e estruturado cada vetor de informaçoes do formulario:
        vs[0] = titulo;
        vs[1] = descriçao;
        vs[2] = tipo do componente;
        vs[3] = quantidade;
        vs[4] = descriçao do componente;
        vs[5+] = nomes dos componentes;
    */
    private Vector<String> vs = new Vector<String>();
    public Vector<Vector<String>> lista_vs = new Vector<Vector<String>>();
    private String titulo, descricao;
    
    
    public void ler(String nome_arquivo){
        
        try {
			File file = new File("logforms" + File.separator + nome_arquivo);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
                        int c_linha = 0;
			while ((line = bufferedReader.readLine()) != null) {
                                c_linha++;
				stringBuffer.append(line);
				stringBuffer.append("\n");
                                
                                //System.out.println( line );
                                
                                if( line.indexOf("<<") != -1 )
                                {
                                    titulo = line.substring(2, line.length()-2).trim();
                                }
                                
                                if( line.indexOf(":-:") != -1 )
                                {
                                    descricao = line.substring(3, line.length()-3).trim();
                                }
                                
                                
                                if( line.charAt(0) == '[' )// pega os tipos dos componentes e a  quantidade;
                                {
                                    String tipo = line.substring(1, line.indexOf(':')).trim();
                                    String q = line.substring(line.indexOf(':')+1, line.indexOf('(')).trim();
                                    String des = line.substring(line.indexOf('(')+1, line.indexOf(')')).trim();
                                    String ns = line.substring(line.indexOf('{')+1, line.lastIndexOf('}'));
                                    String[] nomes = ns.split("\\|");
                                    
                                    vs.add(titulo);     // [0] = titulo;
                                    vs.add(descricao);  // [1] = descriçao;
                                    vs.add(tipo);       // [2] = tipo do componente;
                                    vs.add(q);          // [3] = quantidade;
                                    vs.add(des);        // [4] = descriçao do componente;
                                    for (String retval: nomes) {
                                        vs.add(retval); // [5+] = nome dos componentes;
                                    }
                                }
                                
                                /*for(int i=0; i<vs.size(); i++)
                                {
                                    System.out.println(i + ": " + vs.elementAt(i) );
                                }System.out.println("***");*/
                                
                                lista_vs.add( new Vector(vs) );
                                vs.clear();
                                
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    
    public void exibir(){
        for(int i=0; i<lista_vs.size(); i++)
        {
            for(int j=0; j<lista_vs.elementAt(i).size(); j++){
                System.out.println( j + ": " + lista_vs.elementAt(i).elementAt(j) );
            }System.out.println("***");
        }
    }
    
    
}
