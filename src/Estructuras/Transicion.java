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
public class Transicion {
    public String Simbolo;
    public int EstadoDestino;

    public Transicion(String Simbolo, int EstadoDestino) {
        this.Simbolo = Simbolo;
        this.EstadoDestino = EstadoDestino;
    }
    
}
