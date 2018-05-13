package com.hbfintech.pay.trade.dict;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;


public enum SeqEnum {
    PAY_CONTRSCT_WITHHOLD_SIGN("pay_contract_withhold_sign", "CWHSGN", "用户信息注册表编号"),
	DEFAULT("default","PAY","默认");

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
        return SeqEnum.DEFAULT;
    }
}
