package com.xlsx.easy.config;

import java.io.InputStream;
import java.util.Map;

/**
 * BuildContext
 *
 * @Author Alex_Bao
 * @create 2017-11-24
 * create by IntelliJ IDEA
 */
public class BuildContext implements java.io.Serializable {

    /** definitionMap **/
    private Map<String,Boolean> definitionMap;
    /** inputStream **/
    private InputStream inputStream;

    public BuildContext() {
    }

    public BuildContext(Map<String, Boolean> definitionMap, InputStream inputStream) {
        this.definitionMap = definitionMap;
        this.inputStream = inputStream;
    }

    public Map<String, Boolean> getDefinitionMap() {
        return definitionMap;
    }

    public void setDefinitionMap(Map<String, Boolean> definitionMap) {
        this.definitionMap = definitionMap;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
