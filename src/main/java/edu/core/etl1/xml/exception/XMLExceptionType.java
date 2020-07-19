package edu.core.etl1.xml.exception;

import edu.core.etl1.common.exception.ErrorCode;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public enum XMLExceptionType implements ErrorCode {

    VALIDATION_EXCEPTION(1000, "Validation Exception"),
    RETRY_EXCEPTION(5000, "Retry Exception"),
    UNKNOWN(-1, "Unknown Exception");

    private static final ConcurrentHashMap<Integer, XMLExceptionType> reverseCodeMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, XMLExceptionType> reverseMessageMap = new ConcurrentHashMap<>();

    static {
        Arrays.stream(XMLExceptionType.values())
                .forEach(type -> {
                    reverseCodeMap.put(type.code, type);
                    reverseMessageMap.put(type.message, type);
                });
    }

    private int code;
    private String message;

    XMLExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static XMLExceptionType fromCode(int code) {
        XMLExceptionType exceptionType = reverseCodeMap.get(code);
        if (exceptionType == null) {
            exceptionType = UNKNOWN;
            exceptionType.code = code;
            reverseCodeMap.put(exceptionType.code, exceptionType);
        }
        return exceptionType;
    }

    public static XMLExceptionType fromMessage(String messge) {
        XMLExceptionType exceptionType = reverseMessageMap.get(messge);
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
