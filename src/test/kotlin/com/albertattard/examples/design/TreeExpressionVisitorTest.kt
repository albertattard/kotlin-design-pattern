package com.albertattard.examples.design

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TreeExpressionVisitorTest {

    private fun node(a: Any) =
        when (a) {
            is MutableTreeNode -> a
            is String -> MutableTreeNode(a)
            else -> throw IllegalArgumentException("Unexpected type ${a.javaClass}")
        }

    private fun node(caption: String, vararg children: Any) =
        MutableTreeNode(caption, children.map { node(it) }.toMutableList())

    @Test
    fun `should render the literal as a single tree node`() {
        val a = Literal(42)

        val rendered = TreeExpressionVisitor.asTreeNode(a)
        assertEquals(node("42"), rendered)
    }

    @Test
    fun `should render the unary operator as a tree node with one child`() {
        val a = Literal(42)
        val operator = Negate(a)

        val rendered = TreeExpressionVisitor.asTreeNode(operator)
        assertEquals(node("-", "42"), rendered)
    }

    @Test
    fun `should render the function operator as a tree node with one child`() {
        val a = Literal(-42)
        val operator = Abs(a)

        val rendered = TreeExpressionVisitor.asTreeNode(operator)
        assertEquals(node("abs()", "-42"), rendered)
    }

    @Test
    fun `should render the binary operator as a tree node with two children`() {
        val a = Literal(20)
        val b = Literal(22)
        val operator = Add(a, b)

        val rendered = TreeExpressionVisitor.asTreeNode(operator)
        assertEquals(node("+", "20", "22"), rendered)
    }

    @Test
    fun `should render nested binary operators as a tree node`() {
        val a = Literal(2)
        val b = Literal(6)
        val c = Literal(50)
        val add = Add(a, b)
        val subtract = Subtract(c, add)

        val rendered = TreeExpressionVisitor.asTreeNode(subtract)
        assertEquals(node("-", "50", node("+", "2", "6")), rendered)
    }
}
