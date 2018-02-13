package com.catalog;

import com.catalog.model.Client;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertMatchArrayClientTest {

    public static void assertMatch(Iterable<Client> actual, Client... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Client> actual, Iterable<Client> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}
