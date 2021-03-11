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
    public TablaTransiciones TablaDeTransiciones = new TablaTransiciones();

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
    
    public void GraficarTablaTransiciones(String nombreExpresion){
        String grafica = "digraph Arbol_Sintactico{\n\n"  + "arset [label=<" +"\n"+" <TABLE ALIGN=\"LEFT\">"+GraficarTransiciones(this.TablaDeTransiciones);        
        GenerarDot(grafica, "CuadroTransiciones_"+nombreExpresion);
    }
    
    public void GraficarTablaSiguientes(String nombreExpresion){
        String grafica = "digraph Arbol_Sintactico{\n\n"  + "arset [label=<" +"\n"+" <TABLE ALIGN=\"LEFT\">"+GraficaNodos(this.CuadoSiguientes);        
        GenerarDot(grafica, "CuadroSiguientes_"+nombreExpresion);
    }
    
    public void GraficarAFD(String nombreExpresion){
        String grafica = "Digraph Arbol_Sintactico{\n\n" +GenerarAFD(this.TablaDeTransiciones)+ "\n\n}";        
        GenerarDot(grafica, "AFD_"+nombreExpresion);
    }
    
    private String GenerarAFD(TablaTransiciones tabla){
        String r = "";
        for (int i = 0; i < tabla.Estados.size(); i++) {
            r= r+"S" + tabla.Estados.get(i).Id + "[label = \"" + "S"+ tabla.Estados.get(i).Id + "\"];\n";
            for (int j = 0; j < tabla.Estados.get(i).Transisiones.size(); j++) {
                r = r +"S"+tabla.Estados.get(i).Id+" -> " + "S"+tabla.Estados.get(i).Transisiones.get(j).EstadoDestino+"[label= \""+ tabla.Estados.get(i).Transisiones.get(j).Simbolo +"\"];"+"\n"; 
            }
        }
        
        return  r;
    }
    
    private String GraficarTransiciones(TablaTransiciones tabla){
        String r ="";
        r = r + "<TR>" +"\n <TD>ESTADOS</TD>" ;
        for (int i = 0; i < tabla.Simbolos.size(); i++) {
            r= r+"<TD>"+tabla.Simbolos.get(i)+"</TD>"+"\n";                                    
        }
        r = r + "</TR>" ;
        
        for (int i = 0; i < tabla.Estados.size(); i++) {
            r = r + "<TR>" +"\n";
            String siguientes = "{ ";
            for (int j = 0; j < tabla.Estados.get(i).Siguientes.size(); j++) {
                siguientes = siguientes+tabla.Estados.get(i).Siguientes.get(j)+", ";
            }
            siguientes = siguientes+" }";
            r =r + "<TD>"+tabla.Estados.get(i).Id+siguientes+"</TD>";
            for (int j = 0; j < tabla.Simbolos.size(); j++) {
                r= r+"<TD>"+BuscarEnTransiciones(tabla.Estados.get(i).Transisiones, tabla.Simbolos.get(j)) +"</TD>"+"\n"; 
            }
            r = r + "</TR>"+"\n";
        }
        r = r +"</TABLE>"+">, ];"+"\n\n}"; 
        return r;
    }
    
    private String BuscarEnTransiciones(LinkedList<Transicion> Transisiones, String simobolo){
        for (int i = 0; i < Transisiones.size(); i++) {
            if ( Transisiones.get(i).Simbolo.equals(simobolo)) {
                return Transisiones.get(i).EstadoDestino+"";
            }
        }
        return "-";
    }
    
    private String GraficaNodos(LinkedList<FilaSiguiente> tabla){
        
        String r="<TR><TD>ID</TD><TD>Simbolo</TD><TD>Siguientes</TD></TR>\n";
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
            fichero = new FileWriter(nombre+".dot");
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
