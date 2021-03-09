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
public class FilaSiguiente {
    public int id;
    public String nombretoken;
    public String lexema;
    public ArrayList<Integer> Siguientes = new ArrayList<>();

    public FilaSiguiente(int id, String NombreTK,String lexema) {
        this.nombretoken = NombreTK;
        this.id = id;
        this.lexema = lexema;
    }    
}
