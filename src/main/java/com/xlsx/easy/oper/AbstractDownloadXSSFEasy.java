package com.xlsx.easy.oper;

import com.xlsx.easy.config.DefaultSheetConfig;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * download
 *
 * @Author Alex_Bao
 * @create 2017-11-09
 * create by IntelliJ IDEA
 */
public abstract class AbstractDownloadXSSFEasy extends DefaultSheetConfig implements java.io.Serializable{

    /** get Headers **/
    public abstract String[] getHeaders();

    /** download the template **/
    public void downloadTemplate(HttpServletResponse response){
        try{
            /** set response parameter **/
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("octets/stream");
            response.setHeader("Content-Disposition","attachment;filename="+getFileName());
            response.setHeader("Connection","close");
            response.setHeader("Content-Type","application/vnd.ms-excel");

            /** get outPutStream **/
            OutputStream outputStream = response.getOutputStream();
            XSSFWorkbook workbook = getXSSFWorkBook();
            workbook.write(outputStream);
            outputStream.close();

        }catch (Exception e){
            throw new RuntimeException(" download the template is error ");
        }
    }
}
