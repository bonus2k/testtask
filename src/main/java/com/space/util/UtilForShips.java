package com.space.util;

import com.space.model.Ship;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.*;

public class UtilForShips {
//    public static Date dateRound(Long date) {
//        Calendar calendarDate = Calendar.getInstance();
//        calendarDate.setTime(new Date(date));
//        calendarDate.set(Calendar.MONTH, 0);
//        calendarDate.set(Calendar.DAY_OF_MONTH, 1);
//        calendarDate.set(Calendar.HOUR, 2);
//        calendarDate.set(Calendar.MINUTE, 0);
//        calendarDate.set(Calendar.SECOND, 0);
//        calendarDate.set(Calendar.MILLISECOND, 0);
//        return calendarDate.getTime();
//    }

    public static int getYearFromDate(Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static Date getDateForYear(int year) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
//        calendar.set(Calendar.HOUR, 2);
        return calendar.getTime();
    }

    public static double round(double value) {
        return Math.round(value * 100) / 100D;
    }

    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static Boolean editValidator(Ship ship) {
                boolean isCrewSize = (ship.getCrewSize()==null)?true:isCrewSizeValid(ship.getCrewSize());
                boolean isSpeed = (ship.getSpeed()==null)?true:isSpeedValid(ship.getSpeed());
                boolean isNameValid = (ship.getName()==null)?true:isStringValid(ship.getName());
                boolean isPlanetValid = (ship.getPlanet()==null)?true:isStringValid(ship.getPlanet());
                boolean isProdDate = (ship.getProdDate()==null)?true:isProdDateValid(ship.getProdDate());
        return  isCrewSize && isSpeed && isNameValid && isPlanetValid && isProdDate;
    }

    public static Boolean createValidator(Ship ship) {
        boolean isCrewSize = (ship.getCrewSize()==null)?false:isCrewSizeValid(ship.getCrewSize());
        boolean isSpeed = (ship.getSpeed()==null)?false:isSpeedValid(ship.getSpeed());
        boolean isNameValid = (ship.getName()==null)?false:isStringValid(ship.getName());
        boolean isPlanetValid = (ship.getPlanet()==null)?false:isStringValid(ship.getPlanet());
        boolean isProdDate = (ship.getProdDate()==null)?false:isProdDateValid(ship.getProdDate());
        return  isCrewSize && isSpeed && isNameValid && isPlanetValid && isProdDate;
    }

    private static boolean isCrewSizeValid(Integer crewSize) {
        final int minCrewSize = 1;
        final int maxCrewSize = 9999;
        return crewSize.compareTo(minCrewSize) >= 0 && crewSize.compareTo(maxCrewSize) <= 0;
    }

    private static boolean isSpeedValid(Double speed) {
        final double minSpeed = 0.01;
        final double maxSpeed = 0.99;
        return speed.compareTo(minSpeed) >= 0 && speed.compareTo(maxSpeed) <= 0;
    }

    private static boolean isStringValid(String value) {
        final int maxStringLength = 50;
        return !value.isEmpty() && value.length() <= maxStringLength;
    }

    private static boolean isProdDateValid(Date prodDate) {
        final Date startProd = getDateForYear(2800);
        final Date endProd = getDateForYear(3019);
        return prodDate.after(startProd) && prodDate.before(endProd);
    }

}
