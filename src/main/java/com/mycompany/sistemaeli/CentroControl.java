package com.mycompany.sistemaeli;
import java.util.ArrayList;

public class CentroControl {

    private final ArrayList<Vehiculo> flota;

    public CentroControl() {
        flota = new ArrayList<>();
    }

    //Agregacion
    public void registrarUnidad(Vehiculo v) {
        flota.add(v);
    }

    //Polimorfismo
    public void monitorearFlota() {
        for (Vehiculo v : flota) {
            System.out.println("Vehiculo ID: " + v.getId());
            v.patronMovimiento();
        }
    }
}
