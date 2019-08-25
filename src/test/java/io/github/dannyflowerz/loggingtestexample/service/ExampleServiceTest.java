package io.github.dannyflowerz.loggingtestexample.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

class ExampleServiceTest {

    private Logger myLogger;
    private ListAppender<ILoggingEvent> testLoggerAppender;
    private ExampleService underTest = new ExampleService();

    @Test
    @DisplayName("SHOULD log warning WHEN example call is made")
    void example() {
        // given
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        myLogger = context.getLogger(ExampleService.class);
        testLoggerAppender = new ListAppender<>();
        testLoggerAppender.start();
        myLogger.addAppender(testLoggerAppender);

        // when
        underTest.example();

        // then
        assertEquals(1, testLoggerAppender.list.size());
        assertEquals(Level.WARN, testLoggerAppender.list.get(0).getLevel());
        assertTrue(testLoggerAppender.list.get(0).getFormattedMessage().contains("Catch me if you can!"));
    }

}