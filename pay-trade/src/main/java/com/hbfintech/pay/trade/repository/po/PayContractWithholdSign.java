package com.hbfintech.pay.trade.repository.po;

import java.io.Serializable;
import java.util.Date;

public class PayContractWithholdSign implements Serializable {
    private Long withholdSignId;

    /**
     * 扣款流水号
     *
     * @mbg.generated
     */
    private String withholdSignNo;

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
     * 卡号
     *
     * @mbg.generated
     */
    private String cardNo;

    /**
     * 卡类型
D:  借记卡
C：贷记卡
     *
     * @mbg.generated
     */
    private String cardType;

    /**
     * 预留手机号
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     * 持卡人姓名
     *
     * @mbg.generated
     */
    private String certName;

    /**
     * 持卡人证件编号
     *
     * @mbg.generated
     */
    private String certNo;

    /**
     * 持卡人证件类型  1-身份证
     *
     * @mbg.generated
     */
    private Byte certType;

    /**
     * 认证token
     *
     * @mbg.generated
     */
    private String authToken;

    /**
     * 签约协议号
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
     * 渠道流水号
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
     * 渠道支付完成时间（支付公司返回）
     *
     * @mbg.generated
     */
    private Date channelSuccTime;

    /**
     * 支付状态,0-订单生成,1-待确认,2-签约成功,3-签约失败
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

    public Long getWithholdSignId() {
        return withholdSignId;
    }

    public void setWithholdSignId(Long withholdSignId) {
        this.withholdSignId = withholdSignId;
    }

    public String getWithholdSignNo() {
        return withholdSignNo;
    }

    public void setWithholdSignNo(String withholdSignNo) {
        this.withholdSignNo = withholdSignNo == null ? null : withholdSignNo.trim();
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName == null ? null : certName.trim();
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    public Byte getCertType() {
        return certType;
    }

    public void setCertType(Byte certType) {
        this.certType = certType;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken == null ? null : authToken.trim();
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
        sb.append(", withholdSignId=").append(withholdSignId);
        sb.append(", withholdSignNo=").append(withholdSignNo);
        sb.append(", mchCode=").append(mchCode);
        sb.append(", mchReqNo=").append(mchReqNo);
        sb.append(", mchReqTime=").append(mchReqTime);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", cardType=").append(cardType);
        sb.append(", mobile=").append(mobile);
        sb.append(", certName=").append(certName);
        sb.append(", certNo=").append(certNo);
        sb.append(", certType=").append(certType);
        sb.append(", authToken=").append(authToken);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", respCode=").append(respCode);
        sb.append(", respMsg=").append(respMsg);
        sb.append(", channelCode=").append(channelCode);
        sb.append(", channelReqNo=").append(channelReqNo);
        sb.append(", channelRespCode=").append(channelRespCode);
        sb.append(", channelRespMsg=").append(channelRespMsg);
        sb.append(", channelSuccTime=").append(channelSuccTime);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
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
        PayContractWithholdSign other = (PayContractWithholdSign) that;
        return (this.getWithholdSignId() == null ? other.getWithholdSignId() == null : this.getWithholdSignId().equals(other.getWithholdSignId()))
            && (this.getWithholdSignNo() == null ? other.getWithholdSignNo() == null : this.getWithholdSignNo().equals(other.getWithholdSignNo()))
            && (this.getMchCode() == null ? other.getMchCode() == null : this.getMchCode().equals(other.getMchCode()))
            && (this.getMchReqNo() == null ? other.getMchReqNo() == null : this.getMchReqNo().equals(other.getMchReqNo()))
            && (this.getMchReqTime() == null ? other.getMchReqTime() == null : this.getMchReqTime().equals(other.getMchReqTime()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getCertName() == null ? other.getCertName() == null : this.getCertName().equals(other.getCertName()))
            && (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
            && (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
            && (this.getAuthToken() == null ? other.getAuthToken() == null : this.getAuthToken().equals(other.getAuthToken()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getRespCode() == null ? other.getRespCode() == null : this.getRespCode().equals(other.getRespCode()))
            && (this.getRespMsg() == null ? other.getRespMsg() == null : this.getRespMsg().equals(other.getRespMsg()))
            && (this.getChannelCode() == null ? other.getChannelCode() == null : this.getChannelCode().equals(other.getChannelCode()))
            && (this.getChannelReqNo() == null ? other.getChannelReqNo() == null : this.getChannelReqNo().equals(other.getChannelReqNo()))
            && (this.getChannelRespCode() == null ? other.getChannelRespCode() == null : this.getChannelRespCode().equals(other.getChannelRespCode()))
            && (this.getChannelRespMsg() == null ? other.getChannelRespMsg() == null : this.getChannelRespMsg().equals(other.getChannelRespMsg()))
            && (this.getChannelSuccTime() == null ? other.getChannelSuccTime() == null : this.getChannelSuccTime().equals(other.getChannelSuccTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getWithholdSignId() == null) ? 0 : getWithholdSignId().hashCode());
        result = prime * result + ((getWithholdSignNo() == null) ? 0 : getWithholdSignNo().hashCode());
        result = prime * result + ((getMchCode() == null) ? 0 : getMchCode().hashCode());
        result = prime * result + ((getMchReqNo() == null) ? 0 : getMchReqNo().hashCode());
        result = prime * result + ((getMchReqTime() == null) ? 0 : getMchReqTime().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getCertName() == null) ? 0 : getCertName().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getAuthToken() == null) ? 0 : getAuthToken().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getRespCode() == null) ? 0 : getRespCode().hashCode());
        result = prime * result + ((getRespMsg() == null) ? 0 : getRespMsg().hashCode());
        result = prime * result + ((getChannelCode() == null) ? 0 : getChannelCode().hashCode());
        result = prime * result + ((getChannelReqNo() == null) ? 0 : getChannelReqNo().hashCode());
        result = prime * result + ((getChannelRespCode() == null) ? 0 : getChannelRespCode().hashCode());
        result = prime * result + ((getChannelRespMsg() == null) ? 0 : getChannelRespMsg().hashCode());
        result = prime * result + ((getChannelSuccTime() == null) ? 0 : getChannelSuccTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getValid() == null) ? 0 : getValid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOperId() == null) ? 0 : getOperId().hashCode());
        result = prime * result + ((getOperRemark() == null) ? 0 : getOperRemark().hashCode());
        result = prime * result + ((getOperTime() == null) ? 0 : getOperTime().hashCode());
        return result;
    }
}