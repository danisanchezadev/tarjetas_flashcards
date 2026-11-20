package models;

import java.util.ArrayList;
import java.util.List;

public class Tema {

    private int id;
    private String nombre;
    private List<Tarjeta> listaTarejatas;


    public Tema(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.listaTarejatas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
