/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;
/**
 *
 * @author bryan
 */
public class Nodo {

   
    public String token;
    public String lexema;
    public int id;
    
    public Nodo hijoIzq;
    public Nodo hijoDer;
    
    public boolean anulable;
    
    public ArrayList<Nodo> hijos = new ArrayList<>();
    
    public ArrayList<Integer> Primerapos = new ArrayList<>();
    public ArrayList<Integer> Ultimapos = new ArrayList<>();
    
    public Nodo(String token, String lexema, int id, Nodo hijoIzq, Nodo hijoDer, boolean  anulable) {
        this.token = token;
        this.lexema = lexema;
        this.id = id;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
        this.anulable = anulable;
        if (hijoIzq != null){
            this.hijos.add(hijoIzq);
        }if (hijoDer != null){
            this.hijos.add(hijoDer);
        }        
    }
        
}
