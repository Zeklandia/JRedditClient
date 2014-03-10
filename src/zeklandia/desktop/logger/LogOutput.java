package zeklandia.desktop.logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.fusesource.jansi.AnsiConsole;

public class LogOutput {

	private static final String classname = "LogOutput";
	private static final String padding = "        ";
	private static final String destination = "";

	/**
	 * Prepares the console with JANSI
	 * This must be called before anything is printed to the console
	 */
	public static void prepareConsole() {
		System.out.println("Installing JANSI...");
		AnsiConsole.systemInstall();
		logMessage(padding, classname, "JANSI loaded");
	}

	/**
	 * Logs an error message to the console
	 *
	 * String padding	= aligns text with other output
	 * String classname	= name of the class producing the output
	 * String error		= error message to be output
	 */
	public static void logError(String padding, String classname, String error) {
		AnsiConsole.system_err.println("\033[1;30m[\033[0;37m" + System.currentTimeMillis() + "\033[1;30m]"
			+ " \033[1;30m[\033[1;37mJava-Reddit\033[1;30m]"
			+ " \033[1;30m[\033[1;31mError\033[1;30m]"
			+ " \033[1;30m[\033[0;37m" + classname + "\033[1;30m]"
			+ padding
			+ " \033[0;31m" + error + "\033[0;0m");
	}

	/**
	 * Logs an error message to a file
	 *
	 * String padding	= aligns text with other output
	 * String classname	= name of the class producing the output
	 * String error		= error message to be written
	 * String destination	= file the message is to be written to
	 */
	public static void logError(String padding, String classname, String error, String destination) throws FileNotFoundException {
		PrintWriter logFile = new PrintWriter(destination);
		logFile.println("[" + System.currentTimeMillis() + "]"
			+ " [Java-Reddit]"
			+ " [Error]"
			+ " [" + classname + "]"
			+ padding
			+ " " + error);
	}

	/**
	 * Logs a message to the console
	 *
	 * String padding	= aligns text with other output
	 * String classname	= name of the class producing the output
	 * String message	= message to be output
	 */
	public static void logMessage(String padding, String classname, String message) {
		AnsiConsole.system_out.println("\033[1;30m[\033[0;37m" + System.currentTimeMillis() + "\033[1;30m]"
			+ " \033[1;30m[\033[1;37mJava-Reddit\033[1;30m]"
			+ " \033[1;30m[\033[1;32m Msg \033[1;30m]"
			+ " \033[1;30m[\033[0;37m" + classname + "\033[1;30m]"
			+ padding
			+ " \033[0;0m" + message + "\033[0;0m");
	}

	/**
	 * Logs a message to a file
	 *
	 * String padding	= aligns text with other output
	 * String classname	= name of the class producing the output
	 * String message	= message to be written
	 * String destination	= file the message is to be written to
	 */
	public static void logMessage(String padding, String classname, String message, String destination) throws FileNotFoundException {
		PrintWriter logFile = new PrintWriter(destination);
		logFile.println("[" + System.currentTimeMillis() + "]"
			+ " [Java-Reddit]"
			+ " [ Msg ]"
			+ " [" + classname + "]"
			+ padding
			+ " " + message);
	}
}