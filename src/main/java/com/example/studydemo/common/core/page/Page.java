package com.example.studydemo.common.core.page;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Page<T> extends PageInfo<T> {
    private Integer pageNo;
    private String sort;
    private String order;
    private Integer searchRange;
    @JsonIgnore
    private transient List<Condition> conditions;

    public Page(List<T> list) {
        super(list);
    }

    public int getPageNo() {
        return this.getPageNum();
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        this.setPageNum(pageNo);
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<Condition> getConditions() {
        return this.conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public Integer getSearchRange() {
        return this.searchRange;
    }

    public void setSearchRange(Integer searchRange) {
        this.searchRange = searchRange;
    }

    public boolean includeLowerRanks() {
        return null != this.searchRange && 0 != this.searchRange;
    }

    public String toString() {
        return "Page{pageNo=" + this.pageNo + ", sort='" + this.sort + '\'' + ", order='" + this.order + '\'' + ", conditions=" + this.conditions + "} " + super.toString();
    }

    public void addCondition(Condition condition) {
        if (null != condition) {
            if (null == this.conditions) {
                this.setConditions(new LinkedList());
            }

            this.getConditions().add(condition);
        }
    }

    public void addConditionStr(String conditionStr, Object v) {
        this.addConditionStr(conditionStr, new ArrayList(Arrays.asList(new Object[]{v})));
    }

    public void addConditionStr(String conditionStr, List<Object> values) {
        this.addCondition(Condition.builder().condition(conditionStr).values(values).build());
    }

    public Page() {
    }
}
