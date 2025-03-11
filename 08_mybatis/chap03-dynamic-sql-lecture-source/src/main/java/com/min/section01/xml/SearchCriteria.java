package com.min.section01.xml;

public class SearchCriteria {
    private String condition;       // 검색 조건
    private String value;           // 검색어

    public SearchCriteria() {
    }

    public SearchCriteria(String confition, String value) {
        this.condition = confition;
        this.value = value;
    }

    public String getConfition() {
        return condition;
    }

    public void setConfition(String confition) {
        this.condition = confition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "confition='" + condition + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
