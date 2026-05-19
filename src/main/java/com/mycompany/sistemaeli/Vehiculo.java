package com.mycompany.sistemaeli;

public abstract class Vehiculo {

    private String id;  //Cambio: ya no es final

    //Constructor
    public Vehiculo(String id) {
        this.id = id;
    }

    //Getter
    public String getId() {
        return id;
    }
    
    //Setter - nuevo metodo para poder modificar el ID
    public void setId(String id) {
        this.id = id;
    }

    //Metodo abstracto (obliga a las subclases)
    public abstract void patronMovimiento();
}

