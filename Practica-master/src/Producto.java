import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private double costo;
    private String descripcion;
    private int cantidad;

    
    public Producto(int codigo, String nombre, double precio, double costo, String descripcion, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\nNombre: " + nombre + "\nPrecio: $" + precio + "\nCosto: $" + costo + "\nDescripción: " + descripcion + "\nCantidad: " + cantidad;
    }
}