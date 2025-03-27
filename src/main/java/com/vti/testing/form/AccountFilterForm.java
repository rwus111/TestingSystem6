package com.vti.testing.form;

public class AccountFilterForm {
    private String search;
    private Integer minId;
    private Integer maxId;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getMinId() {
        return minId;
    }

    public void setMinId(Integer minId) {
        this.minId = minId;
    }

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }
}
