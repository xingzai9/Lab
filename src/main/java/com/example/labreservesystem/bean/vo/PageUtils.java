package com.example.labreservesystem.bean.vo;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.persistence.criteria.CriteriaBuilder;

public class PageUtils<T> {
    private Integer startIndex;
    private Integer pageSize;
    private T data;

    public PageUtils(Integer startIndex, Integer pageSize, T data) {
        this.startIndex = startIndex;
        this.pageSize = pageSize;
        this.data = data;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageUtils{" +
                "startIndex=" + startIndex +
                ", pageSize=" + pageSize +
                ", data=" + data +
                '}';
    }
}
