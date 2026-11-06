package models;

import java.util.ArrayList;
import java.util.List;

public class Tema {


    private String nombre;
    private List<Tarjeta> listaTarejatas;


    public Tema(String nombre){
        this.nombre = nombre;
        this.listaTarejatas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tarjeta> getListaTarejatas() {
        return listaTarejatas;
    }

    public void setListaTarejatas(List<Tarjeta> listaTarejatas) {
        this.listaTarejatas = listaTarejatas;
    }

    public void agregarTarjeta(Tarjeta tarjeta){
        listaTarejatas.add(tarjeta);
    }
}
