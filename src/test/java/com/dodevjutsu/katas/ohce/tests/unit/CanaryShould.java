package com.dodevjutsu.katas.ohce.tests.unit;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CanaryShould {
    @Test
    public void fail() {
        assertThat(false, is(true));
    }
}
