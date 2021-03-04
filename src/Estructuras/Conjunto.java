/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.LinkedList;

/**
 *
 * @author bryan
 */
public class Conjunto {
    public LinkedList<String> lista; 
    public String Nombre;

    public Conjunto(LinkedList<String> lista, String Nombre) {
        this.lista = lista;
        this.Nombre = Nombre;
    }

    public LinkedList<String> getRaiz() {
        return lista;
    }

    public void setRaiz(LinkedList<String> Raiz) {
        this.lista = Raiz;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
