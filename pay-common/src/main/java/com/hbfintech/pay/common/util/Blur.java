package com.hbfintech.pay.common.util;

public class Blur {

	 /**
     * 
     * 隐藏字符串中的一些信息 如卡号，身份证之类的 <功能详细描述>
     * @param info
     * @param first 从0开始
     * @param last
     * @return
     */
    public static String hideMsg(String info, int first, int last)
    {
        if (info == null || info.length() == 0 || first < 0 || last < 0
                || last < first || last > info.length() - 1)
        {
            return info;
        }

        StringBuffer sb = new StringBuffer(info.substring(0, first));

        for (int i = first; i <= last; i++)
        {
            sb.append("*");
        }

        int less = info.length() - sb.length();

        if (less > 0)
        {
            sb.append(info.substring(info.length() - less));
        }

        return sb.toString();
    }
}
