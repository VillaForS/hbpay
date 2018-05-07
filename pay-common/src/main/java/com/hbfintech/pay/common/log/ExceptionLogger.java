/**
 *
 */
package com.hbfintech.pay.common.log;

import org.apache.log4j.Logger;

import com.hbfintech.pay.common.util.DateUtil;


/**
 * 针对系统异常与重点业务异常
 *
 * @author jun.wang
 */
public class ExceptionLogger {

    private static Logger logger = Logger.getLogger(ExceptionLogger.class);


    public static void error(String exceptionNo, String exceptionDesc, Throwable t) {
        // 刷新参数
        LogPropsReload.refreshLogProperties();
        if (LogPropsReload.isExceptionEnabled) {
            StringBuilder info = new StringBuilder();
            info.append("<exception>");
            info.append(exceptionNo);
            info.append("|");
            info.append(exceptionDesc);
            info.append("|");
            info.append(DateUtil.getCurrentTime());
            info.append("</exception>");
            logger.error(info.toString(), t);
        }
    }

    /**
     * @Title: error @Description: (记录其他异常信息) @param @param logger @param @param t 设定文件 @return void 返回类型 @throws
     */
    public static void error(Throwable t) {
        ExceptionLogger.error("", "", t);
    }

    /**
     * @param exceptionNo
     * @param exceptionDesc
     */
    public static void error(String exceptionNo, String exceptionDesc) {
        // 刷新参数
        LogPropsReload.refreshLogProperties();
        if (LogPropsReload.isExceptionEnabled) {
            StringBuilder info = new StringBuilder();
            info.append("<exception>");
            info.append(exceptionNo);
            info.append("|");
            info.append(exceptionDesc);
            info.append("|");
            info.append(DateUtil.getCurrentTime());
            info.append("</exception>");
            logger.error(info.toString());
        }
    }

}
