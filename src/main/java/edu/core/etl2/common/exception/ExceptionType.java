package edu.core.etl2.common.exception;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public enum ExceptionType implements ErrorCode {

    VALIDATION_EXCEPTION(1000, "Validation Exception"),
    RETRY_EXCEPTION(5000, "Retry Exception"),
    UNKNOWN(-1, "Unknown Exception");

    private static final ConcurrentHashMap<Integer, ExceptionType> reverseCodeMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ExceptionType> reverseMessageMap = new ConcurrentHashMap<>();

    static {
        Arrays.stream(ExceptionType.values())
                .forEach(type -> {
                    reverseCodeMap.put(type.code, type);
                    reverseMessageMap.put(type.message, type);
                });
    }

    private int code;
    private String message;

    ExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ExceptionType fromCode(int code) {
        ExceptionType exceptionType = reverseCodeMap.get(code);
        if (exceptionType == null) {
            exceptionType = UNKNOWN;
            exceptionType.code = code;
            reverseCodeMap.put(exceptionType.code, exceptionType);
        }
        return exceptionType;
    }

    public static ExceptionType fromMessage(String messge) {
        ExceptionType exceptionType = reverseMessageMap.get(messge);
        if (exceptionType == null) {
            exceptionType = UNKNOWN;
            exceptionType.message = exceptionType.message + " : " + messge;
            reverseMessageMap.put(exceptionType.message, exceptionType);
        }
        return exceptionType;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ExceptionType{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
