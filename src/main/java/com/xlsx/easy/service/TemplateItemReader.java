package com.xlsx.easy.service;

import com.xlsx.easy.dto.BaseQueryDto;
import com.xlsx.easy.dto.TemplateDataDto;

import java.util.List;

/**
 * TemplateItemReader
 *
 * @Author Alex_Bao
 * @create 2017-11-26
 * create by IntelliJ IDEA
 */
public interface TemplateItemReader<T extends TemplateDataDto,Q extends BaseQueryDto<? extends TemplateDataDto>> {

    /**
     * 查询返回多个对象
     *
     * @param condition
     * @return
     */
    List<T> queryDataList(Q condition);

}
