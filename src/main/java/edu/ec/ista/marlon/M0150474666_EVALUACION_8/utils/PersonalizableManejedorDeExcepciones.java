package edu.ec.ista.marlon.M0150474666_EVALUACION_8.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PersonalizableManejedorDeExcepciones extends ResponseEntityExceptionHandler {

    private String mensaje;
    private HttpStatus status;

    public PersonalizableManejedorDeExcepciones() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    protected ResponseEntity handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        StringBuilder constructor = new StringBuilder();
        constructor.append(ex.getMethod());
        constructor.append(
                getMensaje());
        ex.getSupportedHttpMethods().forEach(t -> constructor.append(t + " "));

        MensajeDeError mensajeDeError = new MensajeDeError(getStatus(),
                ex.getLocalizedMessage(), constructor.toString());
        return new ResponseEntity<Object>(
                mensajeDeError, new HttpHeaders(), mensajeDeError.getStatus());
    }
}
