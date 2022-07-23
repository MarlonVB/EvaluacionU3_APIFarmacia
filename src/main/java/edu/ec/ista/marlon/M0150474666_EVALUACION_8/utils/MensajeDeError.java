package edu.ec.ista.marlon.M0150474666_EVALUACION_8.utils;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

/**Este es el cambio realizado para hacer la prueba
 * de actualizar nuestro repositorio en GitHub
 * **/
public class MensajeDeError {
    private HttpStatus status;
    private String mensaje;
    private List<String> errores;
    
    public MensajeDeError(HttpStatus status, String mensaje, String error) {
        super();
        this.status = status;
        this.mensaje = mensaje;
        errores = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
