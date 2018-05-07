/**
 *
 */
package com.hbfintech.pay.common.log;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;


/**
 * 业务日志
 */
public class BusinessLogger {

    private static Logger logger = Logger.getLogger(BusinessLogger.class);


    /**
     * 业务日志打印
     * @param method - 方法名，格式：class -> method,例如：BusinessLogger -> info
     * @param msg - 日志内容，例如：获取会员数据
     * @param params - 调用参数，Dto及Entity可直接使用toString，否则使用name：value|name:value格式
     */
    public static void info(String method, String msg, String params) {
        // 刷新参数
        LogPropsReload.refreshLogProperties();
        // 首先判断是否允许这个级别的日志记录
        if (LogPropsReload.isBusinessEnable) {
            StringBuilder info = new StringBuilder();
            info.append("<business>");
            info.append(method);
            info.append(" Info :");
            info.append(msg);
            if (!StringUtils.isEmpty(params))
                info.append("|请求参数：");
            info.append(params);
            info.append("</business>");
            logger.info(info.toString());
        }
    }


}
