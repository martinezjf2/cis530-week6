
package edu.bellevue.cis530.week6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(
            ResourceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "status", 404,
                        "error", "Not Found",
                        "message", ex.getMessage()
                ));
    }

    @ExceptionHandler(ApiClientException.class)
    public ResponseEntity<Map<String, Object>> handleApiClientException(
            ApiClientException ex) {

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body(Map.of(
                        "status", 502,
                        "error", "Bad Gateway",
                        "message", ex.getMessage()
                ));
    }

    @ExceptionHandler(WebClientException.class)
    public ResponseEntity<Map<String, Object>> handleWebClientException(
            WebClientException ex) {

        return handleApiClientException(
                new ApiClientException(
                        "Unable to retrieve data from JSONPlaceholder",
                        ex
                )
        );
    }
}
