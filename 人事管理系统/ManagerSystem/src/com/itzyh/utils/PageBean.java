package com.itzyh.utils;

import java.util.List;

/**
 * 分页所需的工具类
 * @param <T>
 */
public class PageBean<T> {

    private List<T> pageData; // 查询到的分页结果集
    private int totalCount = 0;    // 数据总数
    private int currentPage = 0;   // 当前页
    private int pageSize = 5;      // 每页记录数
    private int totalPage = 0;     // 总页数
    private int startNum = 0;      // 起始页

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        totalPage = totalCount / pageSize;
        if (totalCount == 0 || totalCount % pageSize !=0)
            totalPage++;
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartNum() {

        return (this.currentPage - 1)*this.pageSize;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }
}
