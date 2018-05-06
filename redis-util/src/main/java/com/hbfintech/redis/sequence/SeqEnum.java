package com.hbfintech.redis.sequence;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * INFO: 同步ORACLE的sys_seq表记录
 * User: zhaokai
 * Date: 2016/11/3
 * Version: 1.0
 * History: <p>如果有修改过程，请记录</P>
 */

public enum SeqEnum {
    HY_MEMBERREGISTER("HY_MEMBERREGISTER", "YHXXZC", "用户信息注册表编号"),
    JK_APPLY("JK_APPLY", "JKSQ", "借款申请表编号"),
    NOT_FUOUND("", "HBFINTECH", "无匹配");


    /**
     * @param code   code
     * @param prefix 前缀
     * @param desc   code描述
     */
    SeqEnum(String code, String prefix, String desc) {
        this.code = code;
        this.desc = desc;
        this.prefix = prefix;
    }

    private String code;
    private String prefix;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDesc() {
        return desc;
    }

    //存储格式
    private static final ConcurrentMap<String, SeqEnum> enumMap = new ConcurrentHashMap<String, SeqEnum>();

    public static SeqEnum getEnum(String code) {
        if (MapUtils.isEmpty(enumMap)) {
            //初始化ma
            for (SeqEnum e : SeqEnum.values()) {
                enumMap.putIfAbsent(StringUtils.upperCase(e.getCode()), e);
            }
        }
        SeqEnum e = enumMap.get(StringUtils.upperCase(code));
        if (null != e) {
            return e;
        }
        return SeqEnum.NOT_FUOUND;
    }
}
