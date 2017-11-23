package com.xlsx.easy.exception;

/**
 * IllegalSheetArgumentsException
 *
 * @Author Alex_Bao
 * @create 2017-11-23
 * create by IntelliJ IDEA
 */
public class IllegalSheetArgumentsException extends RuntimeException {

    public IllegalSheetArgumentsException() {
    }

    public IllegalSheetArgumentsException(String message) {
        super(message);
    }

    public IllegalSheetArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalSheetArgumentsException(Throwable cause) {
        super(cause);
    }
}
