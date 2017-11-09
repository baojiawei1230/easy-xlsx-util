package com.xlsx.easy.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * iterator
 *
 * @Author Alex_Bao
 * @create 2017-11-09
 * create by IntelliJ IDEA
 */
public class SheetIterator implements Iterator<XSSFSheet> {
    /*** workBook **/
    private final XSSFWorkbook workBook;
    /** currentIndex **/
    private int currentIndex = 0;
    /** sheet list **/
    private List<XSSFSheet> sheetList;

    public SheetIterator(XSSFWorkbook workBook) {
        this.workBook = workBook;
        List<XSSFSheet> workBookList = null;
        int numberOfSheets = workBook.getNumberOfSheets();
        for(int i = 0 ; i  < numberOfSheets ; i++){
            workBookList = new ArrayList<XSSFSheet>();
            XSSFSheet sheet = workBook.getSheetAt(0);
            workBookList.add(sheet);
        }
        this.sheetList = workBookList;
    }

    public boolean hasNext(){
        return this.currentIndex < Array.getLength(this.sheetList);
    }

    public XSSFSheet next() {
        return sheetList.get(this.currentIndex++);
    }

    public void remove() {
        throw new UnsupportedOperationException("cannot remove items from a sheetList");
    }
}
