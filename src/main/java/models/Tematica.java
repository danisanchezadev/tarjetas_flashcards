package models;

import java.util.ArrayList;
import java.util.List;

public class Tematica {

    private String nombre;
    private int id;
    private List<Tema> listaTemas;

    public Tematica(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.listaTemas = new ArrayList<>();
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

    public List<Tema> getListaTemas() {
        return listaTemas;
    }

    public void setListaTemas(List<Tema> listaTemas) {
        this.listaTemas = listaTemas;
    }
}
