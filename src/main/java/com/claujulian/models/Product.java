package com.claujulian.models;

public class Product {
    private Integer id;
    private String nombre;
    private Integer stock;
    private Double precio;

    public Product(){}
    public Product(String nombre, Integer stock,Double precio){
        this.nombre=nombre;
        this.stock=stock;
        this.precio=precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{");
        //sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", stock=").append(stock);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }

   
}
