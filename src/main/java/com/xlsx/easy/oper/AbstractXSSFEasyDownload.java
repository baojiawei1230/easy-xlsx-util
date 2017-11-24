package com.xlsx.easy.oper;

import com.xlsx.easy.config.DefaultSheetConfig;
import com.xlsx.easy.exception.SheetTemplateDownloadException;
import com.xlsx.easy.interfaces.XSSFDownloadInterface;
import com.xlsx.easy.interfaces.XSSFFileNameInterface;
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
public abstract class AbstractXSSFEasyDownload extends DefaultSheetConfig implements XSSFFileNameInterface,XSSFDownloadInterface{

    /** get Headers **/
    public abstract String[] getHeaders();

    /** download the template **/
    public void downloadTemplate(HttpServletResponse response){
        try{
            String fileName = new String(this.getFileName().getBytes("UTF-8"),"iso-8859-1");
            /** set response parameter **/
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("octets/stream;charset=UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename="+fileName+".xlsx");
            response.setHeader("Connection", "close");
            response.setHeader("Content-Type", "application/vnd.ms-excel");

            /** get outPutStream **/
            OutputStream outputStream = response.getOutputStream();
            XSSFWorkbook workbook = getXSSFWorkBook();
            workbook.write(outputStream);
            outputStream.close();

        }catch (Exception e){
            throw new SheetTemplateDownloadException("download the template error ");
        }
    }
}
