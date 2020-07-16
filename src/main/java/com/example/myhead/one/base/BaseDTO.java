package com.example.myhead.one.base;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseDTO<ID extends Serializable> implements Serializable {
    private ID id;
    private Date createDate = new Date();
    private Date updateDate = new Date();
    private String bakColumn1;
    private String bakColumn2;
    private String bakColumn3;

    public BaseDTO() {
    }

    public ID getId() {
        return this.id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateDateStr() {
        if (this.createDate != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return simpleDateFormat.format(this.createDate);
        } else {
            return "";
        }
    }

    public String getUpdateDateStr() {
        if (this.updateDate != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return simpleDateFormat.format(this.updateDate);
        } else {
            return "";
        }
    }

    public String getBakColumn1() {
        return this.bakColumn1;
    }

    public void setBakColumn1(String bakColumn1) {
        this.bakColumn1 = bakColumn1;
    }

    public String getBakColumn2() {
        return this.bakColumn2;
    }

    public void setBakColumn2(String bakColumn2) {
        this.bakColumn2 = bakColumn2;
    }

    public String getBakColumn3() {
        return this.bakColumn3;
    }

    public void setBakColumn3(String bakColumn3) {
        this.bakColumn3 = bakColumn3;
    }
}
