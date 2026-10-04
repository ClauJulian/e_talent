package com.claujulian.utils;

import java.util.Scanner;

import com.claujulian.services.ProductService;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    String menu = """
            \nBienvenidos!!

            1 - Crea un nuevo producto
            2 - Elimina un producto     
            3 - Modifica un producto
            4 - Busca un producto por su id
            5 - Lista los productos

            0 - Salir

            """;
    int opcionMenu;

    ProductService productService = new ProductService();

    public void mostrarMenu() {
        do {
            System.out.println(menu);
            opcionMenu = scanner.nextInt();

            switch (opcionMenu) {
                case 1:
                    productService.creaProducto();
                    break;
                case 2:
                    productService.eliminaProducto();
                    break;
                case 3:
                    productService.modificaProducto();
                    break;
                case 4:
                    productService.buscarProductoPorNombre();
                    break;
                case 5:
                    productService.listaProducto();
                    break;
    
                default:
                    System.out.println("\n:: Gestión de Pedidos terminada");
            }
        } while (opcionMenu != 0);
    }
}
