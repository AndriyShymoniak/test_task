package com.shymoniak.testapp.service.utils;

import com.shymoniak.testapp.domain.AirCompanyDTO;
import com.shymoniak.testapp.domain.AirplaneDTO;
import com.shymoniak.testapp.domain.FlightDTO;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class Validator {
    public boolean isValid(AirCompanyDTO obj) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if ((field.get(obj) == null
                        || field.get(obj).equals(0)
                        || field.get(obj).equals(""))
                        && !field.getName().equals("id")) {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean isValid(AirplaneDTO obj) {
        try {
            Class<?> objClass = obj.getClass();
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if ((field.get(obj) == null
                        || field.get(obj).equals(0)
                        || field.get(obj).equals(""))
                        && !field.getName().equals("id")
                        && !field.getName().equals("airCompanyId")
                        && !field.getName().equals("numberOfFlights")) {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean isValid(FlightDTO obj) {
        try {
            Class<?> objClass = obj.getClass();
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println(field.getName());
                if ((field.get(obj) == null
                        || field.get(obj).equals(0)
                        || field.get(obj).equals(""))
                        && !field.getName().equals("id")
                        && !field.getName().equals("endedAt")
                        && !field.getName().equals("startedAt")
                        && !field.getName().equals("delayStartedAt")
                        && !field.getName().equals("flightStatus")) {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
