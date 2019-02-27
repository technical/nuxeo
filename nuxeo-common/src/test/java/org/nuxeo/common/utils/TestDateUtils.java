/*
 * (C) Copyright 2019 Nuxeo (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     pierre
 */
package org.nuxeo.common.utils;

import static org.junit.Assert.assertEquals;
import static org.nuxeo.common.utils.DateUtils.formatISODateTime;
import static org.nuxeo.common.utils.DateUtils.parseISODateTime;

import java.time.ZonedDateTime;

import org.junit.Test;

/**
 * @since 11.1
 */
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
    };

    private static final String[] EQUALS_DATES = {
            "1985-04-12T23:20:50.52Z",
            "1986-04-12T19:20:50.52-04:00",
            "1987-10-11T22:14:15.003Z",
            // "1988-08-24T05:14:15.000003-07:00", precision is 3 digits for fraction-of-second
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
    };

    @Test
    public void testParse() {
        for (String input : VALID_DATES) {
            parseISODateTime(input);
            parseISODateTime(input.replaceAll("T", " "));
        }
    }

    @Test
    public void testEquals() {
        for (String input : EQUALS_DATES) {
            ZonedDateTime zdt = parseISODateTime(input);
            ZonedDateTime zdt2 = parseISODateTime(formatISODateTime(zdt));
            assertEquals(zdt.toInstant().toEpochMilli(), zdt2.toInstant().toEpochMilli());
        }
    }

}
