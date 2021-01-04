package com.space.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class UtilForShips {
    public static Date dateRound(Long date) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(new Date(date));
        calendarDate.set(Calendar.MONTH, 0);
        calendarDate.set(Calendar.DAY_OF_MONTH, 1);
        calendarDate.set(Calendar.HOUR, 2);
        calendarDate.set(Calendar.MINUTE, 0);
        calendarDate.set(Calendar.SECOND, 0);
        calendarDate.set(Calendar.MILLISECOND, 0);
        return calendarDate.getTime();
    }

    public static double ratingRound(double value) {
        return Math.round(value * 100) / 100D;
    }
}
