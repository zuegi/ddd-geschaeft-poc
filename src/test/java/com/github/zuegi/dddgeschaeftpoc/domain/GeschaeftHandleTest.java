package com.github.zuegi.dddgeschaeftpoc.domain;

import org.junit.jupiter.api.Test;

import static com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftHandle.geschaeftHandle;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GeschaeftHandleTest {

    @Test
    void equals_GeschaeftHandlerWithSameValues_returnsTrue() {
        // arrange
        GeschaeftHandle geschaeftHandleOne = geschaeftHandle("peter");
        GeschaeftHandle geschaeftHandleTwo = geschaeftHandle("peter");

        // act + assert
        assertTrue(geschaeftHandleOne.equals(geschaeftHandleTwo));
        assertTrue(geschaeftHandleTwo.equals(geschaeftHandleOne));
    }
}
