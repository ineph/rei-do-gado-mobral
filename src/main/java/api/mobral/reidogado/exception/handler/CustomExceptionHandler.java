package api.mobral.reidogado.exception.handler;

import api.mobral.reidogado.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomResponse> manipuladorException(CustomException ex) {
        CustomResponse res = new CustomResponse(ex.getMensagem(), ex.getHttpStatus());
        return new ResponseEntity<>(res, ex.getHttpStatus());
    }
}
