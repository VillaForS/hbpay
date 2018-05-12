package com.hbfintech.pay.trade.repository.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PayChannelBank implements Serializable {
    private Long channelBankId;

    /**
     * 渠道编码
     *
     * @mbg.generated
     */
    private String channelCode;

    /**
     * 银行编号
     *
     * @mbg.generated
     */
    private String bankCode;

    /**
     * 单笔交易金额上限
     *
     * @mbg.generated
     */
    private BigDecimal perMaxAmount;

    /**
     * 单笔交易金额下限
     *
     * @mbg.generated
     */
    private BigDecimal perMinAmount;

    /**
     * 日交易金额上限
     *
     * @mbg.generated
     */
    private String dayMaxAmount;

    /**
     * 维护开始时间
     *
     * @mbg.generated
     */
    private Date maintainStartTime;

    /**
     * 维护结束时间
     *
     * @mbg.generated
     */
    private Date maintainEndTime;

    /**
     * 渠道银行状态：0：关闭 1：开通
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
     * 版本号
     *
     * @mbg.generated
     */
    private Integer version;

    private static final long serialVersionUID = 1L;

    public Long getChannelBankId() {
        return channelBankId;
    }

    public void setChannelBankId(Long channelBankId) {
        this.channelBankId = channelBankId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public BigDecimal getPerMaxAmount() {
        return perMaxAmount;
    }

    public void setPerMaxAmount(BigDecimal perMaxAmount) {
        this.perMaxAmount = perMaxAmount;
    }

    public BigDecimal getPerMinAmount() {
        return perMinAmount;
    }

    public void setPerMinAmount(BigDecimal perMinAmount) {
        this.perMinAmount = perMinAmount;
    }

    public String getDayMaxAmount() {
        return dayMaxAmount;
    }

    public void setDayMaxAmount(String dayMaxAmount) {
        this.dayMaxAmount = dayMaxAmount == null ? null : dayMaxAmount.trim();
    }

    public Date getMaintainStartTime() {
        return maintainStartTime;
    }

    public void setMaintainStartTime(Date maintainStartTime) {
        this.maintainStartTime = maintainStartTime;
    }

    public Date getMaintainEndTime() {
        return maintainEndTime;
    }

    public void setMaintainEndTime(Date maintainEndTime) {
        this.maintainEndTime = maintainEndTime;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channelBankId=").append(channelBankId);
        sb.append(", channelCode=").append(channelCode);
        sb.append(", bankCode=").append(bankCode);
        sb.append(", perMaxAmount=").append(perMaxAmount);
        sb.append(", perMinAmount=").append(perMinAmount);
        sb.append(", dayMaxAmount=").append(dayMaxAmount);
        sb.append(", maintainStartTime=").append(maintainStartTime);
        sb.append(", maintainEndTime=").append(maintainEndTime);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", valid=").append(valid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", operId=").append(operId);
        sb.append(", operName=").append(operName);
        sb.append(", version=").append(version);
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
        PayChannelBank other = (PayChannelBank) that;
        return (this.getChannelBankId() == null ? other.getChannelBankId() == null : this.getChannelBankId().equals(other.getChannelBankId()))
            && (this.getChannelCode() == null ? other.getChannelCode() == null : this.getChannelCode().equals(other.getChannelCode()))
            && (this.getBankCode() == null ? other.getBankCode() == null : this.getBankCode().equals(other.getBankCode()))
            && (this.getPerMaxAmount() == null ? other.getPerMaxAmount() == null : this.getPerMaxAmount().equals(other.getPerMaxAmount()))
            && (this.getPerMinAmount() == null ? other.getPerMinAmount() == null : this.getPerMinAmount().equals(other.getPerMinAmount()))
            && (this.getDayMaxAmount() == null ? other.getDayMaxAmount() == null : this.getDayMaxAmount().equals(other.getDayMaxAmount()))
            && (this.getMaintainStartTime() == null ? other.getMaintainStartTime() == null : this.getMaintainStartTime().equals(other.getMaintainStartTime()))
            && (this.getMaintainEndTime() == null ? other.getMaintainEndTime() == null : this.getMaintainEndTime().equals(other.getMaintainEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getValid() == null ? other.getValid() == null : this.getValid().equals(other.getValid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOperId() == null ? other.getOperId() == null : this.getOperId().equals(other.getOperId()))
            && (this.getOperName() == null ? other.getOperName() == null : this.getOperName().equals(other.getOperName()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChannelBankId() == null) ? 0 : getChannelBankId().hashCode());
        result = prime * result + ((getChannelCode() == null) ? 0 : getChannelCode().hashCode());
        result = prime * result + ((getBankCode() == null) ? 0 : getBankCode().hashCode());
        result = prime * result + ((getPerMaxAmount() == null) ? 0 : getPerMaxAmount().hashCode());
        result = prime * result + ((getPerMinAmount() == null) ? 0 : getPerMinAmount().hashCode());
        result = prime * result + ((getDayMaxAmount() == null) ? 0 : getDayMaxAmount().hashCode());
        result = prime * result + ((getMaintainStartTime() == null) ? 0 : getMaintainStartTime().hashCode());
        result = prime * result + ((getMaintainEndTime() == null) ? 0 : getMaintainEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getValid() == null) ? 0 : getValid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOperId() == null) ? 0 : getOperId().hashCode());
        result = prime * result + ((getOperName() == null) ? 0 : getOperName().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }
}