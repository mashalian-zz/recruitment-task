package se.telenor.recruitment.exceptions;

public class PathNotImplementedException extends RuntimeException {
    public PathNotImplementedException() {
    }

    public PathNotImplementedException(String message) {
        super(message);
    }
}
