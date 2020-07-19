package edu.core.etl2.common.exception;

public class BaseException extends RuntimeException {

    private final ExceptionType exceptionType;

    public BaseException(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public BaseException(int code) {
        exceptionType = ExceptionType.fromCode(code);
    }

    public BaseException(String message) {
        super(message);
        exceptionType = ExceptionType.fromMessage(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        exceptionType = ExceptionType.fromMessage(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
        exceptionType = (cause != null) ?
                ExceptionType.fromMessage(cause.getMessage()) :
                ExceptionType.UNKNOWN;
    }
}
