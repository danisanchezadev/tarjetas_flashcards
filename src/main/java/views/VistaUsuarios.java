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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.Usuario;

import java.sql.SQLException;
import java.util.List;

public class VistaUsuarios {

    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    public VBox crearVista() {

        VBox contenedor = new VBox();

        contenedor.setPadding(new Insets(30));

        Label titulo = new Label("Lista de usuarios");

        titulo.setFont(new Font("Arial", 20));

        Button nuevoUsuario = agregarNuevoUsuario();

        HBox tituloYAgregar = new HBox(10);
        tituloYAgregar.setAlignment(Pos.TOP_CENTER);

        tituloYAgregar.getChildren().addAll(titulo, nuevoUsuario);

        //VBox.setMargin(titulo, new Insets(0));
        contenedor.setAlignment(Pos.TOP_CENTER);
        contenedor.setSpacing(30);

        contenedor.getChildren().add(tituloYAgregar);

        HBox contenedorUsuarios = new HBox();

        contenedorUsuarios.setAlignment(Pos.CENTER);
        contenedorUsuarios.setSpacing(20);

        try{

            List<Usuario> listaUsuarios = usuarioRepository.obtenerTodos();

            for(Usuario u: listaUsuarios){

                VBox tarjetaUsuario = agregarContenedorusuario(u);

                contenedorUsuarios.getChildren().add(tarjetaUsuario);
            }

            //Agregar una tarjeta o función de nuevo usuario.

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

        Button botonEditar = agregarBotonEditar(user);

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

            Stage stage = (Stage) scene.getWindow();

            stage.setWidth(800);
            stage.setWidth(325);
            stage.centerOnScreen();
            stage.setTitle("Temáticas de " + usuario.getNombre());

        });
        return boton;
    }

    private Button agregarBotonEditar(Usuario usuario){

        Button boton = new Button();
        boton.setGraphic(new Imagenes(("/img/editar.png"),10,10));

        boton.setOnAction(event ->{

            VistaEditarUsuario vistaEditarUsuario = new VistaEditarUsuario(usuario);

            Scene scene = boton.getScene();

            scene.setRoot(vistaEditarUsuario.crearVista());

            Stage stage = (Stage) scene.getWindow();

            stage.setWidth(400);
            stage.setHeight(175);
            stage.centerOnScreen();
        });

        return boton;
    }

    private Button agregarNuevoUsuario(){

        Button boton = new Button();
        boton.setGraphic(new Imagenes(("/img/agregar.png"),10,10));

        boton.setOnAction(event ->{

            VistaNuevoUsuario vistaNuevoUsuario = new VistaNuevoUsuario();

            Scene scene = boton.getScene();

            scene.setRoot(vistaNuevoUsuario.crearVista());

            Stage stage = (Stage) scene.getWindow();

            stage.setWidth(320);
            stage.setHeight(100);
            stage.centerOnScreen();

        });
        return boton;
    }
}
