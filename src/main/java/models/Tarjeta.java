package models;

public class Tarjeta {

    private String caraDelantera;
    private String caraTrasera;
    private Tema tema;

    public Tarjeta(String caraDelantera, String caraTrasera){
        this.caraDelantera = caraDelantera;
        this.caraTrasera = caraTrasera;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public String getCaraTrasera() {
        return caraTrasera;
    }

    public void setCaraTrasera(String caraTrasera) {
        this.caraTrasera = caraTrasera;
    }

    public String getCaraDelantera() {
        return caraDelantera;
    }

    public void setCaraDelantera(String caraDelantera) {
        this.caraDelantera = caraDelantera;
    }
}
