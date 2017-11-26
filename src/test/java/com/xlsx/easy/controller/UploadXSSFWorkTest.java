package com.xlsx.easy.controller;

import com.xlsx.easy.exception.IllegalSheetArgumentsException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple Test
 *
 * @Author Alex_Bao
 * @create 2017-11-09
 * create by IntelliJ IDEA
 */
public class UploadXSSFWorkTest{

    private Map<String,Boolean> definitionMap = new HashMap<String, Boolean>();
    private InputStream inputStream = new InputStream() {
        @Override
        public int read() throws IOException {
            return 0;
        }
    };

    // Simple Test
    public static void main(String[] args){
        //get definitionMap and inputStream value.

    }

    protected Map<String, Boolean> getDefinitionMap() {
        return this.definitionMap;
    }

    protected InputStream getInputStream() {
        return this.inputStream;
    }

    /** validate method **/
    public void validate(String cellName, String value, int index) throws IllegalSheetArgumentsException {
        /** valildate **/
        if("预订人姓名".equals(cellName)){
            //....
        }
    }
}
