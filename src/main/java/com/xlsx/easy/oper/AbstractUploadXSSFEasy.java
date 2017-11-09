package com.xlsx.easy.oper;

import com.xlsx.easy.interfaces.XSSFValidationInterface;
import com.xlsx.easy.utils.CellValueFormatUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * entity
 *
 * @Author Alex_Bao
 * @create 2017-11-08
 * create by IntelliJ IDEA
 */
public abstract class AbstractUploadXSSFEasy implements XSSFValidationInterface,java.io.Serializable {

    /**
     * 字段Map key:字段 value:该字段是否需要进行校验
     **/
    private Map<String, Boolean> definitionMap;
    /**
     * 文档输入流
     **/
    private InputStream fileInputStream;

    /** 初始化的时候进行校验 **/
    public AbstractUploadXSSFEasy(Map<String, Boolean> definitionMap, InputStream fileInputStream) {
        this.definitionMap = definitionMap;
        this.fileInputStream = fileInputStream;
        this.SheetValidate();
    }

    /**
     * 参数校验
     **/
    public void SheetValidate() {
        try {
            /** validate **/
            if (definitionMap.isEmpty()) {
                throw new IllegalArgumentException("definitionMap is null");
            }
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            Iterator<XSSFSheet> iterator = workbook.iterator();
            while (iterator.hasNext()) {
                /** sheet number **/
                XSSFSheet sheet = iterator.next();
                int rows = sheet.getPhysicalNumberOfRows();
                /** row number begin from number 1 **/
                for (int row = 1; row < rows; row++) {
                    try {
                        Set<String> cellNameSet = definitionMap.keySet();
                        if (cellNameSet == null || cellNameSet.size() == 0) {
                            throw new IllegalArgumentException("cellNameSet is null");
                        }
                        XSSFRow sheetRow = sheet.getRow(row);
                        for(int index =0 ; index < cellNameSet.size() ; index++){
                            Iterator<String> cellNameIterator = cellNameSet.iterator();
                            while (cellNameIterator.hasNext()) {
                                /** get cell name **/
                                String cellName = cellNameIterator.next();
                                /** isValidate **/
                                Boolean isValidate = definitionMap.get(cellName);
                                if (isValidate) {
                                    /** get cell value **/
                                    String value = CellValueFormatUtils.formatCellValue(sheetRow.getCell(index));
                                    /** implements validation **/
                                    validate(cellName,value,row+1);
                                }
                            }
                        }
                    }catch (IllegalArgumentException ae) {
                        /** illegalArgumentException **/
                        throw new IllegalArgumentException(ae.getMessage());
                    }
                }
            }
        }catch (Exception e) {
            /** other Exception **/
            e.printStackTrace();
        }
    }
}
