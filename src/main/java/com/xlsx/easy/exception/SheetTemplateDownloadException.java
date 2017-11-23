package com.xlsx.easy.exception;

/**
 * SheetTemplateUploadException
 *
 * @Author Alex_Bao
 * @create 2017-11-23
 * create by IntelliJ IDEA
 */
public class SheetTemplateDownloadException extends RuntimeException {

    public SheetTemplateDownloadException() {
    }

    public SheetTemplateDownloadException(String message) {
        super(message);
    }

    public SheetTemplateDownloadException(String message, Throwable cause) {
        super(message, cause);
    }

    public SheetTemplateDownloadException(Throwable cause) {
        super(cause);
    }
}
