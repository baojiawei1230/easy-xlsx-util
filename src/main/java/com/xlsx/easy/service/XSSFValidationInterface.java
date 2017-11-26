package com.xlsx.easy.service;

import com.xlsx.easy.exception.IllegalSheetArgumentsException;

/**
 * interface
 *
 * @Author Alex_Bao
 * @create 2017-11-08
 * create by IntelliJ IDEA
 */
public interface XSSFValidationInterface {

    /** params validation **/
    void validate(String cellName,String value,int index) throws IllegalSheetArgumentsException;
}
