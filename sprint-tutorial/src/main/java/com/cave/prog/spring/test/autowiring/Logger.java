package com.cave.prog.spring.test.autowiring;

/**
 * @author boaztu
 */
public class Logger {
    private ConsoleWriter consoleWriter;
    private FileWriter fileWriter;

    public void setConsoleWriter(final ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    public void setFileWriter(final FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void writeFile(String text) {
        fileWriter.write(text);
    }

    public void writeConsole(String text) {
        consoleWriter.write(text);
    }
}
