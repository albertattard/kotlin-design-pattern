package com.albertattard.examples.design

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddTest {

    @Test
    internal fun `should return the sum of the given expressions`() {
        val a = Literal(20)
        val b = Literal(22)
        val add = Add(a, b)
        val result = add.evaluate()
        assertEquals(42, result)
    }
}
