package com.mycompany.sistemaeli;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestionCRUD {
    private ArrayList<Vehiculo> flota;
    
    public GestionCRUD() {
        this.flota = new ArrayList<>();
    }

    public GestionCRUD(ArrayList<Vehiculo> flotaExistente) {
        this.flota = flotaExistente;
    }

    //Ejercicio 1
    //Create
    public void crearVehiculo(Vehiculo v) {
        if (buscarVehiculo(v.getId()) == null) {
            flota.add(v);
            System.out.println("Vehiculo " + v.getId() + " registrado exitosamente");
        } else {
            System.out.println("Error: Ya existe un vehiculo con ID " + v.getId());
        }
    }
    
    //Read
    public void listarVehiculos() {
        if (flota.isEmpty()) {
            System.out.println("No hay vehiculos en la flota");
            return;
        }
        System.out.println("\n LISTA COMPLETA DE VEHICULOS ");
        for (Vehiculo v : flota) {
            System.out.println("ID: " + v.getId() + " | Tipo: " + v.getClass().getSimpleName());
        }
    }
    
    //Read - Buscar por ID
    public Vehiculo buscarVehiculo(String id) {
        for (Vehiculo v : flota) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }
    
    //Update - Modificar ID
    public void modificarVehiculo(String idOriginal, String nuevoId) {
        Vehiculo v = buscarVehiculo(idOriginal);
        if (v != null) {
            v.setId(nuevoId);
            System.out.println("Vehiculo modificado: " + idOriginal + " -> " + nuevoId);
        } else {
            System.out.println("No se encontro el vehiculo con ID: " + idOriginal);
        }
    }
    
    //Delete
    public void eliminarVehiculo(String id) {
        Vehiculo v = buscarVehiculo(id);
        if (v != null) {
            flota.remove(v);
            System.out.println("Vehiculo " + id + " eliminado correctamente");
        } else {
            System.out.println("No se encontro el vehiculo con ID: " + id);
        }
    } 
    
    //Ejercicio2: Expresiones Lambda con forEach
    public void mostrarFlotaConLambda() {
        System.out.println("\n FLOTA MOSTRADA CON LAMBDA (forEach) ");
        flota.forEach(v -> {
            System.out.print("ID: " + v.getId() + " | Tipo: " + v.getClass().getSimpleName() + " | Movimiento: ");
            v.patronMovimiento();
        });
    }
    
    //Ejercicio3: Streams
    //Filtrar vehiculos conectables
    public void filtrarConectables() {
        System.out.println("\n VEHICULOS CONECTABLES (con GPS) ");
        List<Vehiculo> conectables = flota.stream()
                .filter(v -> v instanceof IConectable)
                .collect(Collectors.toList());
        
        if (conectables.isEmpty()) {
            System.out.println("No hay vehiculos conectables en la flota");
        } else {
            conectables.forEach(v -> {
                System.out.print("- " + v.getId() + ": ");
                ((IConectable) v).sincronizarGPS();
            });
        }
    }
    
    //Obtener lista de IDs
    public void obtenerListaIDs() {
        System.out.println("\n LISTA DE TODOS LOS IDs ");
        List<String> ids = flota.stream()
                .map(Vehiculo::getId)
                .collect(Collectors.toList());
        System.out.println(ids);
    }
    
    //Contar vehiculos
    public void contarVehiculos() {
        long total = flota.stream().count();
        System.out.println("\n Total de vehiculos en flota: " + total);
    }
    
    //Buscar vehiculos por tipo
    public void buscarPorTipo(String tipo) {
        System.out.println("\n BUSQUEDA POR TIPO: " + tipo);
        List<Vehiculo> resultado = flota.stream()
                .filter(v -> v.getClass().getSimpleName().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
        
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron vehiculos de tipo: " + tipo);
        } else {
            resultado.forEach(v -> System.out.println("- ID: " + v.getId()));
        }
    }
    
    //Ejercico4: Ordenamiento
    //Ordenar por ID
    public void ordenarPorId() {
        System.out.println("\n VEHICULOS ORDENADOS POR ID");
        flota.stream()
                .sorted((v1, v2) -> v1.getId().compareTo(v2.getId()))
                .forEach(v -> System.out.println("ID: " + v.getId() + " | Tipo: " + v.getClass().getSimpleName()));
    }
    
    //Ordenar por tipo (Camion primero, despues Dron)
    public void ordenarPorTipo() {
        System.out.println("\nVEHICULOS ORDENADOS POR TIPO ");
        flota.stream()
                .sorted((v1, v2) -> {
                    String tipo1 = v1.getClass().getSimpleName();
                    String tipo2 = v2.getClass().getSimpleName();
                    return tipo1.compareTo(tipo2);
                })
                .forEach(v -> System.out.println("Tipo: " + v.getClass().getSimpleName() + " | ID: " + v.getId()));
    }
    
    //Ejercicio6: Mejora - Reportes y Estadisticas
    public void generarReporteCompleto() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(" REPORTE COMPLETO DE LA FLOTA");
        System.out.println("=".repeat(50));
        
        //Estadisticas
        long totalCamiones = flota.stream().filter(v -> v instanceof CamionAutonomo).count();
        long totalDrones = flota.stream().filter(v -> v instanceof DronTransporte).count();
        long totalConectables = flota.stream().filter(v -> v instanceof IConectable).count();
        
        System.out.println(" ESTADISTICAS:");
        System.out.println("   • Total vehiculos: " + flota.size());
        System.out.println("   • Camiones autonomos: " + totalCamiones);
        System.out.println("   • Drones de transporte: " + totalDrones);
        System.out.println("   • Vehiculos con GPS: " + totalConectables);
        
        //Clasificacion
        System.out.println("\n CLASIFICACION POR TIPO: ");
        System.out.print("  Camiones: ");
        flota.stream()
                .filter(v -> v instanceof CamionAutonomo)
                .map(Vehiculo::getId)
                .forEach(id -> System.out.print(id + " "));
        
        System.out.print("\n   Drones: ");
        flota.stream()
                .filter(v -> v instanceof DronTransporte)
                .map(Vehiculo::getId)
                .forEach(id -> System.out.print(id + " "));
        
        //Busqueda avanzada por patron de movimiento
        System.out.println("\n\n BUSQUEDA AVANZADA - Vehiculos que se mueven por carretera:");
        flota.stream()
                .filter(v -> {
                    //Capturar el comportamiento del metodo
                    if (v instanceof CamionAutonomo) return true;
                    return false;
                })
                .forEach(v -> System.out.println("   • " + v.getId() + " (Camion)"));
        
        System.out.println("\n BUSQUEDA AVANZADA - Vehiculos que vuelan :");
        flota.stream()
                .filter(v -> v instanceof DronTransporte)
                .forEach(v -> System.out.println("   • " + v.getId() + " (Dron)"));
    }
}
