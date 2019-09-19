package se.telenor.recruitment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import se.telenor.recruitment.model.ApiError;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(InvalidUserIdException.class)
    public ResponseEntity<ApiError> invalidUserIdException(InvalidUserIdException e){
        String message = e.getMessage() == null ? "IllegalUserId" : e.getMessage();
        return new ResponseEntity<>(new ApiError(message), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PathNotImplementedException.class)
    public ResponseEntity<ApiError> pathNotImplementedException(PathNotImplementedException e){
        String message = e.getMessage() == null ? "No available path" : e.getMessage();
        return new ResponseEntity<>(new ApiError(message), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
