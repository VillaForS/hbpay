package com.hbfintech.pay.trade.repository.entity;

import java.io.Serializable;
import java.util.Date;

public class PayMerchant implements Serializable {
    private Long mchId;

    /**
     * 商户编码
     *
     * @mbg.generated
     */
    private String mchCode;

    /**
     * 商户名称
     *
     * @mbg.generated
     */
    private String mchName;

    /**
     * 商户状态：0：未开通 1：已开通
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
     * 版本号
     *
     * @mbg.generated
     */
    private Integer version;

    private static final long serialVersionUID = 1L;

    public Long getMchId() {
        return mchId;
    }

    public void setMchId(Long mchId) {
        this.mchId = mchId;
    }

    public String getMchCode() {
        return mchCode;
    }

    public void setMchCode(String mchCode) {
        this.mchCode = mchCode == null ? null : mchCode.trim();
    }

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName == null ? null : mchName.trim();
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
        sb.append(", mchId=").append(mchId);
        sb.append(", mchCode=").append(mchCode);
        sb.append(", mchName=").append(mchName);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", valid=").append(valid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        PayMerchant other = (PayMerchant) that;
        return (this.getMchId() == null ? other.getMchId() == null : this.getMchId().equals(other.getMchId()))
            && (this.getMchCode() == null ? other.getMchCode() == null : this.getMchCode().equals(other.getMchCode()))
            && (this.getMchName() == null ? other.getMchName() == null : this.getMchName().equals(other.getMchName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getValid() == null ? other.getValid() == null : this.getValid().equals(other.getValid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMchId() == null) ? 0 : getMchId().hashCode());
        result = prime * result + ((getMchCode() == null) ? 0 : getMchCode().hashCode());
        result = prime * result + ((getMchName() == null) ? 0 : getMchName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getValid() == null) ? 0 : getValid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }
}