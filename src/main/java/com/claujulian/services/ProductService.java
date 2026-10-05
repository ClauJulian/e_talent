package com.claujulian.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.claujulian.models.Product;

public class ProductService {
    Scanner scanner = new Scanner(System.in);
    private List<Product> productos = new ArrayList<>();
    
    // Crea Producto
    public void creaProducto() {
        System.out.println("\nIngrese nombre del producto:");
        String nombre = scanner.nextLine();

        System.out.println("\nIngrese stock del producto:");
        Integer stock = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nIngrese precio del producto:");
        Double precio = scanner.nextDouble();
        scanner.nextLine();

        int id = productos.size()+1;

        Product product = new Product(id, nombre, stock, precio);
        productos.add(product);

        System.out.println("\nProducto creado correctamente.");      
    }

    // Elimina Producto por Nombre
    public void eliminaProducto() {

        Product product = buscarProductoPorNombre();

        if (product == null) {
        System.out.println("\nNo se encontró el producto.");
        return;
        }

        productos.remove(product);

        System.out.println("\nProducto eliminado correctamente.");
    }

    

    // Busca Producto por Nombre
    public Product buscarProductoPorNombre() {        
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        for (Product product : productos) {
            if (product.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\nProducto encontrado:");
                System.out.println(product);
                return product;
            }
        }
        return null;
    }

    // Modificar Producto Por Nombre
    public void modificaProducto() {

        Product product = buscarProductoPorNombre();

        if (product == null) {
        System.out.println("\nNo se encontró el producto.");
        return;
        }

        System.out.println("\nProducto encontrado:");
        System.out.println(product);


        System.out.println("\nIngrese el nuevo stock:");
        Integer nuevoStock = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nIngrese el nuevo precio:");
        Double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine();

        product.setStock(nuevoStock);
        product.setPrecio(nuevoPrecio);

        System.out.println("\nProducto modificado correctamente.");
    }

    // Lista Productos
    public void listaProducto() {
        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos registrados.");
        }
    
        System.out.println("\n===== LISTADO DE PRODUCTOS =====");
    
        for (Product product : productos) {
            System.out.println(product);
        }
    }

}
