/*
 * (C) Copyright 2006-2011 Nuxeo SA (http://nuxeo.com/) and others.
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
 *     Nuxeo - initial API and implementation
 */
package org.nuxeo.ecm.automation.client.model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Parse / format ISO 8601 dates.<br>
 * <br>
 * Duplicate of {@link org.nuxeo.ecm.core.schema.utils.DateParser}
 *
 * @author "Stephane Lacoin [aka matic] <slacoin at nuxeo.com>"
 * @deprecated since 11.1, use {@link org.nuxeo.common.utils.DateUtils} instead
 */
@Deprecated
public class DateParser {

    public static Calendar parse(String str) throws ParseException {
        return org.nuxeo.ecm.core.schema.utils.DateParser.parse(str);
    }

    public static Date parseW3CDateTime(String str) {
        return org.nuxeo.ecm.core.schema.utils.DateParser.parseW3CDateTime(str);
    }

    /**
     * 2011-10-23T12:00:00.00Z
     * 
     * @param date
     * @return
     */
    public static String formatW3CDateTime(Date date) {
        return org.nuxeo.ecm.core.schema.utils.DateParser.formatW3CDateTime(date);
    }

    public static String formatW3CDateTimeMs(Date date) {
        return org.nuxeo.ecm.core.schema.utils.DateParser.formatW3CDateTimeMs(date);
    }

}
