package com.xlsx.easy.config;

import com.xlsx.easy.interfaces.XSSFHeaderInterface;
import org.apache.poi.xssf.usermodel.*;

import java.awt.*;

/**
 * Excel表单下载配置
 *
 * @Author Alex_Bao
 * @create 2017-11-08
 * create by IntelliJ IDEA
 */
public abstract class DefaultSheetConfig implements XSSFHeaderInterface {

    /** get download or update fileName **/
    public abstract String getFileName();

    /**
     * get title information for headers
     *
     * @return
     */
    public abstract String[] getHeaders();

    public XSSFWorkbook getXSSFWorkBook(){
        return getDefaultXSSFWorkBook(getFileName(),getHeaders());
    }


    private XSSFWorkbook getDefaultXSSFWorkBook(String fileName, String[] heads) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(fileName);
        setHeaderStyleAndValue(heads,workbook,sheet);
        return workbook;
    }

    /**
     * set sheet style and value
     *
     * @param headers headers
     * @param workbook workbook
     * @param sheet sheet
     */
    private void setHeaderStyleAndValue(String[] headers, XSSFWorkbook workbook, XSSFSheet sheet) {
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

        /** create the style and value of first cell  **/
        XSSFRow row = sheet.createRow(0);
        for(int i = 0 ; i < headers.length ; i++){
            XSSFCell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(headers[i]);
        }
    }

}
