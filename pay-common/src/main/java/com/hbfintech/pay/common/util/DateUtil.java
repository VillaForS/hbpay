package com.hbfintech.pay.common.util;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hbfintech.pay.common.constant.Constant;


public class DateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    private DateUtil() {

    }

    /**
     * getDate
     * 
     * @param time
     * @return format[yyyy-MM-dd]
     */
    public static String getDate(Date time) {
        if (time == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(time);
    }

    /**
     * Date 20100322
     * 
     * @param checkString 要验证的邮件地址字符串
     * @return 验证邮件地址是否合法，如果合法则返回true,否则返回false
     */
    public static boolean isEmail(String checkString) {
        String regString = "([a-zA-Z_0-9]+)@([a-zA-Z0-9]+)\\.([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(regString);
        Matcher matcher = pattern.matcher(checkString);
        return matcher.find();
    }

    public static String formatDate(Date time, String pattern) {
        if (time == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(time);
    }

    /**
     * isEffective
     * 
     * @param time
     * @param pattern
     * @return
     */

    public static boolean isInRange(Timestamp startDate, Timestamp endDate) {
        Timestamp current = new Timestamp(System.currentTimeMillis());
        return (startDate == null || !startDate.after(current)) && (endDate == null || !endDate.before(current));
    }

    /**
     * getTime
     * 
     * @param time
     * @return format[yyyy-MM-dd HH:mm:ss]
     */
    public static String getTime(Date time) {
        if (time == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(time);
    }

    /**
     * getTime
     * 
     * @param time
     * @return format[HHmmss]
     */
    public static String getTimeTrim(Date time) {
        if (time == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat("HHmmss");
        return df.format(time);
    }

    /**
     * getTime
     * 
     * @param time
     * @param pattern
     * @return format[yyyy-MM-dd HH:mm:ss]
     */
    public static String getStrTime(Timestamp time, String pattern) {
        if (time == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(time);
    }

    /**
     * parseTime
     * 
     * @param time [yyyy-MM-dd HH:mm:ss]
     * @return Date
     */
    public static Date parseTime(String time) {
        if (time == null || time.length() < 1) {
            return null;
        }
        Date result = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            result = df.parse(time);
        } catch (ParseException e) {
            return null;
        }
        return result;
    }

    /**
     * parseTimeStamp
     * 
     * @param time [yyyy-MM-dd HH:mm:ss]
     * @return Timestamp
     */
    public static Timestamp parseTimeStamp(String time) {

        Date result = parseTime(time);
        if (result != null) {
            return new Timestamp(result.getTime());
        }
        return null;

    }

    /**
     * @return
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 
     * @return
     */
    public static Timestamp getNextDay() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, Constant.NUM_1);
        return new Timestamp(now.getTimeInMillis());
    }

    public static String getCurrentDate() {
        return getDate(new Date());
    }

    public static String getCurrentTime() {
        return getTime(new Date());
    }

    public static Timestamp getCurrentTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getTimeStampString() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    public static Date getDateDiff(Date time, int days) {
        if (time == null) {
            return null;
        }
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(time);
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 0, 0,
                0);
        tempCal.add(Calendar.DAY_OF_MONTH, days);
        return tempCal.getTime();
    }

    /**
     * 
     * 日期加上分钟数
     * 
     * @param time
     * @param minutes
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Date getMinuteDiff(Date time, int minutes) {
        if (time == null) {
            return null;
        }
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(time);
        tempCal.add(Calendar.MINUTE, minutes);
        return tempCal.getTime();
    }

    /**
     * 为商品组取js,css版本号 getDate
     * 
     * @param time
     * @return format[yyyyMMddHH]
     */
    public static String getDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    /**
     * parseDate
     * 
     * @param date date
     * @return format[yyyyMMdd]
     */
    public static String parseDate(Date date) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(date);
    }

    /**
     * 功能描述: 日期格式化
     */
    public static String dateFormat(Date date, String pattern) {
        String result = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            result = sdf.format(date);
        }
        return result;
    }

    /**
     * 功能描述: 日期计算
     */
    public static String addDay(String date, String pattern, long days) {
        String result = "";
        if (date != null && !"".equals(date.trim())) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
                Date d = sdf.parse(date);
                result = sdf.format(new Date(d.getTime() + days * Constant.DAY_MILL_SECONDS));
            } catch (ParseException e) {
                LOGGER.error(e.getMessage(), e.getMessage());
            }
        }

        return result;
    }

    /**
     * 功能描述: 计算当前时间与第二日零点的时间差
     */
    public static int timeDistance() {
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH),
                curDate.get(Calendar.DATE) + 1, 0, 0, 0);
        return (int) ((tommorowDate.getTimeInMillis() - curDate.getTimeInMillis()) / 1000);
    }

    public static int compare(String t1, String t2) {
        // 转换为Date对象
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 转换为Date对象
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = df1.parse(t1);
            Date d2 = df2.parse(t2);
            // 再比较时间
            return d1.compareTo(d2);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e.getMessage());
            return 0;
        }
    }

    /**
     * 获取活动持续时间，单位是毫秒
     * 
     * @param activityInfo 活动信息
     * @return 时间
     */
    public static int getActTime(String start, String end) {
        Date startTime = DateUtil.parseTime(start);
        Date endTime = DateUtil.parseTime(end);
        return (int) (endTime.getTime() - startTime.getTime());
    }

    /**
     * 获取活动持续时间，单位是毫秒
     * 
     * @param activityInfo 活动信息
     * @return 时间
     */
    public static int getTimeDiff(Timestamp start, Timestamp end) {
        return (int) (end.getTime() - start.getTime());
    }


    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param hour
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String addHourTime(int hour) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.set(Calendar.HOUR_OF_DAY, ca.get(Calendar.HOUR_OF_DAY) - hour);
        return sdf.format(ca.getTime());
    }

    /**
     * 
     * 功能描述: <br>
     * 获取min分钟前的时间
     *
     * @param min
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Timestamp addMinTime(int min) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.set(Calendar.MINUTE, ca.get(Calendar.MINUTE) - min);
        return Timestamp.valueOf(sdf.format(ca.getTime()));
    }

    /**
     * 
     * 功能描述: <br>
     * 获取min分钟前的时间
     *
     * @param min
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Timestamp afterMinTime(int min) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.set(Calendar.MINUTE, ca.get(Calendar.MINUTE) + min);
        return Timestamp.valueOf(sdf.format(ca.getTime()));
    }


    /**
     * 
     * 功能描述: timeStamp2Date<br>
     * 〈功能详细描述〉
     *
     * @param timestampString
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Date timeStamp2Date(String timestampString) {
        Long timestamp = Long.parseLong(timestampString);
        Date date = new java.util.Date(timestamp);
        return date;
    }

    /**
     * 
     * 功能描述: 获得与当前时间的天数差（当前日期-入参日期）<br>
     * 〈功能详细描述〉
     *
     * @param date
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static long getSubDays(Date date) {
        Date d2 = new Date();
        long day = (d2.getTime() - date.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    /**
     * 
     * 功能描述: 获得与当前时间的小时差（当前时间-入参时间）<br>
     * 〈功能详细描述〉
     *
     * @param date2
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static long getSubHours(Date date) {
        Date d2 = new Date();
        long day = (d2.getTime() - date.getTime()) / (60 * 60 * 1000);
        return day;
    }

    /**
     * 
     * 功能描述: 获得与当前时间的分钟差（当前时间-入参时间）<br>
     * 〈功能详细描述〉
     *
     * @param date2
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static long getSubMinutes(Date date) {
        Date d2 = new Date();
        long min = (d2.getTime() - date.getTime()) / (60 * 1000);
        return min;
    }

    /**
     * 字符串专日期（yyyy-MM-dd）
     * 
     * @param dataString
     * @return
     */
    @SuppressWarnings("finally")
    public static Date stringToDate(String dataString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return date;
        }
    }

    /**
     * 获取给定日的起始时刻。
     * 
     * @param when 给定日
     * @return 最后一刻。例如：2006-4-19 00:00:00
     */
    public static Date getDayBegin(Date when) {
        Date date = convertToDateTime(dateParseShortString(when) + " 00:00:00");
        return date;
    }

    /**
     * 将字符串转换为日期（包括时间）
     * 
     * @param "yyyy-MM-dd HH:mm:ss"格式的日期字符串
     * @return 日期时间
     */
    public static Date convertToDateTime(String dateTimeString) {
        try {
            DateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.CHINA);
            return DATE_TIME_FORMAT.parse(dateTimeString);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 日期格式转换为字符串
     * 
     * @param date
     * @return
     */
    public static String dateParseShortString(Date date) {
        java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    /**
     * 日期加法
     * 
     * @param when 被计算的日期
     * @param field the time field. 在Calendar中定义的常数，例如Calendar.DATE
     * @param amount 加数
     * @return 计算后的日期
     */
    public static Date add(Date when, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(when);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 计算给定的日期加上给定的天数。
     * 
     * @param when 给定的日期
     * @param amount 给定的天数
     * @return 计算后的日期
     */
    public static Date addDays(Date when, int amount) {

        return add(when, Calendar.DAY_OF_YEAR, amount);
    }

    /**
     * 计算给定的日期加上给定的分钟数。
     * 
     * @param when 给定的日期
     * @param amount 给定的分钟数
     * @return 计算后的日期
     */
    public static Date addMinutes(Date when, int amount) {

        return add(when, Calendar.MINUTE, amount);
    }

    /**
     * 计算给定的日期加上给定的秒数。
     * 
     * @param when 给定的日期
     * @param amount 给定的秒数
     * @return 计算后的日期
     */
    public static Date addSeconds(Date when, int amount) {

        return add(when, Calendar.SECOND, amount);
    }

    /**
     * 计算给定的日期加上给定的月数。
     * 
     * @param when 给定的日期
     * @param amount 给定的月数
     * @return 计算后的日期
     */
    public static Date addMonths(Date when, int amount) {
        return add(when, Calendar.MONTH, amount);
    }
    
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param hour
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Date addHour(Date when, int hour) {
    	return add(when, Calendar.HOUR, hour);
    }
    
    /**
     * @return 返回今天日期，时间部分为0。例如：2006-4-8 00:00:00
     */
    public static Date getToday() {
        return DateUtils.truncate(new Date(), Calendar.DATE);
    }
    
    /**
     * @return 返回今天日期，时间部分为23:59:59.999。例如：2006-4-19 23:59:59.999
     */
    public static Date getTodayEnd() {
        return getDayEnd(new Date());
    }
    
    /**
     * 获取给定日的最后一刻。
     * 
     * @param when 给定日
     * @return 最后一刻。例如：2006-4-19 23:59:59.999
     */
    public static Date getDayEnd(Date when) {
        Date date = DateUtils.truncate(when, Calendar.DATE);
        date = addDays(date, 1);
        date.setTime(date.getTime() - 1);
        return date;
    }

	/**
	 * @Title: getDateTimeNumber
	 * @Description:返回指定时间的数字格式
	 * @param: 
	 * @return: String
	 * @date: 2018年1月6日 下午4:13:07
	 */
	public static String getDateTimeNumber(Date date) {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}
}