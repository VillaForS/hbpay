package com.hbfintech.pay.intf.enumm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.collections.MapUtils;

public enum CwhTxnStatusEnum {
	CREATED(new Byte("0"), "已创建"),
	PROCESSING(new Byte("20"),"签约处理中"),
	SUCCESS(new Byte("30"),"签约成功"),
	FAIL(new Byte("40"),"签约失败");
	
	    CwhTxnStatusEnum(Byte code, String desc) {
	        this.code = code;
	        this.desc = desc;
	    }
	    private Byte code;
	    private String desc;

	    public Byte getCode() {
	        return code;
	    }

	    public String getDesc() {
	        return desc;
	    }

	    //存储格式
	    private static final ConcurrentMap<Byte, CwhTxnStatusEnum> enumMap = new ConcurrentHashMap<Byte, CwhTxnStatusEnum>();

	    public static CwhTxnStatusEnum getEnum(Byte code) {
	        if (MapUtils.isEmpty(enumMap)) {
	            //初始化ma
	            for (CwhTxnStatusEnum e : CwhTxnStatusEnum.values()) {
	                enumMap.putIfAbsent(e.getCode(), e);
	            }
	        }
	        CwhTxnStatusEnum e = enumMap.get(code);
	        return e;
	    }
}
