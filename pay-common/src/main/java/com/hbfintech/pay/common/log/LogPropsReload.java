/**
 * 
 */
package com.hbfintech.pay.common.log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;


/**
 * 
 * @ClassName:  LogPropsReload   
 * @Description:日志自动reload
 * @author: zhushuang
 * @date:   2018年5月7日 下午11:31:59   
 *     
 * @Copyright: 2018 www.hbfintech.com Inc. All rights reserved. 
 * 注意：本内容仅限于江苏华博金服控股有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class LogPropsReload {
	
	private static final Logger logger = LoggerFactory.getLogger(LogPropsReload.class);
	 
	private static ResourceLoader resourceLoader = new DefaultResourceLoader();
	
	private static final String LOG4J_HIDEPARAMS = "log4j.hideParams";
	private static final String LOG4J_RELOAD_INTERVAL = "log4j.reload.interval";
	private static final String LOG4J_DEBUGLOGGER_ISOPEN = "log4j.DebugLogger.isopen";
	private static final String LOG4J_ACCESSLOGGER_ISOPEN = "log4j.AccessLogger.isopen";
	private static final String LOG4J_OUTINTERFACELOGGER_ISOPEN = "log4j.OutInterfaceLogger.isopen";
	private static final String LOG4J_EXCEPTIONLOGGER_ISOPEN = "log4j.ExceptionLogger.isopen";
	private static final String LOG4J_SYSTEMLOGGER_ISOPEN = "log4j.SystemLogger.isopen";
	// 刷新间隔
	private static long interval = -1l;
	// 出入参隐藏
	public static boolean hideParams = false;
	/**
	 * 上次修改时间
	 */
	public static Date lastUpdateDate = new Date();
	
	//调试日志开关
	public static boolean isDebugEnabled = true;
	//访问日志开关
	public static boolean isAccessEnabled = true;
	//外部访问日志开关
	public static boolean isInterfaceEnabled = true;
	//异常日志开关
	public static boolean isExceptionEnabled = true;
	//系统日志开关
	public static boolean isSystemEnabled = true;
	//服务层日志开关
	public static boolean isServiceEnabled = true;
	// 业务日志开关
	public static boolean isBusinessEnable = true;

/**
 * 
 * @Title: refreshLogProperties   
 * @Description: TODO(这里用一句话描述这个方法的作用)   
 * @param:       
 * @return: void      
 * @throws
 */
	public static void refreshLogProperties() {
		
		Properties  prop = getProperty();
		try {
			// 间隔时间
			if (new Date().getTime() - lastUpdateDate.getTime() > interval) {
				// 重新加载时间间隔
				interval = Long.valueOf(prop.getProperty(LOG4J_RELOAD_INTERVAL, "3600000"));
				// 参数
				hideParams = Boolean.parseBoolean(prop.getProperty(LOG4J_HIDEPARAMS,"false"));
				// 调试日志开关
				try {
					isDebugEnabled = Boolean.parseBoolean(prop.getProperty(LOG4J_DEBUGLOGGER_ISOPEN,"false"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 访问日志开关
				try {
					isAccessEnabled = Boolean.parseBoolean(prop.getProperty(LOG4J_ACCESSLOGGER_ISOPEN,"false"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 接口日志
				try {
					isInterfaceEnabled = Boolean.parseBoolean(prop.getProperty(LOG4J_OUTINTERFACELOGGER_ISOPEN,"false"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 异常日志
				try {
					isExceptionEnabled = Boolean.parseBoolean(prop.getProperty(LOG4J_EXCEPTIONLOGGER_ISOPEN,"false"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 系统日志
				try {
					isSystemEnabled = Boolean.parseBoolean(prop.getProperty(LOG4J_SYSTEMLOGGER_ISOPEN,"false"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 更新时间
				lastUpdateDate = new Date();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public  static Properties getProperty() {
    	Properties  prop = new Properties();
        InputStream propStream = null;
        try {
        	
        	Resource resource = resourceLoader.getResource("log4j.properties");
        	propStream = resource.getInputStream();
        	
            if (propStream != null) {
                prop.load(propStream);
            }
        } catch (IOException e) {
        	logger.error("log swith prop load exception", e);
        } finally {
            try {
                propStream.close();
            } catch (Exception e) {
            	logger.error("log swith prop load exception",e);
            }
        }
        return prop;
    }
	
}
