package com.hbfintech.pay.common.constant;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName:  PayConstant   
 * @Description:支付常量类
 * @author: zhushuang
 * @date:   2018年4月30日 下午10:07:35   
 *     
 * @Copyright: 2018 www.hbfintech.com Inc. All rights reserved. 
 * 注意：本内容仅限于江苏华博金服控股有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class PayConstant {

	//支付渠道
	public final static String PAY_CHANNEL_BF= "CH_PP_BF"; 				// 宝付协议支付

	
    //支付状态
	public final static byte PAY_STATUS_INIT = 0; 		// 初始态
	public final static byte PAY_STATUS_PAYING = 1; 	// 支付中
	public final static byte PAY_STATUS_SUCCESS = 2; 	// 支付成功
	public final static byte PAY_STATUS_FAILED = 3; 	// 支付失败

	
	//返回参数定义
	public static final String RETURN_PARAM_RETCODE = "retCode";
	public static final String RETURN_PARAM_RETMSG = "retMsg";
	public static final String RESULT_PARAM_RESCODE = "resCode";
	public static final String RESULT_PARAM_ERRCODE = "errCode";
	public static final String RESULT_PARAM_ERRCODEDES = "errCodeDes";
	public static final String RESULT_PARAM_SIGN = "sign";

	public static final String RETURN_VALUE_SUCCESS = "SUCCESS";
	public static final String RETURN_VALUE_FAIL = "FAIL";

}
