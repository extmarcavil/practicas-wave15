package com.vparula.calorias.model;

import java.util.Collection;

public class Ingrediente{
        String nombre;
    
        int calorias;
    
        public Ingrediente(String nombre, int calorias) {
            this.nombre = nombre;
            this.calorias = calorias;
        }
    
    
        public String getNombre() {
            return nombre;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public int getCalorias() {
            return calorias;
        }
    
        public void setCalorias(int calorias) {
            this.calorias = calorias;
        }
    }
