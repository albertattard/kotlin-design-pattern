package com.albertattard.examples.design

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StringExpressionFormatterTest {

    @Test
    fun `should render a literal`() {
        val a = Literal(42)
        val result = StringExpressionFormatter.format(a)

        assertEquals("42", result)
    }

    @Test
    fun `should render a unary operator`() {
        val a = Literal(42)
        val operator = Negate(a)
        val result = StringExpressionFormatter.format(operator)

        assertEquals("-42", result)
    }

    @Test
    fun `should render a function operator`() {
        val a = Literal(-42)
        val operator = Abs(a)
        val result = StringExpressionFormatter.format(operator)

        assertEquals("abs(-42)", result)
    }

    @Test
    fun `should render the expression`() {
        /* 20 - (6 + 4) */
        val a = Literal(50)
        val b = Literal(6)
        val c = Literal(2)
        val add = Add(b, c)
        val group = Group(add)
        val subtract = Subtract(a, group)

        val result = StringExpressionFormatter.format(subtract)

        assertEquals("50 - (6 + 2)", result)
    }
}
