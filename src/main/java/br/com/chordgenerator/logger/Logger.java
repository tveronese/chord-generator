package br.com.chordgenerator.logger;

import static java.lang.String.format;
import static org.apache.log4j.Logger.getLogger;

public class Logger {

    protected Logger() {

        // Hiding public constructor.
    }

    // DEBUG level logging

    private static void debug(Class<?> clazz, String message) {

        getLogger(clazz).debug(message);
    }

    public static void debug(Class<?> clazz, String message, Object... args) {

        debug(clazz, format(message, args));
    }

    public static void debug(Object caller, String message, Object... args) {

        debug(caller.getClass(), message, args);
    }

    // ERROR level logging

    private static void error(Class<?> clazz, Throwable t, String message) {

        getLogger(clazz).error(message, t);
    }

    public static void error(Class<?> clazz, Throwable t, String message, Object... args) {

        error(clazz, t, format(message, args));
    }

    public static void error(Object caller, Throwable t, String message, Object... args) {

        error(caller.getClass(), t, message, args);
    }

    // INFO level logging

    private static void info(Class<?> clazz, String message) {

        getLogger(clazz).info(message);
    }

    public static void info(Class<?> clazz, String message, Object... args) {

        info(clazz, format(message, args));
    }

    public static void info(Object caller, String message, Object... args) {

        info(caller.getClass(), message, args);
    }

    // WARN level logging

    public static void warn(Class<?> clazz, String message) {

        getLogger(clazz).warn(message);
    }

    public static void warn(Class<?> clazz, String message, Object... args) {

        warn(clazz, format(message, args));
    }

    public static void warn(Object caller, String message, Object... args) {

        warn(caller.getClass(), message, args);
    }

}
