package com.bkcompleto.produtos.handler;

import com.bkcompleto.produtos.model.error.ErrorMessage;
import com.bkcompleto.produtos.model.exception.ResourcesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<?> handleResourceNFE(ResourcesNotFoundException ex){
        ErrorMessage error = new ErrorMessage("Not Found", 404, ex.getMessage());
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
}
