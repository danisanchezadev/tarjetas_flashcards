package models;

import java.util.ArrayList;
import java.util.List;

public class Tematica {

    private String nombre;
    private List<Tema> listaTemas;

    public Tematica(String nombre){
        this.nombre = nombre;
        this.listaTemas = new ArrayList<>();
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
