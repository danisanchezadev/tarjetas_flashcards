package views;

import Repository.UsuarioRepository;
import componentes.Imagenes;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Usuario;

import java.sql.SQLException;


public class VistaNuevoUsuario {

    UsuarioRepository usuarioRepository = new UsuarioRepository();
    TextField input = new TextField();

    public VBox crearVista(){

        VBox contenedorPrincipal = new VBox(10);

        contenedorPrincipal.setAlignment(Pos.TOP_CENTER);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(10));

        HBox contenedorInput = new HBox(10);

        input = new TextField();

        Button aceptar = agregarBotonAceptar();
        Button volver = agregarBotonVolver();

        contenedorInput.getChildren().addAll(input, aceptar, volver);

        contenedorPrincipal.getChildren().add(contenedorInput);

        return contenedorPrincipal;
    }

    private Button agregarBotonAceptar(){

        Button boton = new Button("Aceptar");

        boton.setOnAction(event->{

            try {

                usuarioRepository.guardar(new Usuario(input.getText()));

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        return boton;

    }

    private Button agregarBotonVolver(){

        Button boton = new Button("Volver");

        boton.setOnAction(event ->{

            VistaUsuarios vu = new VistaUsuarios();

            Scene scene = boton.getScene();

            scene.setRoot(vu.crearVista());

            Stage stage = (Stage) scene.getWindow();

            stage.setWidth(800);
            stage.setHeight(325);
            stage.centerOnScreen();
        });
        return boton;
    }
}
