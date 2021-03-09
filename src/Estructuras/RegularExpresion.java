/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author bryan
 */
public class RegularExpresion {
    public Arbol arbol; 
    public String Nombre;
    public LinkedList<FilaSiguiente> CuadoSiguientes = new LinkedList<>();

    public RegularExpresion(Arbol arbol, String Nombre) {
        this.arbol = arbol;
        this.Nombre = Nombre;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public void setRaiz(Arbol arbol) {
        this.arbol = arbol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
    public void GraficarTablaSiguientes(String nombreExpresion){
        String grafica = "digraph Arbol_Sintactico{\n\n"  + "arset [label=<" +"\n"+" <TABLE ALIGN=\"LEFT\">"+GraficaNodos(this.CuadoSiguientes);        
        GenerarDot(grafica, nombreExpresion);

    }
    
    
    private String GraficaNodos(LinkedList<FilaSiguiente> tabla){
        
        String r="";
        for (int j = 0; j < tabla.size(); j++) {
            r = r+"<TR>";
            String lexema = tabla.get(j).lexema;
            String id = tabla.get(j).id+"";
            String siguientes = "";
            for (int k = 0; k < tabla.get(j).Siguientes.size(); k++) {
                siguientes= siguientes+tabla.get(j).Siguientes.get(k)+",";
            }
            r= r+"<TD>"+id+"</TD>"+"\n"+"<TD>"+lexema+"</TD>"+"\n"+"<TD>"+siguientes+"</TD>"+"\n";
            
            r = r +"</TR>"+"\n";
        }
        
        //nodoTerm = nodoTerm.replace("\"", "");
        
        
        r = r +"</TABLE>"+">, ];"+"\n\n}"; 
        
        return r;
    }
    
    private void GenerarDot(String cadena, String nombre){
        FileWriter fichero = null;
        PrintWriter escritor = null;
        try{
            fichero = new FileWriter("CuadroSiguientes_"+nombre+".dot");
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
