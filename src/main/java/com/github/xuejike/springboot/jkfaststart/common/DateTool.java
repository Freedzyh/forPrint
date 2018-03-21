package com.github.xuejike.springboot.jkfaststart.common;

import org.apache.commons.lang3.ArrayUtils;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yf003 on 2017/7/28.
 * 获取日期时间工具类
 */
public class DateTool {


    private static SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");



    private static SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private static SimpleDateFormat formater3 = new SimpleDateFormat("yyyy-MM-dd");

    public static Long getStartTime(Long time){

        Date start = null;
        try {
            start = formater.parse(formater.format(new Date(time))+ " 00:00:00");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return start.getTime();
    }


    public static Long getEndTime(Long time){
        Date end = null;
        try {
            end = formater2.parse(formater.format(new Date(time))+ " 23:59:59");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return end.getTime();
    }

    public static String getcreateTimeTag(Long time){

        String format = formater3.format(time);
        return format;
    }



    public static Long getLastMonthStartTime(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH,1);
        return c.getTime().getTime();
    }


    public static Long getLastMonthEndTime(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH,0);
        return c.getTime().getTime();
    }


    /**
     * 获得本月开始时间
     * @return
     */
    public static DateTime getCurrenttMonthTimeStart(){
        return new DateTime().minusDays(new DateTime().getDayOfMonth()-1).withTimeAtStartOfDay();
    }

    /**
     * 获得本月结束时间
     * @return
     */
    public static DateTime getCurrenttMonthTimeEnd(){
        return new DateTime().minusDays(new DateTime().getDayOfMonth()-1).plusMonths(1).withTimeAtStartOfDay();
    }

    /**
     * 获得本周开始时间
     * @return
     */
    public static DateTime getCurrenttWeekTimeStart(){
        return new DateTime().minusDays(new DateTime().getDayOfWeek()-1).withTimeAtStartOfDay();
    }

    /**
     * 获得本周结束时间
     * @return
     */
    public static DateTime getCurrenttWeekTimeEnd(){
        return new DateTime().plusDays(8-new DateTime().getDayOfWeek()).withTimeAtStartOfDay();
    }

    /**
     * 获得今天开始时间
     * @return
     */
    public static DateTime getCurrentDayTimeStart(){
        return new DateTime().withTimeAtStartOfDay();
    }


    /**
     * 获得昨天开始时间
     * @return
     */
    public static DateTime getLastDayTimeStart(){
        return new DateTime().withTimeAtStartOfDay().plusDays(-1);
    }

    /**
     * 获得昨天结束时间
     * @return
     */
    public static DateTime getLastDayTimeEnd(){
        return new DateTime().withTimeAtStartOfDay();
    }

    public static int getWeekDays(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return w;
    }

    public static void main(String[] args){

        int weekDays = DateTool.getWeekDays();

        System.out.println("星期：" + weekDays);

        String[] split = new String[]{"2","5"};
        boolean contains = ArrayUtils.contains(split,weekDays);


        if(!contains){
            System.out.println("提现时间：只允许（周二，周五）");
        }else{
            System.out.println("允许提现");
        }


    }

}
