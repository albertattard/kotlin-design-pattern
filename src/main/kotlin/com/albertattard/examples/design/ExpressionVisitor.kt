package com.albertattard.examples.design

interface ExpressionVisitor {

    fun value(value: Long)

    fun unaryOperator(symbol: String)

    fun binaryOperator(symbol: String)

    fun function(name: String)

    fun open()

    fun close()

    fun visit(expression: Expression)
}
