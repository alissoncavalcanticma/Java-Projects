package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date y1 = sdf1.parse("21/06/2021");
        Date y2 = sdf2.parse("21/06/2021 20:20:21");

        Date x1 = new Date();
        Date x2 = new Date(System.currentTimeMillis());
        Date x3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));


        System.out.println(sdf2.format(y1));
        System.out.println(y2);

        System.out.println("X1 : " + x1);
        System.out.println("X2 : " + x2);
        System.out.println("X3: " + x3);
        System.out.println("X3-sdf1: " + sdf1.format(x3));
        System.out.println("X3-sdf3: " + sdf3.format(x3));
        System.out.println("X3-sdf3: " + sdf3.format(x3));
    }
}
