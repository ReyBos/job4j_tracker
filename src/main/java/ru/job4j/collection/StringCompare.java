package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftChars = left.toCharArray();
        char[] rightChars = right.toCharArray();
        int length = leftChars.length > rightChars.length ? rightChars.length : leftChars.length;
        int rsl = 0;
        for (int i = 0; i < length; i++) {
            rsl = Character.compare(leftChars[i], rightChars[i]);
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0 && leftChars.length != rightChars.length) {
            rsl = leftChars.length - rightChars.length;
        }
        return rsl;
    }
}