package com.claujulian.utils;

import java.util.Scanner;

import com.claujulian.models.Product;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    String menu = """
            \nBienvenidos!!

            1 - Crea un nuevo producto
            2 - Elimina un producto     
            4 - Modifica un producto
            3 - Busca un producto por su id
            5 - Lista los productos

            0 - Salir

            """;
    int opcionMenu;

    Product product = new Product();

    public void mostrarMenu() {
        do {
            System.out.println(menu);
            opcionMenu = scanner.nextInt();

            switch (opcionMenu) {
             case 1:
                    product.creaProducto();
                    break;
                case 2:
                    product.eliminaProducto();
                    break;
                case 3:
                    product.modificaProducto();
                    break;
                case 4:
                    product.buscaProductoPorId();
                    break;
                case 5:
                    product.listaProducto();
                    break;
    
                default:
                    System.out.println("\n:: Gestión de Pedidos terminada");
            }
        } while (opcionMenu != 0);
    }
}
