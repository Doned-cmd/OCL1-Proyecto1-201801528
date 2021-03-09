/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import Analizadores.Sintactico;
import Analizadores.Analizador_Lexico;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Estructuras.*;
/**
 *
 * @author bryan
 */
public class VentanaInterfaz extends javax.swing.JFrame {
    
    /**
     * Creates new form VentanaInterfaz
     */
    
    public static LinkedList<RegularExpresion> ListaArboles;
    public static LinkedList<Conjunto> ListaConjuntos;
    public static LinkedList<Ejercicio> ListaEjercicios;
    private static LinkedList<error> listaerrores = new LinkedList<>();
    private static int contador = 0;

   

   

    public static LinkedList<error> getListaerrores() {
        return listaerrores;
    }

    public static void setListaerrores(LinkedList<error> listaerrores) {
        VentanaInterfaz.listaerrores = listaerrores;
    }
    
    
    
    public VentanaInterfaz() {
        initComponents();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OpcionesArchivos = new javax.swing.JComboBox<>();
        RealizarOpcionArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MostrarArchivo = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Consola = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        GenerarAutomatas = new javax.swing.JButton();
        AnalizarEntradas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OpcionesArchivos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abrir", "Guardar", "Guardar Como", "Generar XML de Salida" }));
        OpcionesArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionesArchivosActionPerformed(evt);
            }
        });

        RealizarOpcionArchivo.setText("Realizar");
        RealizarOpcionArchivo.setToolTipText("");
        RealizarOpcionArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RealizarOpcionArchivoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(MostrarArchivo);

        jScrollPane2.setViewportView(Consola);

        jLabel1.setText("Consola");

        jLabel2.setText("Archivo de Entrada:");

        GenerarAutomatas.setText("Generar Automatas");

        AnalizarEntradas.setText("Analizar Entradas");
        AnalizarEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarEntradasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(OpcionesArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(RealizarOpcionArchivo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(GenerarAutomatas)
                        .addGap(104, 104, 104)
                        .addComponent(AnalizarEntradas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(341, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OpcionesArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RealizarOpcionArchivo))
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenerarAutomatas)
                    .addComponent(AnalizarEntradas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        OpcionesArchivos.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpcionesArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionesArchivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OpcionesArchivosActionPerformed

    private void RealizarOpcionArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealizarOpcionArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RealizarOpcionArchivoActionPerformed

    private void AnalizarEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarEntradasActionPerformed
        try {   
        //se ejecuta el lexico y sintactico.
           
            Sintactico sintactico =new Sintactico(new Analizador_Lexico(new BufferedReader( new StringReader(MostrarArchivo.getText()))));
            sintactico.parse();
            ListaArboles = sintactico.getListaArboles();
            ListaConjuntos = sintactico.getListaConjuntos();
            ListaEjercicios = sintactico.getListaEjercicios();
        /*
            ---> Lo siguiente solo fue utilizado para fines de ejemplo 
            Analizador_Lexico lexico = new Analizador_Lexico(new BufferedReader( new StringReader(MostrarArchivo.getText())));
            
            while(lexico.next_token().value != null){
                System.out.println(lexico.next_token());
            }*/            
                       
            //raiz = sintactico.getRaiz();

            for(int i = 0; i < ListaArboles.size(); i++){
                System.out.println("Expresion " + i);
                if(ListaArboles.get(i) != null){
                   ListaArboles.get(i).getArbol().GraficarSintactico( ListaArboles.get(i).getNombre());
                   IniciarTablaPreorden(ListaArboles.get(i).getArbol().Raiz, i);
                   CrearTablaPreorden(ListaArboles.get(i).getArbol().Raiz, i);
                   ListaArboles.get(i).GraficarTablaSiguientes(ListaArboles.get(i).getNombre());
                   contador = 0 ;
                }
                
                
            }
            Consola.setText(MostrarArchivo.getText());
            this.Consola.setText("Resultado: "+sintactico.resultado);
        } catch (Exception ex) {
            Consola.setText(MostrarArchivo.getText());
            Logger.getLogger(VentanaInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_AnalizarEntradasActionPerformed

    public static void CrearTablaPreorden(Nodo padre, int i){
        if (padre != null){
            crearTabla(padre, i);
            System.out.println(padre.id+padre.lexema+padre.anulable+padre.token);
            CrearTablaPreorden(padre.hijoIzq, i);
            CrearTablaPreorden(padre.hijoDer, i);   
        }
    }
    public static void IniciarTablaPreorden(Nodo padre, int i){
        if (padre != null){
            IniciarTabla(padre, i);
            //System.out.println(padre.id+padre.lexema+padre.anulable+padre.token);
            IniciarTablaPreorden(padre.hijoIzq, i);
            IniciarTablaPreorden(padre.hijoDer, i);   
        }
    } 
    private static void crearTabla(Nodo padre, int i){
        if (padre.token=="Tk_concat"){
            for(int j = 0; j<padre.hijoIzq.Ultimapos.size();j++){
                for (int k = 0; k < padre.hijoDer.Primerapos.size(); k++) {
                    for (int l = 0; l < ListaArboles.get(i).CuadoSiguientes.size(); l++) {
                        if(ListaArboles.get(i).CuadoSiguientes.get(l).id == padre.hijoIzq.Ultimapos.get(i)){
                            if(ListaArboles.get(i).CuadoSiguientes.get(l).Siguientes.indexOf(padre.hijoDer.Primerapos.get(k))==-1){
                                ListaArboles.get(i).CuadoSiguientes.get(l).Siguientes.add(padre.hijoDer.Primerapos.get(k));
                                //System.out.println("siguiente agregado");
                            }
                        }
                    }
                }
            }
            
        }
        else if(padre.token=="Tk_cer_positiva"){
            for(int j = 0; j<padre.hijoIzq.Ultimapos.size();j++){
                for (int k = 0; k < padre.hijoIzq.Primerapos.size(); k++) {
                    for (int l = 0; l < ListaArboles.get(i).CuadoSiguientes.size(); l++) {
                        if(ListaArboles.get(i).CuadoSiguientes.get(l).id == padre.hijoIzq.Ultimapos.get(i)){
                            if(ListaArboles.get(i).CuadoSiguientes.get(l).Siguientes.indexOf(padre.hijoIzq.Primerapos.get(k))==-1){
                                ListaArboles.get(i).CuadoSiguientes.get(l).Siguientes.add(padre.hijoIzq.Primerapos.get(k));
                            //System.out.println("siguiente agregado");
                            }
                        }
                    }
                }
            }
        }
        else if(padre.token=="Tk_kleene"){
            for(int j = 0; j<padre.hijoIzq.Ultimapos.size();j++){
                for (int k = 0; k < padre.hijoIzq.Primerapos.size(); k++) {
                    for (int l = 0; l < ListaArboles.get(i).CuadoSiguientes.size(); l++) {
                        if(ListaArboles.get(i).CuadoSiguientes.get(l).id == padre.hijoIzq.Ultimapos.get(i)){
                            if(ListaArboles.get(i).CuadoSiguientes.get(l).Siguientes.indexOf(padre.hijoIzq.Primerapos.get(k))==-1){
                                ListaArboles.get(i).CuadoSiguientes.get(l).Siguientes.add(padre.hijoIzq.Primerapos.get(k));
                                //System.out.println("siguiente agregado");
                            }
                        }
                    }
                }
            }
        }
    }
    private static void IniciarTabla(Nodo padre,int i){
        if (padre.token=="Tk_valor_comillas"){
            FilaSiguiente nuevafila = new FilaSiguiente(padre.id,"Tk_valor_comillas", padre.lexema);
            ListaArboles.get(i).CuadoSiguientes.add(nuevafila);
            //System.out.println("fila generada");
        }
        else if(padre.token=="Tk_caracter"){
            FilaSiguiente nuevafila = new FilaSiguiente(padre.id,"Tk_caracter", padre.lexema);
            ListaArboles.get(i).CuadoSiguientes.add(nuevafila);
            //System.out.println("fila generada");
        }   
        else if (padre.token=="Tk_id"){
            FilaSiguiente nuevafila = new FilaSiguiente(padre.id,"Tk_id", padre.lexema);
            ListaArboles.get(i).CuadoSiguientes.add(nuevafila);
            //System.out.println("fila generada");
        }
        else if (padre.token=="#"){
            FilaSiguiente nuevafila = new FilaSiguiente(padre.id,"#", "#");
            ListaArboles.get(i).CuadoSiguientes.add(nuevafila);          
            //System.out.println("fila generada");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInterfaz().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnalizarEntradas;
    private javax.swing.JTextPane Consola;
    private javax.swing.JButton GenerarAutomatas;
    private javax.swing.JTextPane MostrarArchivo;
    private javax.swing.JComboBox<String> OpcionesArchivos;
    private javax.swing.JButton RealizarOpcionArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
