package com.albertattard.examples.design

class Negate(private val expression: Expression) : Expression {
    override fun evaluate() =
        -expression.evaluate()

    override fun accept(visitor: ExpressionVisitor) {
        visitor.unaryOperator("-")
        visitor.visit(expression)
    }
}
