package com.xlsx.easy.utils;

import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * 表格校验
 *
 * @Author Alex_Bao
 * @create 2017-11-08
 * create by IntelliJ IDEA
 */
public class CellValidationUtils {

    /**
     * 表格校验(从给定的数据中选取)
     *
     * @param sheet
     * @param textlist
     * @param firstRow
     * @param endRow
     * @param firstCol
     * @param endCol
     */
    public void setExplicitValidation(XSSFSheet sheet, String[] textlist, int firstRow, int endRow, int firstCol, int endCol) {
        XSSFDataValidationConstraint constraint = new XSSFDataValidationConstraint(textlist);
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        DataValidationHelper help = new XSSFDataValidationHelper(sheet);
        DataValidation validation = help.createValidation(constraint, regions);
        validation.createErrorBox("输入值有误", "请从下拉框中选择！");
        validation.setShowErrorBox(true);
        sheet.addValidationData(validation);
    }


    /**
     * 表格数字校验(0~9999999999范围)
     *
     * @param sheet
     * @param firstRow
     * @param lastRow
     * @param firstCol
     * @param lastCol
     */
    public void setDecimalValidate(XSSFSheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
        DataValidationConstraint constrain = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.DECIMAL, DataValidationConstraint.OperatorType.BETWEEN,"0","9999999999");
        CellRangeAddressList region = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        DataValidationHelper help = new XSSFDataValidationHelper(sheet);
        DataValidation validation = help.createValidation(constrain, region);
        validation.createErrorBox("输入值类型或大小有误", "请输入有效数字！");
        validation.setShowErrorBox(true);
        sheet.addValidationData(validation);
    }

    /**
     * 11位电话号码校验(只校验位数和类型)
     *
     * @param sheet
     * @param firstRow
     * @param lastRow
     * @param firstCol
     * @param lastCol
     */
    public void setPhoneValidate(XSSFSheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
        DataValidationConstraint constrain = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.DECIMAL, DataValidationConstraint.OperatorType.BETWEEN,"10000000000","99999999999");
        CellRangeAddressList region = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        DataValidationHelper help = new XSSFDataValidationHelper(sheet);
        DataValidation validation = help.createValidation(constrain, region);
        validation.createErrorBox("输入值类型或大小有误", "请输入11位数字手机号码！");
        validation.setShowErrorBox(true);
        sheet.addValidationData(validation);
    }

}
