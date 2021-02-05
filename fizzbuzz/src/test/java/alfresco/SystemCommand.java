package alfresco;

import java.io.IOException;

import static java.lang.String.format;

/**
 * Helper class to launch a system command and get the standard output
 * and the standard error.
 */
public class SystemCommand {

    /**
     * Run a process launching a command. It waits for the command to
     * complete and returns its exit code.
     * It also records the standard output in the field `stdout`
     *
     * @param command to be launched
     * @return the exit code of the command execution
     * @throws RuntimeException the command can be invalid
     */
    public Result run(String command, String... args) {
        try {
            Process process = Runtime.getRuntime().exec(format(command, args));
            process.waitFor();


            return new Result(process);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Result {
        private final String stdout;
        private final String stderr;
        private final int exitValue;

        public Result(Process process) {
            try {
                stdout = new String(process.getInputStream().readAllBytes());
                stderr = new String(process.getErrorStream().readAllBytes());
                exitValue = process.exitValue();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

        /**
         * @return the exit value of the command
         */
        public int getExitValue() {
            return exitValue;
        }
    }
}
