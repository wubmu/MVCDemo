package com.wwwyb.web.Beans;

import com.wwwyb.domain.Customer;

import java.util.List;

/**
 * Created by 吴亚斌 on 2017/2/19.
 */
public class Page {
    //DAO可以查处来
    private List recods;//存放分页记录
    //界面传过来
    private int currentPageNum;//当前页码
    //DAO可以查出来
    private int totalRecords;//总记录条数
    private int pageSize=10;//每页现实的条数
    //算出来
    private int totalPage;//总页数
    //算出来，根据当前页码
    private int startIndex;//每页开始的记录的索引
    public Page(int currentPageNum,int totalRecords){
        this.currentPageNum=currentPageNum;
        this.totalRecords=totalRecords;
        totalPage=totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;
        //开始记录的索引
        startIndex=(currentPageNum-1)*pageSize;
    }

    public List getRecods() {
        return recods;
    }

    public void setRecods(List recods) {
        this.recods = recods;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
