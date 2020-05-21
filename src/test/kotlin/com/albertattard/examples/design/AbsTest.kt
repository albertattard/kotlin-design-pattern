package com.albertattard.examples.design

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AbsTest {

    @Test
    fun `should return the absolute value`() {
        val a = Literal(-42)
        val abs = Abs(a)
        val result = abs.evaluate()

        assertEquals(42, result)
    }
}
