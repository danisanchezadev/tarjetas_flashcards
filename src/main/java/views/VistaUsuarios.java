package views;

import Repository.UsuarioRepository;
import componentes.Imagenes;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.control.Label;
import models.Usuario;

import java.sql.SQLException;
import java.util.List;

public class VistaUsuarios {

    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    public VBox crearVista() {


        VBox contenedor = new VBox();

        contenedor.setPadding(new Insets(30));

        Label titulo = new Label("Lista de usuarios");

        //VBox.setMargin(titulo, new Insets(0));
        contenedor.setAlignment(Pos.TOP_CENTER);
        contenedor.setSpacing(30);

        contenedor.getChildren().add(titulo);

        HBox contenedorUsuarios = new HBox();

        contenedorUsuarios.setAlignment(Pos.CENTER);
        contenedorUsuarios.setSpacing(20);

        try{

            List<Usuario> listaUsuarios = usuarioRepository.obtenerTodos();

            for(Usuario u: listaUsuarios){

                VBox tarjetaUsuario = agregarContenedorusuario(u);

                contenedorUsuarios.getChildren().add(tarjetaUsuario);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        contenedor.getChildren().add(contenedorUsuarios);

        return contenedor;
    }

    private VBox agregarContenedorusuario(Usuario user){

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

        //Obtengo la imagen genérica de usuario desde el método imagenUsuario
        Label iconoUsuario = new Label();
        iconoUsuario.setGraphic(new Imagenes(("/img/user.png"),100,100));

        tarjetaUsuario.getChildren().add(iconoUsuario);

        HBox botones = new HBox();

        Button botonEditar = new Button();
        botonEditar.setGraphic(new Imagenes(("/img/editar.png"),10,10));

        Button usuario = botonUsuario(user);

        Button botonEliminar = new Button();
        botonEliminar.setGraphic(new Imagenes(("/img/eliminar.png"),10,10));

        botones.getChildren().addAll(botonEditar, usuario, botonEliminar);
        botones.setSpacing(5);
        botones.setAlignment(Pos.CENTER);

        tarjetaUsuario.getChildren().add(botones);

        return tarjetaUsuario;

    }

    private Button botonUsuario(Usuario usuario){

        Button boton = new Button(usuario.getNombre());

        boton.setOnAction(event ->{

            VistaTematicas vt = new VistaTematicas(usuario);

            Scene scene = boton.getScene();

            scene.setRoot(vt.crearVista());

        });

        return boton;
    }
}
