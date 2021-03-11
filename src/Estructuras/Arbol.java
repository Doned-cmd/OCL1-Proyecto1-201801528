/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author bryan
 */
public class Arbol {
    public Nodo Raiz;    
    
    public Arbol(Nodo Raiz, int tamañohojas) {
        this.Raiz = agregarTerminal(Raiz, tamañohojas);        
    }
    
    private static Nodo agregarTerminal(Nodo raiz, int size) {
        Nodo terminal = new Nodo("#", "", size, null, null, false);
        terminal.Primerapos.add(terminal.id);
        terminal.Ultimapos.add(terminal.id);
        Nodo nuevo = new Nodo("Tk_concat", "", -1, raiz, terminal, false);
        nuevo.Primerapos = nuevo.hijoIzq.Primerapos;
        if(nuevo.hijoIzq.anulable){
            for (int i = 0; i < nuevo.hijoDer.Primerapos.size(); i++) {
                if(nuevo.Primerapos.indexOf(nuevo.hijoDer.Primerapos.get(i))==-1){
                    nuevo.Primerapos.add(nuevo.hijoDer.Primerapos.get(i));
                }
            }
        }
        nuevo.Ultimapos = nuevo.hijoDer.Ultimapos;
        if(nuevo.hijoDer.anulable){
            for (int i = 0; i < nuevo.hijoIzq.Ultimapos.size(); i++) {
                if (nuevo.Ultimapos.indexOf(nuevo.hijoIzq.Ultimapos.get(i))==-1){
                    nuevo.Ultimapos.add(nuevo.hijoIzq.Ultimapos.get(i));
                }
            }
        }
        return nuevo;
    }
    
    public void GraficarSintactico(String nombreExpresion){
        String grafica = "Digraph Arbol_Sintactico{\n\n" + GraficaNodos(this.Raiz, "0") + "\n\n}";        
        GenerarDot(grafica, nombreExpresion);

    }
    
    private String GraficaNodos(Nodo nodo, String i){
        int k=0; 
        String r = "";
        String nodoTerm = nodo.token;
        nodoTerm = nodoTerm.replace("\"", "");
        String primeros = "";
        String utlimos = "";
        for (int j = 0; j < nodo.Primerapos.size(); j++) {
            primeros = primeros + nodo.Primerapos.get(j) +",";
        }
        for (int j = 0; j < nodo.Ultimapos.size(); j++) {
            utlimos = utlimos + nodo.Ultimapos.get(j) +",";
        }
        r= "node" + i + "[label = \" {" +nodo.anulable+"|"+"{["+primeros+"]"+"|"+nodoTerm+"|"+"[" +utlimos+ "]}\"];\n";
        
        for(int j =0 ; j<nodo.hijos.size(); j++){
            r = r + "node" + i + " -> node" + i + k + "\n";
            r= r + GraficaNodos(nodo.hijos.get(j), ""+i+k);
            k++;
            System.out.println(nodo.id);
        }
        
        if( !(nodo.lexema.equals("")) ){
            String nodoToken = nodo.lexema;
            nodoToken = nodoToken.replace("\"", "");
            r += "node" + i + "c[label = \"" + nodoToken + "\"];\n";
            r += "node" + i + " -> node" + i + "c\n";
            System.out.println(nodo.id);
        }
        
        return r;
    }
    
    private void GenerarDot(String cadena, String nombre){
        FileWriter fichero = null;
        PrintWriter escritor = null;
        try{
            fichero = new FileWriter("Arbol_"+nombre+".dot");
            escritor = new PrintWriter(fichero);
            escritor.println(cadena);
            escritor.close();
            fichero.close();
            //reportar(nombre);
        } catch (Exception e) {
            System.out.println("error en generar dot");
            e.printStackTrace();
        }
    }
    
//    public void reportar(String nombre) throws IOException {
//        
//        String file_input_path = "Arbol_"+nombre+".dot";
//        String do_path = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
//        
//        String file_get_path =  "Arbol_Sintactico_"+nombre+".jpg" ;
//        try {
//            ProcessBuilder pBuilder;
//            pBuilder = new ProcessBuilder(do_path, "-Tjpg", "-o", file_get_path, file_input_path);
//            pBuilder.redirectErrorStream(true);
//            pBuilder.start();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//       
//     
//       Desktop.getDesktop().open(new File(file_get_path));
//    }
    public void reportar() throws IOException{
        Runtime runtime = Runtime.getRuntime();
        Process p = null;
    }
}
