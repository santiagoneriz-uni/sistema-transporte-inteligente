package com.mycompany.sistemaeli;

public class DronTransporte extends Vehiculo implements IConectable {

    public DronTransporte(String id) {
        super(id);
    }

    @Override
    public void patronMovimiento() {
        System.out.println("El dron se mueve volando en 3D");
    }

    @Override
    public void sincronizarGPS() {
        System.out.println("Dron sincronizando con satelite...");
    }
}
