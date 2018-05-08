package com.hbfintech.pay.common.security;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class DigestUtil {

	public static String base64Encode(String data){  
        
        return Base64.encodeBase64String(data.getBytes());  
    }  
      
    public static byte[] base64Decode(String data){  
          
        return Base64.decodeBase64(data.getBytes());  
    }  
      
    public static String md5(String data) {  
          
        return DigestUtils.md5Hex(data);  
    }  
      
    public static String sha1Hex(String data) {  
          
        return DigestUtils.sha1Hex(data);  
    }  
      
    public static String sha256Hex(String data) {  
          
        return DigestUtils.sha256Hex(data);  
    }  
}
