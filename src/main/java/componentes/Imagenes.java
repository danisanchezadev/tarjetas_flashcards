package componentes;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class Imagenes extends ImageView {

    public Imagenes(String ruta, int ancho, int alto){

        try(InputStream archivo = getClass().getResourceAsStream(ruta)){

            if (archivo == null) {
                throw new IllegalArgumentException("Imagen no encontrada: " + ruta);
            }

            Image imagen = new Image(archivo);

            if (imagen.isError()) {
                throw new IllegalArgumentException(
                        "Error cargando imagen: " + ruta,
                        imagen.getException()
                );
            }

            setImage(imagen);
            setFitWidth(ancho);
            setFitHeight(alto);
            setPreserveRatio(true);

        }catch (IOException io){
            System.err.println("Error al cargar la imagen: " + io.getMessage());
        }
    }
}
