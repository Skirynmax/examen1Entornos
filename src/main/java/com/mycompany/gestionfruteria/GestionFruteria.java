/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionfruteria;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alban
 */


/**
 * Representa un producto en una frutería con información sobre su nombre, precio por kilo y peso disponible.
 */
class ProductoFruteria {
    private String nombre;
    private double precioKilo;
    private double pesoDisponible;
   
  /**
     * Constructor de la clase ProductoFruteria.
     * 
     * @param nombre El nombre del producto.
     * @param precioKilo El precio por kilo del producto.
     * @param pesoDisponible El peso disponible del producto en kilos.
     */
    public ProductoFruteria(String nombre, double precioKilo, double pesoDisponible) {
        this.nombre = nombre;
        this.precioKilo = precioKilo;
        this.pesoDisponible = pesoDisponible;
    }
   /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }
   /**
     * Obtiene el precio por kilo del producto.
     * 
     * @return El precio por kilo del producto.
     */
    public double getPrecioKilo() {
        return precioKilo;
    }
   /**
     * Obtiene el peso disponible del producto en kilos.
     * 
     * @return El peso disponible del producto.
     */
    public double getPesoDisponible() {
        return pesoDisponible;
    }
    /**
     * Realiza la venta de una cantidad específica del producto.
     * 
     * @param peso El peso a vender en kilos.
     */
    public void venderProducto(double peso) {
        if (peso <= pesoDisponible) {
            pesoDisponible -= peso;
            System.out.println("Producto vendido: " + nombre + " (" + peso + " kg)");
        } else {
            System.out.println("No hay suficiente peso disponible de " + nombre);
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Precio por Kilo: $" + precioKilo + ", Peso Disponible: " + pesoDisponible + " kg";
    }
}
/**
 * Clase que gestiona el inventario de productos en una frutería, incluyendo agregar, mostrar y vender productos.
 */
public class GestionFruteria {
    private ArrayList<ProductoFruteria> inventario;
  /**
     * Constructor de la clase GestionFruteria.
     * Inicializa el inventario como una lista vacía.
     */
    public GestionFruteria() {
        inventario = new ArrayList<>();
       
    }
   /**
     * Agrega un nuevo producto al inventario de la frutería.
     * 
     * @param nombre El nombre del producto.
     * @param precioKilo El precio por kilo del producto.
     * @param pesoDisponible El peso disponible del producto en kilos.
     */
    public void agregarProducto(String nombre, double precioKilo, double pesoDisponible) {
        stopWatch StopWatch = new stopWatch();
        StopWatch.start();
        ProductoFruteria nuevoProducto = new ProductoFruteria(nombre, precioKilo, pesoDisponible);
        inventario.add(nuevoProducto);
        System.out.println("Producto agregado: " + nuevoProducto);
        StopWatch.stop();
        System.out.println("Duracion"+ StopWatch.getElapsedTime());
    }
   /**
     * Muestra el inventario de productos disponibles en la frutería.
     * Si el inventario está vacío, muestra un mensaje indicando que no hay productos disponibles.
     */
    public void mostrarInventario() {
        stopWatch StopWatch = new stopWatch();
        StopWatch.start();
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario de la frutería:");
            for (ProductoFruteria producto : inventario) {
                System.out.println(producto);
            }
        }
        StopWatch.stop();
        System.out.println("Duracion"+ StopWatch.getElapsedTime());
    }
   /**
     * Vende una cantidad específica de un producto del inventario.
     * 
     * @param nombre El nombre del producto a vender.
     * @param peso El peso a vender en kilos.
     */
    public void venderProducto(String nombre, double peso) {
        boolean encontrado = false;
        stopWatch StopWatch = new stopWatch();
        StopWatch.start();
        for (ProductoFruteria producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.venderProducto(peso);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado en el inventario.");
        }
        
        StopWatch.stop();
        System.out.println("Duracion"+ StopWatch.getElapsedTime());
    }
    /**
     * Método principal que ejecuta el programa de gestión de la frutería.
     * Permite al usuario agregar productos, ver el inventario, vender productos y salir.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
       
        GestionFruteria gestionFruteria = new GestionFruteria();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar producto al inventario");
            System.out.println("2. Mostrar inventario de la frutería");
            System.out.println("3. Vender producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            
            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada después de nextInt()
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Debe ingresar un número.");
                scanner.nextLine(); // Limpiar el buffer de entrada
                continue;  // Volver al inicio del bucle
            }

            switch (opcion) {
                case 1:
                    // Agregar producto
                    try {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el precio por kilo del producto: $");
                        double precioKilo = scanner.nextDouble();
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.print("Ingrese el peso disponible del producto en kilos: ");
                        double peso = scanner.nextDouble();
                        scanner.nextLine(); // Consumir el salto de línea
                        gestionFruteria.agregarProducto(nombre, precioKilo, peso);
                    } catch (InputMismatchException exception) {
                        System.out.println("Entrada inválida. Por favor ingrese números válidos.");
                        scanner.nextLine(); // Limpiar el buffer de entrada
                    }
                    break;

                case 2:
                    // Mostrar inventario
                    gestionFruteria.mostrarInventario();
                    break;

                case 3:
                    // Vender producto
                    try {
                        System.out.print("Ingrese el nombre del producto a vender: ");
                        String productoVender = scanner.nextLine();
                        System.out.print("Ingrese el peso a vender en kilos: ");
                        double pesoVender = scanner.nextDouble();
                        gestionFruteria.venderProducto(productoVender, pesoVender);
                    } catch (InputMismatchException exception) {
                        System.out.println("Entrada inválida. Por favor ingrese números válidos.");
                        scanner.nextLine(); // Limpiar el buffer de entrada
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
      
    }
}