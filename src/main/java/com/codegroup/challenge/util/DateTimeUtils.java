package com.codegroup.challenge.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.util.ObjectUtils.isEmpty;

public final class DateTimeUtils {

    private DateTimeUtils() {}

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate toLocalDate(String date) {
        if (!isEmpty(date)) {
            return LocalDate.parse(date, dateTimeFormatter);
        }

        return null;
    }

    public static String toLocalDate(LocalDate date) {
        if (!isEmpty(date)) {
            return date.format(dateTimeFormatter);
        }

        return null;
    }

}
