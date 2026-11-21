package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.VistaUsuarios;

public class FlashcardsApp extends Application {

    @Override
    public void start(Stage stage) {

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