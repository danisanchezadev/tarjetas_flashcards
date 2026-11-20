package views;

import Repository.TematicaRepository;
import componentes.Imagenes;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Tematica;
import models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class VistaTematicas {

    private Usuario usuario;
    private TematicaRepository tematicaRepository = new TematicaRepository();
    List<Tematica> listaTematicas = new ArrayList<>();

    public VistaTematicas(Usuario usuario) {
        this.usuario = usuario;

    }

    public VBox crearVista() {

        VBox contenedorPrincipal = new VBox(10);

        contenedorPrincipal.setPadding(new Insets(30));

        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setSpacing(20);

        Label titulo = new Label("Lista de temáticas");

        contenedorPrincipal.getChildren().add(titulo);

        HBox contenedorTematicas = new HBox();

        contenedorTematicas.setAlignment(Pos.CENTER);
        contenedorTematicas.setSpacing(30);

        listaTematicas = tematicaRepository.obtenerPorUsuario(usuario.getId());

        for (Tematica t : listaTematicas) {

            VBox tarjetaTematica = agregarTarjetaTematica(t);

            contenedorTematicas.getChildren().add(tarjetaTematica);

        }

        contenedorPrincipal.getChildren().add(contenedorTematicas);

        Button volver = botonVolver();

        contenedorPrincipal.getChildren().add(volver);

        return contenedorPrincipal;
    }


    private VBox agregarTarjetaTematica(Tematica tematica) {

        VBox tarjetaTematica = new VBox();

        tarjetaTematica.setSpacing(10);

        tarjetaTematica.setMaxWidth(180);
        tarjetaTematica.setPadding(new Insets(20));
        tarjetaTematica.setSpacing(10);
        tarjetaTematica.setAlignment(Pos.CENTER);

        tarjetaTematica.setStyle(
                "-fx-border-color: #888888;" +
                        "-fx-border-width: 1.5;" +
                        "-fx-border-radius: 12;" +
                        "-fx-background-radius: 12;" +
                        "-fx-background-color: #F5F5F5;"
        );

        //Obtengo la imagen genérica de usuario desde el método imagenUsuario
        Label iconoTematica = new Label();
        iconoTematica.setGraphic(new Imagenes(("/img/user.png"), 100, 100));

        tarjetaTematica.getChildren().add(iconoTematica);

        HBox botones = new HBox();

        Button botonEditar = new Button();
        botonEditar.setGraphic(new Imagenes(("/img/editar.png"), 10, 10));

        Button tem = new Button(tematica.getNombre());

        Button botonEliminar = new Button();
        botonEliminar.setGraphic(new Imagenes(("/img/eliminar.png"), 10, 10));

        botones.getChildren().addAll(botonEditar, tem, botonEliminar);
        botones.setSpacing(5);
        botones.setAlignment(Pos.CENTER);

        tarjetaTematica.getChildren().add(botones);

        return tarjetaTematica;

    }

    private Button botonVolver(){

        Button boton = new Button("Volver");

        boton.setOnAction(event ->{

            VistaUsuarios vu = new VistaUsuarios();

            Scene scene = boton.getScene();

            scene.setRoot(vu.crearVista());


        });

        return boton;
    }
}
