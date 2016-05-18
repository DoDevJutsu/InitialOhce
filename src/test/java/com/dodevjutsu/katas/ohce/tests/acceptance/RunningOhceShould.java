package com.dodevjutsu.katas.ohce.tests.acceptance;

import com.dodevjutsu.katas.ohce.Clock;
import com.dodevjutsu.katas.ohce.Console;
import com.dodevjutsu.katas.ohce.Ohce;
import com.dodevjutsu.katas.ohce.UserInput;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class RunningOhceShould {
    private Mockery context;
    private UserInput userInput;
    private Console console;
    private Clock clock;
    private Ohce ohce;

    @Before
    public void setUp() throws Exception {
        context = new Mockery();
        userInput = context.mock(UserInput.class);
        console = context.mock(Console.class);
        clock = context.mock(Clock.class);
    }

    @Test
    public void running_ohce_during_the_morning() {
        ohce = new Ohce("Pedro", console, userInput, clock);
        context.checking(new Expectations() {{
            oneOf(clock).hour();
            will(returnValue(8));
            atLeast(1).of(userInput).read();
            will(onConsecutiveCalls(
                returnValue("hola"),
                returnValue("oto"),
                returnValue("stop"),
                returnValue("Stop!")
            ));
            oneOf(console).print("¡Buenos días Pedro!");
            oneOf(console).print("aloh");
            oneOf(console).print("oto");
            oneOf(console).print("¡Bonita palabra!");
            oneOf(console).print("pots");
            oneOf(console).print("Adios Pedro");
        }});

        ohce.run();

        context.assertIsSatisfied();
    }

    @Test
    public void running_ohce_during_the_afternoon() {
        ohce = new Ohce("Ángel", console, userInput, clock);
        context.checking(new Expectations() {{
            oneOf(clock).hour();
            will(returnValue(16));
            atLeast(1).of(userInput).read();
            will(onConsecutiveCalls(
                returnValue("moko"),
                returnValue("ana"),
                returnValue("Stop!")
            ));
            oneOf(console).print("¡Buenas tardes Ángel!");
            oneOf(console).print("okom");
            oneOf(console).print("ana");
            oneOf(console).print("¡Bonita palabra!");
            oneOf(console).print("Adios Ángel");
        }});

        ohce.run();

        context.assertIsSatisfied();
    }

    @Test
    public void running_ohce_during_the_night() {
        ohce = new Ohce("Koko", console, userInput, clock);
        context.checking(new Expectations() {{
            oneOf(clock).hour();
            will(returnValue(22));
            atLeast(1).of(userInput).read();
            will(onConsecutiveCalls(
                returnValue("magento"),
                returnValue("salas"),
                returnValue("Stop!")
            ));
            oneOf(console).print("¡Buenas tardes Koko!");
            oneOf(console).print("otnegam");
            oneOf(console).print("salas");
            oneOf(console).print("¡Bonita palabra!");
            oneOf(console).print("Adios Koko");
        }});

        ohce.run();

        context.assertIsSatisfied();
    }
}
