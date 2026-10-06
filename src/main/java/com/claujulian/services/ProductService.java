package com.claujulian.services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.claujulian.exceptions.InvalidProductException;
import com.claujulian.exceptions.ProductNotFoundException;
import com.claujulian.models.Product;

public class ProductService{
    private final Scanner scanner = new Scanner(System.in);
    private final List<Product> productos = new ArrayList<>();
    private int siguienteId = 1;
    
    // Crea Producto
    public void creaProducto() {
        try{
        System.out.println("\nIngrese nombre del producto:");
        String nombre = scanner.nextLine().trim();

        System.out.println("\nIngrese stock del producto:");
        Integer stock = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nIngrese precio del producto:");
        Double precio = scanner.nextDouble();
        scanner.nextLine();

        validarDatos(nombre, stock, precio);


        Product product = new Product(siguienteId++, nombre, stock, precio);
        productos.add(product);

        System.out.println("\nProducto creado correctamente."); 

    }catch (InputMismatchException e) {
        scanner.nextLine(); 
        System.out.println("\nError: debe ingresar un valor numérico válido.");
    } catch (InvalidProductException e) {
        System.out.println("\nError: " + e.getMessage());
    }     
    }

    // Elimina Producto por Nombre
    public void eliminaProducto() {
        try {
        Product product = buscarProductoPorNombre();
        productos.remove(product);
        System.out.println("\nProducto eliminado correctamente.");
        } catch (ProductNotFoundException e){
        System.out.println("\nError: " + e.getMessage());
        }
    }

    

    // Busca Producto por Nombre
    public Product buscarProductoPorNombre() throws ProductNotFoundException {        
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        for (Product product : productos) {
            if (product.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\nProducto encontrado:");
                System.out.println(product);
                return product;
            }
        }
        throw new ProductNotFoundException(nombre);
    }

    // Modificar Producto Por Nombre
    public void modificaProducto() {
        try{
        Product product = buscarProductoPorNombre();

        System.out.println("\nIngrese el nuevo stock:");
        Integer nuevoStock = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nIngrese el nuevo precio:");
        Double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine();

        validarDatos(product.getNombre(), nuevoStock, nuevoPrecio);
        
        product.setStock(nuevoStock);
        product.setPrecio(nuevoPrecio);

        System.out.println("\nProducto modificado correctamente.");
    
    } catch (ProductNotFoundException | InvalidProductException e) {
        System.out.println("\nError: " + e.getMessage());
    } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("\nError: debe ingresar un valor numérico válido.");
    }
    }

    // Lista Productos
    public void listaProducto() {
        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos registrados.");
            return;
        }
    
        System.out.println("\n===== LISTADO DE PRODUCTOS =====");
    
        for (Product product : productos) {
            System.out.println(product);
        }
    }

     // Validaciones reutilizables
     private void validarDatos(String nombre, Integer stock, Double precio) throws InvalidProductException {
        if (nombre == null || nombre.isEmpty()) {
            throw new InvalidProductException("El nombre no puede estar vacío.");
        }
        if (stock < 0) {
            throw new InvalidProductException("El stock no puede ser negativo.");
        }
        if (precio < 0) {
            throw new InvalidProductException("El precio no puede ser negativo.");
        }
    }

}
