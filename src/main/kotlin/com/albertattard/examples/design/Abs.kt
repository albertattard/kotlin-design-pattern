package com.albertattard.examples.design

import kotlin.math.abs

class Abs(private val expression: Expression) : Expression {

    override fun evaluate() =
        abs(expression.evaluate())

    override fun accept(visitor: ExpressionVisitor) {
        visitor.function("abs")
        visitor.open()
        visitor.visit(expression)
        visitor.close()
    }
}
