package com.hbfintech.pay.intf.dto.trade;


public class PageRequestDto extends RequestDto
{
    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private String orderBy;

    /**
     * @return 页码 1开始
     * @since 1.0
     */
    public Integer getPageNum()
    {
        return pageNum;
    }

    /**
     * @param pageNum 要设置的 pageNum
     * @since 1.0
     */
    public void setPageNum(Integer pageNum)
    {
        this.pageNum = pageNum;
    }

    /**
     * @return 每页大小
     * @since 1.0
     */
    public Integer getPageSize()
    {
        return pageSize;
    }

    /**
     * @param pageSize 要设置的 pageSize
     * @since 1.0
     */
    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    /**
     * @return 需要排序的字段
     * @since 1.0
     */
    public String getOrderBy()
    {
        return orderBy;
    }

    /**
     * @param orderBy 要设置的 orderBy
     * @since 1.0
     */
    public void setOrderBy(String orderBy)
    {
        this.orderBy = orderBy;
    }

}
