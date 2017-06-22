package org.araceli.imagegallery;

import junit.framework.Assert;

import org.araceli.imagegallery.ui.Utils;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void shouldFormatPublishedDate() throws Exception {
        String formattedDate = Utils.formatPublishedDate("2017-06-21T19:56:45Z");

        Assert.assertEquals("21/06/2017 20:56:45", formattedDate);
    }

    @Test
    public void shouldReturnEmpty_WhenMalformedPublishedDate() throws Exception {
        String formattedDate = Utils.formatPublishedDate("This is not a date");

        Assert.assertEquals("", formattedDate);
    }

    @Test
    public void shouldTReturnEmpty_WhenPublishedDateIsNull() throws Exception {
        String formattedDate = Utils.formatPublishedDate(null);

        Assert.assertEquals("", formattedDate);
    }

    @Test
    public void shouldFormatTakenDate() throws Exception {
        String takenDate = Utils.formatTakenDate("2017-06-20T19:35:57-08:00");

        Assert.assertEquals("21/06/2017 04:35:57", takenDate);
    }

    @Test
    public void shouldReturnEmpty_WhenMalformedTakenDate() throws Exception {
        String takenDate = Utils.formatTakenDate("This is not a date");

        Assert.assertEquals("", takenDate);
    }

    @Test
    public void shouldReturnEmpty_WhenTakenDateIsNull() throws Exception {
        String takenDate = Utils.formatTakenDate(null);
        Assert.assertEquals("", takenDate);
    }

    @Test
    public void shouldExtractAuthorName() throws Exception {
        String author = Utils.convertAuthor("nobody@flickr.com(\"unicorn\")");

        Assert.assertEquals("unicorn", author);
    }
}
