package com.xlsx.easy.oper;

import com.xlsx.easy.dto.BaseQueryDto;

import java.util.List;

/**
 * XSSFEasyDownloadGenerator
 *
 * <p>
 *     使用方法:继承该Factory类,然后重写com.xlsx.easy.oper.XSSFEasyDownloadGenerator#getFileName()
 *     以及com.xlsx.easy.oper.XSSFEasyDownloadGenerator#getHeaders()方法即可.
 * </p>
 *
 * @Author Alex_Bao
 * @create 2017-11-24
 * create by IntelliJ IDEA
 */
public class XSSFEasyDownloadGenerator extends AbstractXSSFEasyDownload {

    /** you need to override this method **/
    public String getFileName() {
        return null;
    }

    /** you need to override this method **/
    public String[] getHeaders() {
        return new String[0];
    }

    /** you need to override this method **/
    public List queryDataList(BaseQueryDto condition) {
        return null;
    }
}
