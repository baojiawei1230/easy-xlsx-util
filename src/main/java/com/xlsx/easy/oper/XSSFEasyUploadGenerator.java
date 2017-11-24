package com.xlsx.easy.oper;

import com.xlsx.easy.exception.IllegalSheetArgumentsException;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * XSSFEasyUploadGenerator
 *
 * <p>
 *     使用方法:继承该类,然后重写
 *     com.xlsx.easy.oper.XSSFEasyUploadGenerator#validate(java.lang.String, java.lang.String, int)
 *     方法完成需要上传字段的校验,不符合的抛出@{link com.xlsx.easy.exception.IllegalSheetArgumentsException}即可.
 * </p>
 *
 * @Author Alex_Bao
 * @create 2017-11-23
 * create by IntelliJ IDEA
 */
public class XSSFEasyUploadGenerator extends AbstractXSSFEasyUpload{

    /** definitionMap **/
    private Map<String,Boolean> definitionMap = new HashMap<String, Boolean>();
    /** inputStream **/
    private InputStream fileInputStream;

    protected Map<String, Boolean> getDefinitionMap() {
        return this.definitionMap;
    }

    protected InputStream getInputStream() {
        return this.fileInputStream;
    }

    public void build(Map<String,Boolean> definitionMap , InputStream inputStream){
        this.definitionMap = definitionMap;
        this.fileInputStream = inputStream;
    }

    /** implements validate method **/
    public void validate(String cellName, String value, int index) throws IllegalSheetArgumentsException {
        // you need to override this method.
    }
}
