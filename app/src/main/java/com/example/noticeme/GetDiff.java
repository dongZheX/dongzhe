package com.example.noticeme;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ASUS on 2018/2/24.
 */

public class GetDiff {
    public static long getDiff(){
        String dateStr = "2017-11-7 24:00:00";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date1 = null;
        try {
            date1 = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = new Date();
        long num = (date2.getTime()-date1.getTime())/ (1000*3600*24);
        return num;
    }
}
