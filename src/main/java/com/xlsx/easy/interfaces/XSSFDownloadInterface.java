package com.xlsx.easy.interfaces;

import javax.servlet.http.HttpServletResponse;

/**
 * DownloadInterface
 *
 * @Author Alex_Bao
 * @create 2017-11-24
 * create by IntelliJ IDEA
 */
public interface XSSFDownloadInterface {
    /** download template **/
    void downloadTemplate(HttpServletResponse response);
}
