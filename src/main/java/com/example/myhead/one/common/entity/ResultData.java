package com.example.myhead.one.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * H ui.admin 前端框架需要的后端数据格式
 * @param <T>
 */
public class ResultData<T> {

    private Integer draw = 0;
    private long recordsTotal = 0;
    private long recordsFiltered = 0;
    private List<T> data = new ArrayList<>();

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
