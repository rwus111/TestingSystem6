package com.vti.testing.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DepartmentFilterForm {
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date minDate;
    private Integer minYear;

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Integer getMinYear() {
        return minYear;
    }

    public void setMinYear(Integer minYear) {
        this.minYear = minYear;
    }
}
