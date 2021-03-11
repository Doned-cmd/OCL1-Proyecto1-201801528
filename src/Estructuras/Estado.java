/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author bryan
 */
public class Estado {
    public int Id;
    public ArrayList<Integer> Siguientes = new ArrayList<>();
    public LinkedList<Transicion> Transisiones = new LinkedList<>();

    public Estado(int Id) {
        this.Id = Id;
    }
}
