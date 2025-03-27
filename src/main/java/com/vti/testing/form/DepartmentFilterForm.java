package com.vti.testing.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DepartmentFilterForm {
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date minDate;

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }
}
