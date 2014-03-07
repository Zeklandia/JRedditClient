package zeklandia.desktop.logger;

/**
 *
 * @author Zeklandia
 */
import org.fusesource.jansi.AnsiConsole;

public class LogOutput {

    private static final String classname = "LogOutput";
    private static final String padding = "        ";

    public static void prepareConsole() {
	System.out.println("Installing JANSI...");
	AnsiConsole.systemInstall();
	logMessage(padding, classname, "JANSI Installed");
    }

    public static void logError(String padding, String classname, String error) {
	AnsiConsole.system_err.println("\033[1;30m[\033[0;37m" + System.currentTimeMillis() + "\033[1;30m]"
		+ " \033[1;30m[\033[1;37mJava-Reddit\033[1;30m]"
		+ " \033[1;30m[\033[1;31mError\033[1;30m]"
		+ " \033[1;30m[\033[0;37m" + classname + "\033[1;30m]"
		+ padding
		+ " \033[0;31m" + error + "\033[0;0m");
    }

    public static void logMessage(String padding, String classname, String message) {
	AnsiConsole.system_out.println("\033[1;30m[\033[0;37m" + System.currentTimeMillis() + "\033[1;30m]"
		+ " \033[1;30m[\033[1;37mJava-Reddit\033[1;30m]"
		+ " \033[1;30m[\033[1;32m Msg \033[1;30m]"
		+ " \033[1;30m[\033[0;37m" + classname + "\033[1;30m]"
		+ padding
		+ " \033[0;0m" + message + "\033[0;0m");
    }
}
