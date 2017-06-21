package org.araceli.imagegallery.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static final SimpleDateFormat OUTPUT_SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static final SimpleDateFormat PUBLISHED_SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
    public static final SimpleDateFormat TAKEN_SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    public static String formatPublishedDate(String input) {
        return formatDate(PUBLISHED_SDF, input);
    }

    public static String formatTakenDate(String input) {
        return formatDate(TAKEN_SDF, input);
    }

    private static String formatDate(SimpleDateFormat format, String input) {
        String output = "";
        try {
            Date date = format.parse(input);
            output = OUTPUT_SDF.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return output;
    }
}
