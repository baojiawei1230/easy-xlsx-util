package com.xlsx.easy.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * format the cell value
 *
 * @Author Alex_Bao
 * @create 2017-11-08
 * create by IntelliJ IDEA
 */
public class CellValueFormatUtils {

    /**
     * format cell value
     *
     * @param xSSFCell
     * @return
     */
    public static String formatCellValue(XSSFCell xSSFCell) {
        String value = "";
        if (null == xSSFCell) {
            return value;
        }

        switch (xSSFCell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                /** format the date value **/
                if (HSSFDateUtil.isCellDateFormatted(xSSFCell)) {
                    SimpleDateFormat sdf = null;
                    if (xSSFCell.getCellStyle().getDataFormat() == HSSFDataFormat
                            .getBuiltinFormat("h:mm")) {
                        sdf = new SimpleDateFormat("HH:mm");
                    } else {// 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }
                    Date date = xSSFCell.getDateCellValue();
                    value = sdf.format(date);
                    break;
                } else {
                    BigDecimal big = new BigDecimal(String.valueOf(xSSFCell.getNumericCellValue()));
                    value = big.toPlainString();
                    if (null != value && !"".equals(value.trim())) {
                        String[] item = value.split("[.]");
                        if (1 < item.length && "0".equals(item[1])) {
                            value = item[0];
                        }
                    }
                    break;
                }
            /** String value **/
            case Cell.CELL_TYPE_STRING:
                value = xSSFCell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_FORMULA:
                value = String.valueOf(xSSFCell.getNumericCellValue()); //读公式计算值
                if (value.equals("NaN")) {
                    value = xSSFCell.getStringCellValue().toString();
                }
                break;
            /** blank **/
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
                /** error **/
            case Cell.CELL_TYPE_ERROR:
                value = "";
                break;
            default:
                value = formatCell(xSSFCell);
                break;
        }
        return value.trim();
    }

    /** format cell **/
    private static String formatCell(XSSFCell xSSFCell) {
        String cell = StringUtils.trimToEmpty(String.valueOf(xSSFCell));
        return cell.equals("null") ? "" : cell;
    }



}
