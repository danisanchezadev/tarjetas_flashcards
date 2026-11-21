package views;

import Repository.UsuarioRepository;
import componentes.Imagenes;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Usuario;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VistaEditarUsuario {

    private final UsuarioRepository usuarioRepository = new UsuarioRepository();
    private final Usuario usuario;
    private TextField inputNuevoNombre;

    public VistaEditarUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public VBox crearVista(){

        //Creo una etiqueta para recordar para qué sirve la ventana
        Label labelNuevoNombre = new Label("Editar nombre");
        labelNuevoNombre.setFont(new Font("Arial", 12));

        Label informacionFormato = new Label();
        informacionFormato.setGraphic(new Imagenes("/img/ayuda.png", 15,15));

        Tooltip info = new Tooltip("Formato: letras y números; entre 3 y 10 caracteres.");
        info.setFont(new Font("Arial", 12));
        info.setShowDelay(Duration.millis(300));
        Tooltip.install(informacionFormato,info);

        HBox editarYFormato = new HBox(10, labelNuevoNombre, informacionFormato);
        editarYFormato.setAlignment(Pos.TOP_CENTER);

        //Creo el input donde se va a modificar el nombre del usuario, con el nombre del usuario ya escrito en él
        inputNuevoNombre = new TextField();
        inputNuevoNombre.setText(usuario.getNombre());

        //Creo el botón aceptar que llevará a cabo el cambio
        Button boton = agregarBotonAceptar();

        //Creo un contenedor horizontal que tendrá el input y el botón
        HBox contenedorInput = new HBox(10, inputNuevoNombre, boton);
        contenedorInput.setAlignment(Pos.TOP_CENTER);

        //Creo un botón de volver
        Button botonVolver = agregarBotonVolver();

        //Agrego tod0 al contenedor principal
        VBox contenedorPrincipal = new VBox(10, editarYFormato, contenedorInput, botonVolver);

        //Configuro el contenedor principal
        contenedorPrincipal.setPadding(new Insets(20));
        contenedorPrincipal.setAlignment(Pos.TOP_CENTER);

        return contenedorPrincipal;
    }

    //Méthod para crear el botón
    private Button agregarBotonAceptar(){

        //Tendrá el texto aceptar
        Button boton = new Button("Aceptar");

        boton.setOnAction(event->{

            //Se crea el usuario con el nombre nuevo
            Usuario nuevoNombre = new Usuario(usuario.getId(), inputNuevoNombre.getText());

            //Comprobaciones

            //El nombre tiene que tener al menos 3 letras y máximo 10, no puede tener símbolos
            Pattern patron = Pattern.compile("\\w{3,10}");
            Matcher matcher = patron.matcher(inputNuevoNombre.getText());

            if(matcher.matches() && !inputNuevoNombre.getText().equals(usuario.getNombre())){

                try {

                    usuarioRepository.editar(nuevoNombre);

                    cambiarEstiloletraInput("#4CAF50");

                } catch (SQLException e) {

                    cambiarEstiloletraInput("#F54927");

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error al cambiar nombre");
                    alert.setContentText("Hubo un error de conexión y no se puedo cambiar el nombre.\n"
                            + e.getMessage());
                }

            }else{
                cambiarEstiloletraInput("#F54927");
                inputNuevoNombre.setText(usuario.getNombre());
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

    private void cambiarEstiloletraInput(String color){

        inputNuevoNombre.setStyle("-fx-background-color: " + color + ";");

        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));

        pause.setOnFinished(ev-> inputNuevoNombre.setStyle(""));

        pause.play();
    }















}
