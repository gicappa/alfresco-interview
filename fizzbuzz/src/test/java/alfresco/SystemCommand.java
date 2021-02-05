package alfresco;

import java.io.IOException;

import static java.lang.String.format;

/**
 * Helper class to launch a system command and get the standard output
 * and the standard error.
 */
public class SystemCommand {

    private String stdout = "";
    private String stderr = "";

    /**
     * Run a process launching a command. It waits for the command to
     * complete and returns its exit code.
     * It also records the standard output in the field `stdout`
     *
     * @param command to be launched
     * @return the exit code of the command execution
     * @throws RuntimeException the command can be invalid
     */
    public int run(String command, String... args) {
        try {
            Process process = Runtime.getRuntime().exec(format(command, args));
            process.waitFor();

            stdout = new String(process.getInputStream().readAllBytes());
            stderr = new String(process.getErrorStream().readAllBytes());

            return process.exitValue();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes the content of the standard output
     */
    public void clearStdout() {
        stdout = "";
    }

    /**
     * Deletes the content of the standard error
     */
    public void clearStderr() {
        stderr = "";
    }

    /**
     * @return the content of the standard output
     */
    public String getStdout() {
        return stdout;
    }

    /**
     * @return the content of the standard error
     */
    public String getStderr() {
        return stderr;
    }
}
