package views;

import Repository.TematicaRepository;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Usuario;

public class VistaNuevaTematica {

    TematicaRepository tematicaRepository = new TematicaRepository();
    private Usuario usuario;
    TextField input = new TextField();

    public VistaNuevaTematica(Usuario usuario){
        this.usuario = usuario;
    }

    public VBox crearVista(){

        VBox contenedorPrincipal = new VBox();
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setAlignment(Pos.TOP_CENTER);

        Button aceptar = new Button();
        Button volver = agregarBotonVolver();

        HBox contenedorAgregar = new HBox(10, input, aceptar, volver);
        contenedorAgregar.setAlignment(Pos.TOP_CENTER);
        contenedorAgregar.setPadding(new Insets(10));

        contenedorPrincipal.getChildren().add(contenedorAgregar);

        return contenedorPrincipal;

    }

    private Button agregarBotonVolver(){

        Button boton = new Button("Volver");

        boton.setOnAction(event ->{

            VistaTematicas vu = new VistaTematicas(usuario);

            Scene scene = boton.getScene();

            scene.setRoot(vu.crearVista());

            Stage stage = (Stage) scene.getWindow();

            stage.setWidth(800);
            stage.setWidth(325);
            stage.centerOnScreen();
            stage.setTitle("Temáticas de " + usuario.getNombre());


        });

        return boton;
    }



















}
