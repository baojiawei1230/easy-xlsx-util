package com.xlsx.easy.dto;

import java.io.Serializable;

/**
 * BaseQueryDto
 *
 * @Author Alex_Bao
 * @create 2017-11-26
 * create by IntelliJ IDEA
 */
public class BaseQueryDto<T> implements Serializable,TemplateDataDto {
    /** 查询条件 **/
    private T condition;

    public BaseQueryDto(T condition) {
        super();
        this.condition = condition;
    }

    public BaseQueryDto() {
    }

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

}
