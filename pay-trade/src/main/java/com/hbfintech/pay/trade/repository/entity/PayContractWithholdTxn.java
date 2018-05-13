package com.hbfintech.pay.trade.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PayContractWithholdTxn implements Serializable {
    /**
     *   
     *
     * @mbg.generated
     */
    private Long withholdTxnId;

    /**
     * 支付中心扣款流水号
     *
     * @mbg.generated
     */
    private String withholdTxnNo;

    /**
     * 商户编码
     *
     * @mbg.generated
     */
    private String mchCode;

    /**
     * 商户流水号
     *
     * @mbg.generated
     */
    private String mchReqNo;

    /**
     * 商户请求时间
     *
     * @mbg.generated
     */
    private Date mchReqTime;

    /**
     * 交易金额
     *
     * @mbg.generated
     */
    private BigDecimal amount;

    /**
     * 卡号
     *
     * @mbg.generated
     */
    private String cardNo;

    /**
     * 扩展参数（风控参数、辅助路由参数等）：json 字符串
     *
     * @mbg.generated
     */
    private String extraParams;

    /**
     * 协议号
     *
     * @mbg.generated
     */
    private String protocolNo;

    /**
     * 支付中心标准返回码
     *
     * @mbg.generated
     */
    private String respCode;

    /**
     * 支付中心标准返回描述
     *
     * @mbg.generated
     */
    private String respMsg;

    /**
     * 渠道编号
     *
     * @mbg.generated
     */
    private String channelCode;

    /**
     * 渠道请求流水号
     *
     * @mbg.generated
     */
    private String channelReqNo;

    /**
     * 渠道支付错误码
     *
     * @mbg.generated
     */
    private String channelRespCode;

    /**
     * 渠道支付错误描述
     *
     * @mbg.generated
     */
    private String channelRespMsg;

    /**
     * 渠道支付完成时间（支付渠道返回）
     *
     * @mbg.generated
     */
    private Date channelSuccTime;

    /**
     * 渠道支付凭证（支付渠道返回）
     *
     * @mbg.generated
     */
    private String channelTxnReceipt;

    /**
     * 商户通知地址
     *
     * @mbg.generated
     */
    private String notifyUrl;

    /**
     * 通知次数
     *
     * @mbg.generated
     */
    private Integer notifyCount;

    /**
     * 上次通知时间
     *
     * @mbg.generated
     */
    private Date notifyLastTime;

    /**
     * 支付状态,0-已创建,1-支付中,2-支付成功,3-支付失败
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
     * 对账标识， 0-未对账  1-已对账
     *
     * @mbg.generated
     */
    private Boolean reconStatus;

    /**
     * 对账批次
     *
     * @mbg.generated
     */
    private String reconBatch;

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
     * 操作人id
     *
     * @mbg.generated
     */
    private Long operId;

    /**
     * 操作描述
     *
     * @mbg.generated
     */
    private String operRemark;

    /**
     * 操作时间
     *
     * @mbg.generated
     */
    private Date operTime;

    private static final long serialVersionUID = 1L;

    public Long getWithholdTxnId() {
        return withholdTxnId;
    }

    public void setWithholdTxnId(Long withholdTxnId) {
        this.withholdTxnId = withholdTxnId;
    }

    public String getWithholdTxnNo() {
        return withholdTxnNo;
    }

    public void setWithholdTxnNo(String withholdTxnNo) {
        this.withholdTxnNo = withholdTxnNo == null ? null : withholdTxnNo.trim();
    }

    public String getMchCode() {
        return mchCode;
    }

    public void setMchCode(String mchCode) {
        this.mchCode = mchCode == null ? null : mchCode.trim();
    }

    public String getMchReqNo() {
        return mchReqNo;
    }

    public void setMchReqNo(String mchReqNo) {
        this.mchReqNo = mchReqNo == null ? null : mchReqNo.trim();
    }

    public Date getMchReqTime() {
        return mchReqTime;
    }

    public void setMchReqTime(Date mchReqTime) {
        this.mchReqTime = mchReqTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(String extraParams) {
        this.extraParams = extraParams == null ? null : extraParams.trim();
    }

    public String getProtocolNo() {
        return protocolNo;
    }

    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode == null ? null : respCode.trim();
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg == null ? null : respMsg.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getChannelReqNo() {
        return channelReqNo;
    }

    public void setChannelReqNo(String channelReqNo) {
        this.channelReqNo = channelReqNo == null ? null : channelReqNo.trim();
    }

    public String getChannelRespCode() {
        return channelRespCode;
    }

    public void setChannelRespCode(String channelRespCode) {
        this.channelRespCode = channelRespCode == null ? null : channelRespCode.trim();
    }

    public String getChannelRespMsg() {
        return channelRespMsg;
    }

    public void setChannelRespMsg(String channelRespMsg) {
        this.channelRespMsg = channelRespMsg == null ? null : channelRespMsg.trim();
    }

    public Date getChannelSuccTime() {
        return channelSuccTime;
    }

    public void setChannelSuccTime(Date channelSuccTime) {
        this.channelSuccTime = channelSuccTime;
    }

    public String getChannelTxnReceipt() {
        return channelTxnReceipt;
    }

    public void setChannelTxnReceipt(String channelTxnReceipt) {
        this.channelTxnReceipt = channelTxnReceipt == null ? null : channelTxnReceipt.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public Integer getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(Integer notifyCount) {
        this.notifyCount = notifyCount;
    }

    public Date getNotifyLastTime() {
        return notifyLastTime;
    }

    public void setNotifyLastTime(Date notifyLastTime) {
        this.notifyLastTime = notifyLastTime;
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

    public Boolean getReconStatus() {
        return reconStatus;
    }

    public void setReconStatus(Boolean reconStatus) {
        this.reconStatus = reconStatus;
    }

    public String getReconBatch() {
        return reconBatch;
    }

    public void setReconBatch(String reconBatch) {
        this.reconBatch = reconBatch == null ? null : reconBatch.trim();
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

    public String getOperRemark() {
        return operRemark;
    }

    public void setOperRemark(String operRemark) {
        this.operRemark = operRemark == null ? null : operRemark.trim();
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", withholdTxnId=").append(withholdTxnId);
        sb.append(", withholdTxnNo=").append(withholdTxnNo);
        sb.append(", mchCode=").append(mchCode);
        sb.append(", mchReqNo=").append(mchReqNo);
        sb.append(", mchReqTime=").append(mchReqTime);
        sb.append(", amount=").append(amount);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", extraParams=").append(extraParams);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", respCode=").append(respCode);
        sb.append(", respMsg=").append(respMsg);
        sb.append(", channelCode=").append(channelCode);
        sb.append(", channelReqNo=").append(channelReqNo);
        sb.append(", channelRespCode=").append(channelRespCode);
        sb.append(", channelRespMsg=").append(channelRespMsg);
        sb.append(", channelSuccTime=").append(channelSuccTime);
        sb.append(", channelTxnReceipt=").append(channelTxnReceipt);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", notifyCount=").append(notifyCount);
        sb.append(", notifyLastTime=").append(notifyLastTime);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", reconStatus=").append(reconStatus);
        sb.append(", reconBatch=").append(reconBatch);
        sb.append(", valid=").append(valid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", operId=").append(operId);
        sb.append(", operRemark=").append(operRemark);
        sb.append(", operTime=").append(operTime);
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
        PayContractWithholdTxn other = (PayContractWithholdTxn) that;
        return (this.getWithholdTxnId() == null ? other.getWithholdTxnId() == null : this.getWithholdTxnId().equals(other.getWithholdTxnId()))
            && (this.getWithholdTxnNo() == null ? other.getWithholdTxnNo() == null : this.getWithholdTxnNo().equals(other.getWithholdTxnNo()))
            && (this.getMchCode() == null ? other.getMchCode() == null : this.getMchCode().equals(other.getMchCode()))
            && (this.getMchReqNo() == null ? other.getMchReqNo() == null : this.getMchReqNo().equals(other.getMchReqNo()))
            && (this.getMchReqTime() == null ? other.getMchReqTime() == null : this.getMchReqTime().equals(other.getMchReqTime()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getExtraParams() == null ? other.getExtraParams() == null : this.getExtraParams().equals(other.getExtraParams()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getRespCode() == null ? other.getRespCode() == null : this.getRespCode().equals(other.getRespCode()))
            && (this.getRespMsg() == null ? other.getRespMsg() == null : this.getRespMsg().equals(other.getRespMsg()))
            && (this.getChannelCode() == null ? other.getChannelCode() == null : this.getChannelCode().equals(other.getChannelCode()))
            && (this.getChannelReqNo() == null ? other.getChannelReqNo() == null : this.getChannelReqNo().equals(other.getChannelReqNo()))
            && (this.getChannelRespCode() == null ? other.getChannelRespCode() == null : this.getChannelRespCode().equals(other.getChannelRespCode()))
            && (this.getChannelRespMsg() == null ? other.getChannelRespMsg() == null : this.getChannelRespMsg().equals(other.getChannelRespMsg()))
            && (this.getChannelSuccTime() == null ? other.getChannelSuccTime() == null : this.getChannelSuccTime().equals(other.getChannelSuccTime()))
            && (this.getChannelTxnReceipt() == null ? other.getChannelTxnReceipt() == null : this.getChannelTxnReceipt().equals(other.getChannelTxnReceipt()))
            && (this.getNotifyUrl() == null ? other.getNotifyUrl() == null : this.getNotifyUrl().equals(other.getNotifyUrl()))
            && (this.getNotifyCount() == null ? other.getNotifyCount() == null : this.getNotifyCount().equals(other.getNotifyCount()))
            && (this.getNotifyLastTime() == null ? other.getNotifyLastTime() == null : this.getNotifyLastTime().equals(other.getNotifyLastTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getReconStatus() == null ? other.getReconStatus() == null : this.getReconStatus().equals(other.getReconStatus()))
            && (this.getReconBatch() == null ? other.getReconBatch() == null : this.getReconBatch().equals(other.getReconBatch()))
            && (this.getValid() == null ? other.getValid() == null : this.getValid().equals(other.getValid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOperId() == null ? other.getOperId() == null : this.getOperId().equals(other.getOperId()))
            && (this.getOperRemark() == null ? other.getOperRemark() == null : this.getOperRemark().equals(other.getOperRemark()))
            && (this.getOperTime() == null ? other.getOperTime() == null : this.getOperTime().equals(other.getOperTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWithholdTxnId() == null) ? 0 : getWithholdTxnId().hashCode());
        result = prime * result + ((getWithholdTxnNo() == null) ? 0 : getWithholdTxnNo().hashCode());
        result = prime * result + ((getMchCode() == null) ? 0 : getMchCode().hashCode());
        result = prime * result + ((getMchReqNo() == null) ? 0 : getMchReqNo().hashCode());
        result = prime * result + ((getMchReqTime() == null) ? 0 : getMchReqTime().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getExtraParams() == null) ? 0 : getExtraParams().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getRespCode() == null) ? 0 : getRespCode().hashCode());
        result = prime * result + ((getRespMsg() == null) ? 0 : getRespMsg().hashCode());
        result = prime * result + ((getChannelCode() == null) ? 0 : getChannelCode().hashCode());
        result = prime * result + ((getChannelReqNo() == null) ? 0 : getChannelReqNo().hashCode());
        result = prime * result + ((getChannelRespCode() == null) ? 0 : getChannelRespCode().hashCode());
        result = prime * result + ((getChannelRespMsg() == null) ? 0 : getChannelRespMsg().hashCode());
        result = prime * result + ((getChannelSuccTime() == null) ? 0 : getChannelSuccTime().hashCode());
        result = prime * result + ((getChannelTxnReceipt() == null) ? 0 : getChannelTxnReceipt().hashCode());
        result = prime * result + ((getNotifyUrl() == null) ? 0 : getNotifyUrl().hashCode());
        result = prime * result + ((getNotifyCount() == null) ? 0 : getNotifyCount().hashCode());
        result = prime * result + ((getNotifyLastTime() == null) ? 0 : getNotifyLastTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getReconStatus() == null) ? 0 : getReconStatus().hashCode());
        result = prime * result + ((getReconBatch() == null) ? 0 : getReconBatch().hashCode());
        result = prime * result + ((getValid() == null) ? 0 : getValid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOperId() == null) ? 0 : getOperId().hashCode());
        result = prime * result + ((getOperRemark() == null) ? 0 : getOperRemark().hashCode());
        result = prime * result + ((getOperTime() == null) ? 0 : getOperTime().hashCode());
        return result;
    }
}