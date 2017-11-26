package com.xlsx.easy.config;

import com.xlsx.easy.dto.BaseQueryDto;
import com.xlsx.easy.service.TemplateItemReader;
import com.xlsx.easy.service.XSSFHeaderInterface;
import org.apache.poi.xssf.usermodel.*;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Excel表单下载配置
 *
 * @Author Alex_Bao
 * @create 2017-11-08
 * create by IntelliJ IDEA
 */
public abstract class DefaultSheetConfig implements XSSFHeaderInterface,TemplateItemReader {

    /** get download or update fileName **/
    public abstract String getFileName();

    /**
     * get title information for headers
     *
     * @return
     */
    public abstract String[] getHeaders();

    public XSSFWorkbook getXSSFWorkBook(boolean haveData){
        return getDefaultXSSFWorkBook(getFileName(),getHeaders(),haveData);
    }


    private XSSFWorkbook getDefaultXSSFWorkBook(String fileName, String[] heads,boolean haveData) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(fileName);
        setHeaderStyleAndValue(heads,workbook,sheet,haveData);
        return workbook;
    }

    /**
     * set sheet style and value
     *
     * @param headers headers
     * @param workbook workbook
     * @param sheet sheet
     */
    private void setHeaderStyleAndValue(String[] headers, XSSFWorkbook workbook, XSSFSheet sheet,boolean haveData) {
        XSSFCellStyle cellStyle = workbook.createCellStyle();

        /** set style **/
        cellStyle.setFillForegroundColor(new XSSFColor(new Color(253, 251, 219)));
        cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

        /** font style **/
        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        cellStyle.setFont(font);

        //TODO 返回查询的对象,然后针对属性封装.
        //List list = this.queryDataList();

        /** create the style and value of first cell  **/
        XSSFRow row = sheet.createRow(0);
        for(int i = 0 ; i < headers.length ; i++){
            XSSFCell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(headers[i]);
        }
    }
}
