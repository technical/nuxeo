package org.nuxeo.common.utils;

import static org.nuxeo.common.utils.DateUtils.parse;

import org.junit.Test;

public class TestDateUtils {

    private static final String[] VALID_DATES = {
            "1985-04-12T23:20:50.52Z",
            "1986-04-12T19:20:50.52-04:00",
            "1987-10-11T22:14:15.003Z",
            "1988-08-24T05:14:15.000003-07:00",
            "1989-04-13T11:11:11-08:00",
            "1990-04-13T08:08:08.0001+00:00",
            "1991-04-13T08:08:08.251+00:00",
            "1992-04-13T08:08:08.008+09:00",
            "1993",
            "1994-03",
            "1995-03-12",
            "1996-03-12T12",
            "1997-02-03T12:34",
            "1998-08-08T12:34:56",
            "1999-08-08T12:34:56.789",
            "2000-02-22T14:32:55.188+01:00[Europe/Paris]",
            "2019-02-22T14:38:50.090+01:00[Europe/Paris]"
    };

    @Test
    public void testParse() {
        for (String date : VALID_DATES) {
            parse(date);
            parse(date.replaceAll("T", " "));
        }
    }

}
