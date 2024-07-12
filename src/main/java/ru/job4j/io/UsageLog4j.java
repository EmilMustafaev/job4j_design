package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int intLog = 33;
        double doubleLog = 5.5;
        float floatLog = 10.5F;
        long longLog = 100L;
        byte byteLog = 3;
        short shortLog = 87;
        boolean booleanLog = true;
        char charLog = 'A';

        LOG.debug("Log info : intLog: {}, doubleLog: {}, floatLog: {}, longLog: {},"
                        + "\n byteLog: {}, shortLog: {}, booleanLog: {}, charLog: {}",
                intLog, doubleLog, floatLog, longLog, byteLog, shortLog, booleanLog, charLog);
    }
}
