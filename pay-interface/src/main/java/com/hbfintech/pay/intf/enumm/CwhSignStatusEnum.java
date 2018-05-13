package com.hbfintech.pay.intf.enumm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.collections.MapUtils;

public enum CwhSignStatusEnum {
	CREATED(new Byte("0"), "已创建"),
	WAIT_CONFIRM(new Byte("10"),"待用户确认"),
	PROCESSING(new Byte("20"),"签约处理中"),
	SUCCESS(new Byte("30"),"签约成功"),
	FAIL(new Byte("40"),"签约失败");
	
	    CwhSignStatusEnum(Byte code, String desc) {
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
	    private static final ConcurrentMap<Byte, CwhSignStatusEnum> enumMap = new ConcurrentHashMap<Byte, CwhSignStatusEnum>();

	    public static CwhSignStatusEnum getEnum(Byte code) {
	        if (MapUtils.isEmpty(enumMap)) {
	            //初始化ma
	            for (CwhSignStatusEnum e : CwhSignStatusEnum.values()) {
	                enumMap.putIfAbsent(e.getCode(), e);
	            }
	        }
	        CwhSignStatusEnum e = enumMap.get(code);
	        return e;
	    }
}
