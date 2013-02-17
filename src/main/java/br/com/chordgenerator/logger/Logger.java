package br.com.chordgenerator.logger;

import static org.apache.log4j.Logger.getLogger;

/**
 * This class provides a common way to log messages through several static
 * methods.
 * 
 * @author Thiago Veronese
 */
public class Logger {

	/**
	 * Logs a message as DEBUG.
	 * 
	 * @param clazz
	 *            The class that is calling this method.
	 * @param message
	 *            The message to be logged.
	 */
	public static void debug(Class<?> clazz, Object message) {

		getLogger(clazz).debug(message);
	}

	/**
	 * Logs a message as DEBUG.
	 * 
	 * @param caller
	 *            The object that is calling this method.
	 * @param message
	 *            The message to be logged.
	 */
	public static void debug(Object caller, Object message) {

		debug(caller.getClass(), message);
	}

	/**
	 * Logs a message as ERROR.
	 * 
	 * @param clazz
	 *            The class that is calling this method.
	 * @param message
	 *            The message to be logged.
	 * @param t
	 *            The throwable to be logged.
	 */
	public static void error(Class<?> clazz, Object message, Throwable t) {

		getLogger(clazz).error(message, t);
	}

	/**
	 * Logs a message as ERROR.
	 * 
	 * @param caller
	 *            The object that is calling this method.
	 * @param message
	 *            The message to be logged.
	 * @param t
	 *            The throwable to be logged.
	 */
	public static void error(Object caller, Object message, Throwable t) {

		error(caller.getClass(), message, t);
	}

	/**
	 * Logs a message as INFO.
	 * 
	 * @param clazz
	 *            The class that is calling this method.
	 * @param message
	 *            The message to be logged.
	 */
	public static void info(Class<?> clazz, Object message) {

		getLogger(clazz).info(message);
	}

	/**
	 * Logs a message as INFO.
	 * 
	 * @param caller
	 *            The object that is calling this method.
	 * @param message
	 *            The message to be logged.
	 */
	public static void info(Object caller, Object message) {

		info(caller.getClass(), message);
	}

	/**
	 * Logs a message as WARN.
	 * 
	 * @param clazz
	 *            The class that is calling this method.
	 * @param message
	 *            The message to be logged.
	 */
	public static void warn(Class<?> clazz, Object message) {

		getLogger(clazz).warn(message);
	}

	/**
	 * Logs a message as WARN.
	 * 
	 * @param caller
	 *            The object that is calling this method.
	 * @param message
	 *            The message to be logged.
	 */
	public static void warn(Object caller, Object message) {

		warn(caller.getClass(), message);
	}

}
