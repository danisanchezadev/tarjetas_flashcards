package views;

import Repository.UsuarioRepository;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.control.Label;
import models.Usuario;

import java.sql.SQLException;
import java.util.List;

public class VistaUsuarios {

    public VBox crearVista() {

        VBox contenedor = new VBox();

        contenedor.setPadding(new Insets(30));

        Label titulo = new Label("Lista de usuarios");

        VBox.setMargin(titulo, new Insets(0));
        contenedor.setAlignment(Pos.TOP_CENTER);
        contenedor.setSpacing(30);

        contenedor.getChildren().add(titulo);

        HBox contenedorUsuarios = new HBox();

        contenedorUsuarios.setAlignment(Pos.CENTER);
        contenedorUsuarios.setSpacing(20);

        UsuarioRepository usuarioRepository = new UsuarioRepository();

        List<Usuario> listaUsuarios;

        try{

            listaUsuarios = usuarioRepository.obtenerTodos();

            for(Usuario u: listaUsuarios){

                VBox tarjetaUsuario = new VBox();

                tarjetaUsuario.setSpacing(10);

                tarjetaUsuario.setMaxWidth(180);
                tarjetaUsuario.setPadding(new Insets(20));
                tarjetaUsuario.setSpacing(10);
                tarjetaUsuario.setAlignment(Pos.CENTER);

                tarjetaUsuario.setStyle(
                        "-fx-border-color: #888888;" +
                                "-fx-border-width: 1.5;" +
                                "-fx-border-radius: 12;" +
                                "-fx-background-radius: 12;" +
                                "-fx-background-color: #F5F5F5;"
                );

                Label iconoUsuario = new Label("👤");

                tarjetaUsuario.getChildren().add(iconoUsuario);

                HBox botones = new HBox();

                Button botonEditar = new Button("✏️");
                Button usuario = new Button(u.getNombre());
                Button botonEliminar = new Button("🗑️");

                botones.getChildren().addAll(botonEditar, usuario, botonEliminar);
                botones.setSpacing(5);
                botones.setAlignment(Pos.CENTER);

                tarjetaUsuario.getChildren().add(botones);


                contenedorUsuarios.getChildren().add(tarjetaUsuario);
            }

        }catch (SQLException e){

        }
        contenedor.getChildren().add(contenedorUsuarios);

        return contenedor;
    }
}
