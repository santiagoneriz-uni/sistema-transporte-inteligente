package com.mycompany.sistemaeli;

public class SistemaELI {
    public static void main(String[] args) {

        CentroControl control = new CentroControl();

        DronTransporte dron1 = new DronTransporte("D-01");
        CamionAutonomo camion1 = new CamionAutonomo("C-01");

        control.registrarUnidad(dron1);
        control.registrarUnidad(camion1);

        control.monitorearFlota();

        //Ejemplo de interfaz
        dron1.sincronizarGPS();
    }
}