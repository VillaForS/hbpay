package com.hbfintech.pay.trade.repository.entity;

import java.io.Serializable;
import java.util.Date;

public class PayBankProduct implements Serializable {
    private Long bankProdId;

    /**
     * 银行编号
     *
     * @mbg.generated
     */
    private String bankCode;

    /**
     * 银行名称
     *
     * @mbg.generated
     */
    private String bankName;

    /**
     * 产品编号
     *
     * @mbg.generated
     */
    private String prodCode;

    /**
     * 开通状态：0：关闭 1：正常
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 删除状态：0：有效 1：失效
     *
     * @mbg.generated
     */
    private Boolean valid;

    /**
     * 操作人
     *
     * @mbg.generated
     */
    private Long operId;

    /**
     * 操作人名称
     *
     * @mbg.generated
     */
    private String operName;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbg.generated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getBankProdId() {
        return bankProdId;
    }

    public void setBankProdId(Long bankProdId) {
        this.bankProdId = bankProdId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode == null ? null : prodCode.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bankProdId=").append(bankProdId);
        sb.append(", bankCode=").append(bankCode);
        sb.append(", bankName=").append(bankName);
        sb.append(", prodCode=").append(prodCode);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", valid=").append(valid);
        sb.append(", operId=").append(operId);
        sb.append(", operName=").append(operName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PayBankProduct other = (PayBankProduct) that;
        return (this.getBankProdId() == null ? other.getBankProdId() == null : this.getBankProdId().equals(other.getBankProdId()))
            && (this.getBankCode() == null ? other.getBankCode() == null : this.getBankCode().equals(other.getBankCode()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getProdCode() == null ? other.getProdCode() == null : this.getProdCode().equals(other.getProdCode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getValid() == null ? other.getValid() == null : this.getValid().equals(other.getValid()))
            && (this.getOperId() == null ? other.getOperId() == null : this.getOperId().equals(other.getOperId()))
            && (this.getOperName() == null ? other.getOperName() == null : this.getOperName().equals(other.getOperName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBankProdId() == null) ? 0 : getBankProdId().hashCode());
        result = prime * result + ((getBankCode() == null) ? 0 : getBankCode().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getProdCode() == null) ? 0 : getProdCode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getValid() == null) ? 0 : getValid().hashCode());
        result = prime * result + ((getOperId() == null) ? 0 : getOperId().hashCode());
        result = prime * result + ((getOperName() == null) ? 0 : getOperName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}