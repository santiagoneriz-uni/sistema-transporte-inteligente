package com.mycompany.sistemaeli;

public abstract class Vehiculo {

    private final String id;

    //Constructor
    public Vehiculo(String id) {
        this.id = id;
    }

    //Metodo concreto (reutilizable)
    public String getId() {
        return id;
    }

    //Metodo abstracto (obliga a las subclases)
    public abstract void patronMovimiento();
}

