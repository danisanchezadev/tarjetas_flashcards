package app;

import database.InicializadorDB;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.VistaUsuarios;

import java.io.File;

public class FlashcardsApp extends Application {

    @Override
    public void start(Stage stage) {

        InicializadorDB inicializadorDB = new InicializadorDB();
        inicializadorDB.inicializar();

        VistaUsuarios vistaUsuarios = new VistaUsuarios();

        Scene escena = new Scene(vistaUsuarios.crearVista(), 800, 325);

        stage.setScene(escena);

        stage.setTitle("Flashcards de estudio");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}