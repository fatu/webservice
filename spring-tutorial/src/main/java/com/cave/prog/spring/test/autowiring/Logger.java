package com.cave.prog.spring.test.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author boaztu
 */

@Component
public class Logger {

    private ConsoleWriter consoleWriter;
    private LogWriter fileWriter;

    @Inject
    public void setConsoleWriter(final ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    @Inject
    @Named(value = "fileWriter")
    public void setFileWriter(final LogWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void writeFile(String text) {
        fileWriter.write(text);
    }

    public void writeConsole(String text) {
        if (consoleWriter != null)
            consoleWriter.write(text);
    }


}
