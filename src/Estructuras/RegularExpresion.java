/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author bryan
 */
public class RegularExpresion {
    public Arbol Raiz; 
    public String Nombre;

    public RegularExpresion(Arbol Raiz, String Nombre) {
        this.Raiz = Raiz;
        this.Nombre = Nombre;
    }

    public Arbol getRaiz() {
        return Raiz;
    }

    public void setRaiz(Arbol Raiz) {
        this.Raiz = Raiz;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
