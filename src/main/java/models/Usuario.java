package models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private int id;
    private String nombre;
    private List<Tematica> listaTematicas;

    public Usuario(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.listaTematicas = new ArrayList<>();
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.listaTematicas = new ArrayList<>();
    }

    public Usuario(){

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

    public List<Tematica> getListaTematicas() {
        return listaTematicas;
    }

    public void setListaTematicas(List<Tematica> listaTematicas) {
        this.listaTematicas = listaTematicas;
    }
}
