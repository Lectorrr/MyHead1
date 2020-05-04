package com.example.myhead.one.common.entity;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class TablePage<E> {

    private int code = 0;
    private String msg = "";
    private long total;
    private List<E> rows;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<E> getRows() {
        return rows;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }

    public TablePage getDataForPaging(PageInfo pageInfo)
    {
        TablePage tp=new TablePage();
        tp.setCode(0);
        tp.setMsg("");
        tp.setTotal(pageInfo.getTotal());
        tp.setRows(pageInfo.getList());
        return tp;
    }
}
