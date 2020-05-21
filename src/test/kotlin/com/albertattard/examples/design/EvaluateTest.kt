package com.albertattard.examples.design

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EvaluateTest {

    @Test
    fun `should evaluate the expression`() {
        /* 20 - (6 + 4) */
        val a = Literal(20)
        val b = Literal(6)
        val c = Literal(4)
        val add = Add(b, c)
        val group = Group(add)
        val subtract = Subtract(a, group)

        assertEquals(10, subtract.evaluate())
    }
}
