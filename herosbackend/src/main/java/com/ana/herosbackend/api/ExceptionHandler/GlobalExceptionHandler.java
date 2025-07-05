package com.ana.herosbackend.api.ExceptionHandler;

import com.ana.herosbackend.api.ExceptionHandler.Exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HeroiDuplicadoException.class)
    public ResponseEntity<ExceptionMessage> handleHeroiDuplicado(
            HeroiDuplicadoException ex
    ) {
        ExceptionMessage body = ExceptionMessage.builder()
                .httpCode(HttpStatus.CONFLICT.value())
                .errorClass(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(NenhumHeroiEncontradoException.class)
    public ResponseEntity<ExceptionMessage> handleHeroisNaoEncontrados(
            NenhumHeroiEncontradoException ex
    ) {
        ExceptionMessage body = ExceptionMessage.builder()
                .httpCode(HttpStatus.NOT_FOUND.value())
                .errorClass(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
    @ExceptionHandler(HeroiNaoEncontradoException.class)
    public ResponseEntity<ExceptionMessage> handleHeroiNaoEncontrados(
            HeroiNaoEncontradoException ex
    ) {
        ExceptionMessage body = ExceptionMessage.builder()
                .httpCode(HttpStatus.NOT_FOUND.value())
                .errorClass(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
    @ExceptionHandler(IDInvalidoException.class)
    public ResponseEntity<ExceptionMessage> handleIDInvalido(
            IDInvalidoException ex
    ) {
        ExceptionMessage body = ExceptionMessage.builder()
                .httpCode(HttpStatus.BAD_REQUEST.value())
                .errorClass(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionMessage> handleIdInvalido(MethodArgumentTypeMismatchException ex) {
        ExceptionMessage body = ExceptionMessage.builder()
                .httpCode(HttpStatus.BAD_REQUEST.value())
                .errorClass(ex.getClass().getSimpleName())
                .message("Valor inválido para o parâmetro '" + ex.getName() + "'.")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionMessage> handleInternalServerError(Exception ex) {
        ExceptionMessage body = ExceptionMessage.builder()
                .httpCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .errorClass(ex.getClass().getSimpleName())
                .message("Ocorreu um erro interno no servidor. Por favor, tente novamente mais tarde.")
                .build();


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(TamanhoCampoInvalidoException.class)
    public ResponseEntity<ExceptionMessage> handleTamanhoInvalidoError(Exception ex) {
        ExceptionMessage body = ExceptionMessage.builder()
                .httpCode(HttpStatus.BAD_REQUEST.value())
                .errorClass(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .build();


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
