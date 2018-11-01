package com.isfinal.util;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * 日期处理
 */
public class DateUtils {

    private static String[] formatters = new String[]{"yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
            "yyyy-MM-dd", "yyyy年MM月dd日", "yyyyMMdd", "yyyy-MM"};

    /**
     * 图表中的日期格式，格式为“yyyy年MM月dd日”
     */
    public static DateFormat getDateFormat() {
        return DateFormat.getDateInstance(1, Locale.CHINA);
    }

    /**
     * 将日期格式化为"yyyy-MM"字符串
     */
    public static String formatYearMonth(Date date) {
        return doFormatDate(date, "yyyy-MM");
    }

    public static String formYYYMMDD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatters[3]);
        return sdf.format(date);
    }

    /**
     * 获取当前时间yyyyMMddHHmmss
     */
    public static String nowFromyyyyMMddHHmmss() {
        SimpleDateFormat sdf = new SimpleDateFormat(formatters[0]);
        return sdf.format(new Date());
    }

    /**
     * 获取前一天时间 YYYYMMDD
     */
    public static String beforeYesterdayFormYYYMMDD() {
        Date date = addDay(new Date(), -2);
        SimpleDateFormat sdf = new SimpleDateFormat(formatters[5]);
        return sdf.format(date);
    }

    /**
     * 返回日期所在的季度
     */
    public static int getSeasons(Date date) {
        int m = getMonth(date);
        if (m <= 0) {
            return 0;
        } else if (m < 4) {
            return 1;
        } else if (m < 7) {
            return 2;
        } else if (m < 10) {
            return 3;
        } else if (m < 13) {
            return 4;
        } else {
            return 0;
        }
    }

    /**
     * 给定日期所在的季度，并返回该季度的第一天日期,如果指定日期错误，返回null
     */
    public static Date getNowSeasonsFirstDay(Date date) {
        int m = getSeasons(date);
        if (m > 0) {
            if (m == 1) {
                return stringToDate(getYear(date) + "-01-01");
            } else if (m == 2) {
                return stringToDate(getYear(date) + "-04-01");
            } else if (m == 3) {
                return stringToDate(getYear(date) + "-07-01");
            } else {
                return stringToDate(getYear(date) + "-10-01");
            }
        }
        return null;
    }

    /**
     * 得到某年的最后一天的日期
     *
     * @param year
     * @return
     */
    public static Date getYearLastDay(String year) {
        if (year == null || "".equals(year)) {
            return null;
        }
        Date nd = stringToDate(year + "-01-01");
        return addDay(addYear(nd, 1), -1);
    }

    /**
     * 得到下个月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getNextMonthFirstDay(String year, String month) {
        if (year == null || "".equals(year) || month == null || "".equals(month)) {
            return null;
        }
        Date nd = stringToDate(year + "-" + month + "-01");
        return addMonth(nd, 1);
    }

    /**
     * 得到某年月的最后一天的日期
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getMonthLastDay(String year, String month) {
        if (year == null || "".equals(year) || month == null || "".equals(month)) {
            return null;
        }
        Date nd = stringToDate(year + "-" + month + "-01");
        return addDay(addMonth(nd, 1), -1);
    }

    /**
     * 给一个时间加上N秒钟或减去N秒钟后得到一个新的日期
     *
     * @param startDate 需要增加的日期时间
     * @param addnos    添加的秒钟数，可以是正数也可以是负数
     * @return 操作后的日期
     */
    public static Date addSecond(Date startDate, int addnos) {
        if (startDate == null) {
            return null;
        }
        Calendar cc = Calendar.getInstance();
        cc.setTime(startDate);
        cc.add(Calendar.SECOND, addnos);
        return cc.getTime();
    }

    /**
     * 给一个时间加上N分种或减去N分种后得到一个新的日期
     *
     * @param startDate 需要增加的日期时间
     * @param addnos    添加的分钟数，可以是正数也可以是负数
     * @return 操作后的日期
     */
    public static Date addMinute(Date startDate, int addnos) {
        if (startDate == null) {
            return null;
        }
        Calendar cc = Calendar.getInstance();
        cc.setTime(startDate);
        cc.add(Calendar.MINUTE, addnos);
        return cc.getTime();
    }

    /**
     * 给一个时间加上一定的小时得到一个新的日期
     *
     * @param startDate 需要增加的日期时间
     * @param addnos    添加的小时数，可以是正数也可以是负数
     * @return 操作后的日期
     */
    public static Date addHour(Date startDate, int addnos) {
        if (startDate == null) {
            return null;
        }
        Calendar cc = Calendar.getInstance();
        cc.setTime(startDate);
        cc.add(Calendar.HOUR, addnos);
        return cc.getTime();
    }

    /**
     * 给一个日期加上N天或减去N天得到一个新的日期
     *
     * @param startDate 需要增加的日期时间
     * @param addnos    添加的天数，可以是正数也可以是负数
     * @return 操作后的日期
     */
    public static Date addDay(Date startDate, int addnos) {
        if (startDate == null) {
            return null;
        }
        Calendar cc = Calendar.getInstance();
        cc.setTime(startDate);
        cc.add(Calendar.DATE, addnos);
        return cc.getTime();
    }

    /**
     * 给一个日期加上N月后或减去N月后得到的一个新日期
     *
     * @param startDate 需要增加的日期时间
     * @param addnos    添加的月数，可以是正数也可以是负数
     * @return 操作后的日期
     */
    public static Date addMonth(Date startDate, int addnos) {
        if (startDate == null) {
            return null;
        }
        Calendar cc = Calendar.getInstance();
        cc.setTime(startDate);
        cc.add(Calendar.MONTH, addnos);
        return cc.getTime();

    }

    /**
     * 给一个日期加上N年后或减去N年后得到的一个新日期
     *
     * @param startDate 需要增加的日期时间
     * @param addnos    添加的年数，可以是正数也可以是负数
     * @return 操作后的日期
     */
    public static Date addYear(Date startDate, int addnos) {
        if (startDate == null) {
            return null;
        }
        Calendar cc = Calendar.getInstance();
        cc.setTime(startDate);
        cc.add(Calendar.YEAR, addnos);
        return cc.getTime();
    }

    /**
     * 计算两个日期相差的月数
     *
     * @param st  起始日期
     * @param end 结束日期
     * @return
     */
    public static int compareMonth(Date st, Date end) {
        int y = Math.abs((getYear(end) < 0 ? 0 : getYear(end)) - (getYear(st) < 0 ? 0 : getYear(st)));
        int m = 0;
        if (y > 0) {
            y--;
            m = Math.abs(12 - getMonth(st) + getMonth(end));
        } else {
            m = Math.abs(getMonth(end) - getMonth(st));
        }
        return (y * 12) + m;
    }

    /**
     * 计算两个日期相差的毫秒数
     *
     * @param start 启始时间
     * @param end   结束时间
     * @return
     */
    public static long compare(Date start, Date end) {
        if (start != null && end != null) {
            return end.getTime() - start.getTime();
        }
        return 0l;
    }

    /**
     * 判断给的日期，是否是当前的前一天以及更早的日期，若是，返回true，否则返回false
     *
     * @param date
     * @return
     */
    public static boolean compareDate(Date date) {
        if (date != null) {
            return date.before(stringToDate(doFormatDate(new Date(), false)));
        }
        return false;
    }

    /**
     * 自定义格式化日期输出
     *
     * @param date
     * @param format
     * @return
     */
    public static String doFormatDate(Date date, String format) {
        if (date == null) {
            return null;
        }
        return (new SimpleDateFormat(format)).format(date);
    }

    /**
     * 对日期进行格式化，格式化后的样式：YYYY-MM-DD/YYYY-MM-DD HH:MM:SS
     *
     * @param date 要进行格式化的日期
     * @param b    为True时，返回长格式的，为Falsh时返回短格式的
     * @return
     */
    public static String doFormatDate(Date date, boolean b) {
        if (date == null) {
            return null;
        }
        if (b) {
            return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
        } else {
            return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
        }
    }

    /**
     * 将字符串格式的日期转为日期类型，如果不能正确转换则返回null，<br>
     * 如果含有“:”则会按“yyyy-MM-dd HH:mm:ss”来转换，否则按“yyyy-MM-dd”转换
     *
     * @param datestr
     * @return
     */
    public static Date stringToDate(String datestr) {
        if (datestr != null && !"".equals(datestr)) {
            SimpleDateFormat sdf;
            if (datestr.indexOf(":") != -1) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            } else {
                sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            }
            Date date = null;
            try {
                date = sdf.parse(datestr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return date;
        } else {
            return null;
        }
    }

    /**
     * 得到当前系统的日期或时间
     *
     * @param b 为true 时返回详细时间格式，为false时返回日期格式，不含时分秒
     * @return 当前的日期或时间
     */
    public static String getDates(boolean b) {
        return doFormatDate(new Date(), b);
    }

    /**
     * 获取当前的年,如果是-1，则表示错误
     *
     * @return
     */
    public static int getYear() {
        return getYear(new Date());
    }

    /**
     * 获取指定日期的年,如果是-1，则表示错误
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        if (date == null) {
            return -1;
        }
        return DateToCalendar(date).get(Calendar.YEAR);
    }

    /**
     * 获取当前月，如果返回"0"，则表示错误
     *
     * @return
     */
    public static int getMonth() {
        return getMonth(new Date());
    }

    /**
     * 获取当前月，如果返回"0"，则表示错误
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        if (date == null) {
            return 0;
        }
        return DateToCalendar(date).get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当天日,如果返回"0",表示该日期无效或为null
     *
     * @return
     */
    public static int getDay() {
        return getDay(new Date());
    }

    /**
     * 取一个日期的日,如果返回"0",表示该日期无效或为null
     *
     * @param da
     * @return
     */
    public static int getDay(Date da) {
        if (da == null) {
            return 0;
        }
        return DateToCalendar(da).get(Calendar.DATE);
    }

    /**
     * 将java.util.Date类型的日期格式转换成java.util.Calendar格式的日期
     *
     * @param dd
     * @return
     */
    public static Calendar DateToCalendar(Date dd) {
        Calendar cc = Calendar.getInstance();
        cc.setTime(dd);
        return cc;
    }

    /**
     * 将一个长整型数据转为日期
     *
     * @param datenum
     * @return
     */
    public static Date longToDate(long datenum) {
        Calendar cc = Calendar.getInstance();
        cc.setTimeInMillis(datenum);
        return cc.getTime();
    }

    /**
     * 将一个长整型数据转为日期格式的字符串
     *
     * @param datenum
     * @return
     */
    public static String longToDateString(long datenum) {
        return doFormatDate(longToDate(datenum), true);
    }

    /**
     * 得到给定日期的前一个周日的日期
     *
     * @param date
     * @return
     */
    public static Date getUpWeekDay(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar cc = Calendar.getInstance();
            cc.setTime(date);
            int week = cc.get(Calendar.DAY_OF_WEEK);
            return DateUtils.addDay(date, (1 - week));
        }
    }

    /**
     * 得到给定日期所在周的周一日期
     *
     * @param date
     * @return
     */
    public static Date getMonday(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar cc = Calendar.getInstance();
            cc.setTime(date);
            int week = cc.get(Calendar.DAY_OF_WEEK);
            return DateUtils.addDay(date, (2 - week));
        }
    }

    /**
     * 得到指定日期所在的周（1-7），惹指定的日期不存在，则返回“-1”
     *
     * @param date
     * @return -1 or 1-7
     */
    public static int getWeek(Date date) {
        if (date == null) {
            return -1;
        } else {
            Calendar cc = Calendar.getInstance();
            cc.setTime(date);
            int week = cc.get(Calendar.DAY_OF_WEEK);
            if (week == 1) {
                week = 7;
            } else {
                week--;
            }
            return week;
        }
    }

    /**
     * 产生随机数
     *
     * @param lo
     * @return
     */
    public static String getRandNum(int lo) {
        if (lo < 1) {
            lo = 4;
        }
        StringBuffer temp = new StringBuffer();
        Random rand = new Random();
        for (int i = 0; i < lo; i++) {
            temp.append(String.valueOf(rand.nextInt(10)));
        }
        return temp.toString();
    }

    /**
     * 产生文件函数名，以当然日期+4位随机码为主
     */
    public static String getDataName() {
        return DateUtils.doFormatDate(new Date(), "yyyyMMddHHmmss") + getRandNum(4);
    }

    /**
     * 将DATE转为数据库的Timestamp类型
     *
     * @param dt
     * @return
     */
    public static Timestamp dateToTime(Date dt) {
        if (dt == null) {
            return null;
        }
        return new Timestamp(dt.getTime());
    }

    /**
     * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
     *
     * @param dateString 需要转换为timestamp的字符串
     * @return dataTime timestamp
     */
    @SuppressWarnings("static-access")
    public static Timestamp string2Time(String dateString) throws ParseException {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH);// 设定格式
        // dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss",
        // Locale.ENGLISH);
        dateFormat.setLenient(false);
        // 我做这块的时候下边的不对，后来我把dateFormat后边加上了.getDateInstance()就好了
        // java.util.Date timeDate = dateFormat.parse(dateString);//util类型
        Date ywybirt = dateFormat.getDateInstance().parse(dateString);// util类型
        Timestamp dateTime = new Timestamp(ywybirt.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
        return dateTime;
    }

    /**
     * 将日期格式转为java.sql.Date
     *
     * @param de
     * @return
     */
    public static java.sql.Date dateToSqlDate(Date de) {
        return new java.sql.Date(de.getTime());
    }

    /**
     * 格式化日期字符串 yyyymmddhh24miss
     *
     * @param date
     * @return
     */
    public static String formatDS(String date) {
        if (date == null) {
            return "";
        }
        return date.replace("-", "").replace(":", "").replace(" ", "");
    }

    /**
     * 将公安部的时间格式转为日期格式
     *
     * @param datestr
     * @return
     */
    public static Date strTdate(String datestr) {
        if (datestr != null && !"".equals(datestr)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            Date date = null;
            try {
                date = sdf.parse(datestr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return date;
        } else {
            return null;
        }
    }

    /**
     * 以公安部的日期格式返回当前系统时间
     *
     * @return
     */
    public static String getGabDate() {
        return doFormatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String str2StrDate(String datestr) {
        Date dd = strTdate(datestr);
        if (dd != null) {
            return DateUtils.doFormatDate(dd, true);
        }
        return null;
    }

    /**
     * 获得往年同期
     *
     * @param datetime
     * @param year
     * @return
     */
    public static String DateAddYear(String datetime, int year) {
        String rtnVal = "";

        Date date = null;
        date = addYear(strTdate(datetime), year);
        rtnVal = formatDS(doFormatDate(date, true));

        return rtnVal;
    }

    public static String getChDate(Date date) {
        return doFormatDate(date, "yyyy年MM月dd日 ahh:mm:ss");
    }

    /**
     * 字符串日期加月
     *
     * @param date
     * @param month
     * @param time
     * @return
     */
    public static String DateAddMonth(String date, int month, String time) {
        String rtnVal = "";

        date = formatDS(date);

        Date datetime = null;
        String temp = formatDS(date) + time;
        datetime = addMonth(strTdate(temp), month);
        temp = doFormatDate(datetime, true);
        rtnVal = formatDS(temp);

        return rtnVal;
    }

    /**
     * 将公安部的14位的时间字符串转换成"YYYY-MM-DD hh:mm:ss"
     *
     * @param time 14位的时间字符串 如20130405210204
     * @return YYYY-MM-DD hh:mm:ss格式的时间字符串
     */
    public static String timeFormate(String time) {
        if (time == null || time.length() < 14) {
            return time;
        } else {
            StringBuilder str = new StringBuilder();
            str.append(time.substring(0, 4)).append("-").append(time.substring(4, 6)).append("-")
                    .append(time.substring(6, 8)).append(" ").append(time.substring(8, 10)).append(":")
                    .append(time.substring(10, 12)).append(":").append(time.substring(12, 14));
            return str.toString();
        }
    }

    /**
     * 将14为字符串转换为“yyyy-mm-dd”格式的时间字符
     *
     * @param time
     * @return
     * @history
     */
    public static String datetimeFormate(String time) {
        if (StringUtils.isBlank(time)) {
            return time;
        } else if (time.length() == 14 || time.length() == 8) {
            StringBuilder str = new StringBuilder();
            str.append(time.substring(0, 4)).append("-").append(time.substring(4, 6)).append("-")
                    .append(time.substring(6, 8));
            return str.toString();
        } else {
            return time;
        }
    }

    /**
     * 将14为字符串转换为“yyyy-mm-dd HH:MM”格式的时间字符
     *
     * @param time
     * @return
     * @history
     */
    public static String dayHourtimeFormate(String time) {
        if (StringUtils.isBlank(time)) {
            return time;
        } else if (time.length() == 14 || time.length() == 8) {
            StringBuilder str = new StringBuilder();
            str.append(time.substring(0, 4)).append("-").append(time.substring(4, 6)).append("-")
                    .append(time.substring(6, 8)).append(" ").append(time.substring(8, 10)).append(":")
                    .append(time.substring(10, 12));
            return str.toString();
        } else {
            return time;
        }
    }

    public static Date stringToDate1(String datestr, String format) {
        Date date = null;
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            date = df.parse(datestr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public static boolean inSameDay(Date d1, Date d2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        String d1Txt = df.format(d1);
        String d2Txt = df.format(d2);
        return StringUtils.equals(d1Txt, d2Txt);
    }

    /**
     * 根据格式化字符串格式化 字符串为时间
     *
     * @param dateString 日期的字符串形式
     * @param formatType 格式化字符串类型
     * @return
     * @history
     */
    public static Date getDateTimeByFormat(String dateString, int formatType) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        String formatter = formatters[formatType];
        return stringToDate1(dateString, formatter);
    }

    /**
     * 根据格式化字符串格式化 将日期转换成字符串形式
     *
     * @param date       日期
     * @param formatType 格式化字符串类型
     * @return
     * @history
     */
    public static String doFormatDateByFormat(Date date, int formatType) {
        if (date == null) {
            return null;
        }
        String formatter = formatters[formatType];
        return (new SimpleDateFormat(formatter)).format(date);
    }

    /**
     * 根据源时间字符串和相应的格式化类型获取目标时间字符串
     *
     * @param srcString     源时间字符串
     * @param srcFormatType 源字符串格式化类型
     * @param desFormatType 目标字符串格式化类型
     * @return
     * @history
     */
    public static String getFormatStringByFormatString(String srcString, int srcFormatType, int desFormatType) {
        if (StringUtils.isBlank(srcString)) {
            return null;
        }
        Date d = getDateTimeByFormat(srcString, srcFormatType);
        return doFormatDateByFormat(d, desFormatType);
    }

    /**
     * 获得日期的年份第一天日期
     *
     * @param date 日期
     * @return
     * @history
     */
    public static Date getDateStartOfYear(Date date) {
        Calendar calendar = DateToCalendar(date);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获得日期的年份最后一天日期
     *
     * @param date 日期
     * @return
     * @history
     */
    public static Date getDateEndOfYear(Date date) {
        Calendar calendar = DateToCalendar(date);
        calendar.add(Calendar.YEAR, 1);
        Date newDate = getDateStartOfYear(calendar.getTime());
        calendar = DateToCalendar(newDate);
        calendar.add(Calendar.SECOND, -1);
        return calendar.getTime();
    }

    /**
     * 计算两个时间的月份差，如果年份差大于1年，则返回9999
     *
     * @param from 开始时间
     * @param to   结束时间
     * @return
     * @history
     */
    public static int getMonthCount(Date from, Date to) {
        int fromYear = getYear(from);
        int toYear = getYear(to);
        int fromMonth = getMonth(from);
        int toMonth = getMonth(to);
        if (fromYear == toYear) {
            return (toMonth - fromMonth);
        } else if ((toYear - fromYear) == 1) {
            return ((12 - fromMonth) + toMonth);
        }
        return 9999;
    }

    public static Date formatString(String datestr) {
        for (int i = 0; i < formatters.length; i++) {
            try {
                String strformat = formatters[i];
                SimpleDateFormat sdf = new SimpleDateFormat(strformat);
                return sdf.parse(datestr);
            } catch (Exception e) {

            }
        }
        return null;
    }

    /**
     * 根据源时间字符串和相应的格式化类型获取目标时间字符串
     *
     * @param srcString     源时间字符串
     * @param srcFormatType 源字符串格式化类型
     * @param desFormatType 目标字符串格式化类型
     * @return
     */
    public static String getFormatStringByFormatString(String srcString, String srcFormatType, String desFormatType) {
        if (StringUtils.isBlank(srcString)) {
            return null;
        }
        Date d = getDateTimeByFormat(srcString, srcFormatType);
        return doFormatDateByFormat(d, desFormatType);
    }

    /**
     * 根据格式化字符串格式化 字符串为时间
     *
     * @param dateString 日期的字符串形式
     * @param formatType 格式化字符串类型
     * @return
     */
    public static Date getDateTimeByFormat(String dateString, String formatType) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        return stringToDate1(dateString, formatType);
    }

    /**
     * 根据格式化字符串格式化 将日期转换成字符串形式
     *
     * @param date       日期
     * @param formatType 格式化字符串类型
     * @return
     */
    public static String doFormatDateByFormat(Date date, String formatType) {
        if (date == null) {
            return null;
        }
        return (new SimpleDateFormat(formatType)).format(date);
    }

    /**
     * 根据出生日期获取年龄信息
     *
     * @param csrq   出生日期
     * @param format 年龄精度（yyyy，年；yyyy[-]MM，月；yyyy[-]MM[-]dd，日）
     * @return
     */
    public static int getAgeByCsrq(Date csrq, String format, Date compareDate) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        String csrqString = df.format(csrq);
        try {
            csrq = df.parse(csrqString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar csrqCalendar = Calendar.getInstance();
        csrqCalendar.setTime(csrq);
        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(compareDate);
        int yearMinus = nowTime.get(Calendar.YEAR) - csrqCalendar.get(Calendar.YEAR);
        // 月份是否大于出生日期
        boolean monthCompareFlag = (nowTime.get(Calendar.MONTH) - csrqCalendar.get(Calendar.MONTH)) >= 0;
        if (!monthCompareFlag) {
            yearMinus -= 1;
            return yearMinus;
        }
        // 月份所在天数是否大于出生日期
        boolean dayOfMonthCompareFlag = (nowTime.get(Calendar.DAY_OF_MONTH)
                - csrqCalendar.get(Calendar.DAY_OF_MONTH)) >= 0;
        if (!dayOfMonthCompareFlag) {
            yearMinus -= 1;
            return yearMinus;
        }
        return yearMinus;
    }
}
