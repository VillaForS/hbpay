package com.hbfintech.redis.sequence.utils;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbfintech.redis.jedis.utils.RedisCacheUtil;
import com.hbfintech.redis.sequence.SeqEnum;

import org.apache.commons.lang3.StringUtils;

public class SequenceNoService {

    private static final String dateFormat = "yyMMdd";
    private static final long atomicLongMax = 99999L;
    public static final int atomicLongLength = String.valueOf(atomicLongMax).length();
    private static final String SEQUENCE_KEY_PREFIX = "SEQUENCE:";
    // 24小时
    private static final int time_expire = 24 * 60 * 60;
    
    @Autowired
    private RedisCacheUtil redisCacheUtil;

	/**
     * @Title: getSequenceNo
     * @Description: 生成全局唯一的序号（顺序）
     * @return: String
     */
    public String getSequenceNo(String tableName) {
        SeqEnum seqEnum = SeqEnum.getEnum(tableName);
        StringBuffer idStr = new StringBuffer(50);
        if (StringUtils.isNotBlank(seqEnum.getPrefix())) {
            idStr.append(seqEnum.getPrefix());
        }

        // 当前map存储的值累加1
        String key = redisCacheUtil.key(SEQUENCE_KEY_PREFIX, tableName);
        long newActomicValue = redisCacheUtil.incr(key, time_expire);
        if (newActomicValue > atomicLongMax) {
            //如果超出设置的最大值 则重新开始计数
        	redisCacheUtil.del(key);
        	newActomicValue = redisCacheUtil.incr(key, time_expire);
        }

        idStr.append(DateFormatUtils.format(new Date(), dateFormat))
                .append(DateFormatUtils.format(new Date(), "HHmmss"))
                .append(formatString(newActomicValue, String.valueOf(atomicLongMax).length()));
        return idStr.toString();
    }

    /**
     * 将value 转成 formatLength 定长字符串
     *
     * @param value
     * @param formatLength
     * @return
     */
    public String formatString(Long value, Integer formatLength) {
        String newString = String.format("%0" + formatLength + "d", value);
        return newString;
    }
    
}
