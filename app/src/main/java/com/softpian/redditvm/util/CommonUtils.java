package com.softpian.redditvm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CommonUtils {

    public static String getDateFromUnixTimestamp(double timestamp) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis((long)timestamp * 1000);

        return new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.getDefault())
                .format(calendar.getTime());
    }
}
