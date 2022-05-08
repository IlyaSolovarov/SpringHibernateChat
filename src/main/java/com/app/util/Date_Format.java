package com.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Date_Format {
    static private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yy");

    static public String format(Date date) {
        return dateFormat.format(date);
    }
}
