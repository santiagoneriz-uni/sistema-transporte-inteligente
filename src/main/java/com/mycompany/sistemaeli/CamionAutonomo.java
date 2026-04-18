package com.mycompany.sistemaeli;

public class CamionAutonomo extends Vehiculo {

    public CamionAutonomo(String id) {
        super(id);
    }

    @Override
    public void patronMovimiento() {
        System.out.println("El camion se mueve por carretera");
    }
}
