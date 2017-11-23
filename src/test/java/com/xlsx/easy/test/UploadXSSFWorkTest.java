package com.xlsx.easy.test;

import com.xlsx.easy.oper.AbstractXSSFEasyDownload;
import com.xlsx.easy.oper.AbstractXSSFEasyUpload;

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

    // Simple Test
    public static void main(String[] args){
        Map<String,Boolean> definitionMap = new HashMap<String, Boolean>();
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        final String[] headers = new String[]{"预订人姓名,预订人手机号"};

        /** upload excel template **/
        AbstractXSSFEasyUpload uploadXSSFEasy = new AbstractXSSFEasyUpload(definitionMap, inputStream) {
            public void validate(String cellName, String value, int index) {
                if ("预定人姓名".equals(cellName) && value != null) {
                    /** validation implements by your self **/

                }
            }
        };


        /** download excel template **/
        AbstractXSSFEasyDownload downloadXSSFEasy = new AbstractXSSFEasyDownload() {
            @Override
            public String[] getHeaders() {
                return headers;
            }

            @Override
            public String getFileName() {
                return "订单下载";
            }
        };
    }
}
