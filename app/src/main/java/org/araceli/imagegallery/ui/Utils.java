package org.araceli.imagegallery.ui;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static final String LOG_TAG = "Utils";

    private static final SimpleDateFormat OUTPUT_SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static final SimpleDateFormat PUBLISHED_SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
    public static final SimpleDateFormat TAKEN_SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    public static String formatPublishedDate(String input) {
        return formatDate(PUBLISHED_SDF, input);
    }

    public static String formatTakenDate(String input) {
        return formatDate(TAKEN_SDF, input);
    }

    /**
     * Return formatted date or empty String.
     * @param format
     * @param input the date to format
     * @return
     */
    private static String formatDate(SimpleDateFormat format, String input) {
        String output = "";
        try {
            if(input != null) {
                Date date = format.parse(input);
                output = OUTPUT_SDF.format(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e(LOG_TAG, e.getMessage());
        }
        return output;
    }

    public static String convertAuthor(String author) {
        int index = author.indexOf("\"");
        author = author.substring(index+1, author.length() - 2);
        return author;
    }
}
