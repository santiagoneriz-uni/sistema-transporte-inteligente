package com.mycompany.sistemaeli;

public class MainPractica2 {
    public static void main(String[] args) {
        System.out.println("Practica2 - Sistema de Ecosistema Logistico Inteligente");
        
        //Ejercicio5: Integracion
        //Vehiculos de ejemplo
        System.out.println("\n VEHICULOS DE EJEMPLO...");
        
        GestionCRUD gestion = new GestionCRUD();
        
        //Crear vehiculos
        CamionAutonomo camion1 = new CamionAutonomo("CAM-001");
        CamionAutonomo camion2 = new CamionAutonomo("CAM-003");
        DronTransporte dron1 = new DronTransporte("DRN-002");
        DronTransporte dron2 = new DronTransporte("DRN-004");
        DronTransporte dron3 = new DronTransporte("DRN-001");
        
        //Registrar usando CRUD
        System.out.println("\n REGISTRANDO VEHiCULOS (CREATE)...");
        gestion.crearVehiculo(camion1);
        gestion.crearVehiculo(camion2);
        gestion.crearVehiculo(dron1);
        gestion.crearVehiculo(dron2);
        gestion.crearVehiculo(dron3);
        
        //Probar duplicado
        gestion.crearVehiculo(new CamionAutonomo("CAM-001")); //Deberia fallar
        
        //Ejercicio1: Crud
        System.out.println("EJ1: OPERACIONES CRUD");
        
        //Read - Listar
        gestion.listarVehiculos();
        
        //Read - Buscar
        System.out.println("\n Buscando vehiculo 'DRN-002':");
        Vehiculo encontrado = gestion.buscarVehiculo("DRN-002");
        if (encontrado != null) {
            System.out.println("    Encontrado: " + encontrado.getId());
        }
        
        //Update - Modificar
        System.out.println("\n Modificando ID de 'CAM-003' a 'CAM-010':");
        gestion.modificarVehiculo("CAM-003", "CAM-010");
        
        //Delete - Eliminar
        System.out.println("\n Eliminando vehiculo 'DRN-004':");
        gestion.eliminarVehiculo("DRN-004");
        
        //Verificar despues de cambios
        gestion.listarVehiculos();
        
        //Ejercicio2: Lambda forEach
        System.out.println("EJ2: EXPRESIONES LAMBDA con forEach");
        gestion.mostrarFlotaConLambda();
        
        //Ejercicio3: Streams
        System.out.println("EJ3: PROCESAMIENTO CON STREAMS");
        
        gestion.filtrarConectables();
        gestion.obtenerListaIDs();
        gestion.contarVehiculos();
        gestion.buscarPorTipo("DronTransporte");
        gestion.buscarPorTipo("CamionAutonomo");
        
        //Ejercicio4: Ordenamiento
        System.out.println("EJ4: ORDENAMIENTO");
        
        gestion.ordenarPorId();
        gestion.ordenarPorTipo();
        
        //Ejercicio6: Mejora
        System.out.println("EJ6: MEJORA - REPORTES Y ESTADISTICAS");        
        gestion.generarReporteCompleto();
    }
}
