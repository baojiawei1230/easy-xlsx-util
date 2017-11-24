package com.xlsx.easy.oper;

import com.xlsx.easy.exception.IllegalSheetArgumentsException;
import com.xlsx.easy.interfaces.XSSFValidationInterface;
import com.xlsx.easy.utils.CellValueFormatUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.HashMap;
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
public abstract class AbstractXSSFEasyUpload implements XSSFValidationInterface{

    /**
     * 字段Map key:字段 value:该字段是否需要进行校验
     **/
    private Map<String, Boolean> definitionMap = new HashMap<String, Boolean>();
    /**
     * 文档输入流
     **/
    private InputStream fileInputStream;

    /** 初始化的时候进行校验 **/
    public AbstractXSSFEasyUpload() {
        this.definitionMap = this.getDefinitionMap();
        this.fileInputStream = this.getInputStream();
        this.SheetValidate();
    }

    /** get DefinitionMap **/
    protected abstract Map<String,Boolean> getDefinitionMap();

    /** get FileInputStream **/
    protected abstract InputStream getInputStream();

    /**
     * 参数校验
     **/
    public void SheetValidate() {
        try {
            /** validate definitionMap **/
            if (definitionMap.isEmpty()) {
                throw new IllegalSheetArgumentsException("definitionMap must not be null");
            }
            /** validate inputStream **/
            if (fileInputStream == null) {
                throw new IllegalSheetArgumentsException("inputStream must not be null");
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
                            throw new IllegalSheetArgumentsException("cellNameSet can not be null");
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
                                    /**
                                     * TODO fix
                                     *
                                     * 如果放在一个地方校验的话,肯定会有很多的if else,
                                     * 所以这里使用策略模式进行改写.
                                     */
                                }
                            }
                        }
                    }catch (IllegalSheetArgumentsException ae) {
                        /** illegalArgumentException **/
                        throw new IllegalSheetArgumentsException(ae.getMessage());
                    }
                }
            }
        }catch (Exception e) {
            /** other Exception **/
            e.printStackTrace();
        }
    }
}
