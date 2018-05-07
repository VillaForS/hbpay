package com.hbfintech.pay.trade.Exception;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hbfintech.pay.common.log.ExceptionLogger;
import com.hbfintech.pay.common.model.BaseJsonModel;

/**
 * 通用的异常处理类，同时支持页面和json、jsonp
 * @author zhushuang
 *
 */
public class BaseHandlerExceptionResolver extends SimpleMappingExceptionResolver {

	
    @Override
	public ModelAndView doResolveException(HttpServletRequest request,     
			HttpServletResponse response, Object handler, Exception ex) {
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;   
		
		if(!isRequestAcceptJsonOrXml(request)){
			return super.doResolveException(request, response, handlerMethod,ex);   
		}
		ResponseBody body = handlerMethod.getMethodAnnotation(ResponseBody.class);   
		// 判断有没有@ResponseBody的注解没有的话调用父方法   
		if (body == null) {     
			return super.doResolveException(request, response, handlerMethod,ex);   
		}    
		ModelAndView mv = new ModelAndView();    
		// 设置状态码,注意这里不能设置成500，设成500JQuery不会出错误提示 并且不会有任何反应    
		response.setStatus(HttpStatus.OK.value());   
		// 设置ContentType   
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);   
		// 避免乱码    
		response.setCharacterEncoding("UTF-8");    
		response.setHeader("Cache-Control", "no-cache, must-revalidate");   
		try {     
			
			ExceptionLogger.error("BaseHandlerExceptionResolver","",ex);     
			PrintWriter writer = response.getWriter(); 
			
			BaseJsonModel model= new BaseJsonModel();
	    	model.setCode(BaseJsonModel.ERROR_CODE);
	    	model.setMsg("系统异常");
	    	
	    	if(StringUtils.isNotEmpty(request.getParameter("callbackparam"))){
			    writer.write(JSON.toJSONString(new JSONPObject("callbackparam",model)));    
	    	}else{
	    		writer.write(JSON.toJSONString(model));
	    	}
			writer.close();    
		} catch (IOException e) {    
			ExceptionLogger.error("BaseHandlerExceptionResolver","write respone error",ex);    
		}    
		return mv;
	}
    
    private boolean isRequestAcceptJsonOrXml(HttpServletRequest request) {
        if (request.getHeader("accept").indexOf("application/json") > -1) {
            return true;
        } else if (request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1) {
            return true;
        } else {
            return false;
        }
    }
	
}
