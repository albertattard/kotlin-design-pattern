package com.albertattard.examples.design

class Subtract(private val left: Expression, private val right: Expression) : Expression {

    override fun evaluate() =
            left.evaluate() - right.evaluate()

    override fun accept(visitor: ExpressionVisitor) {
        visitor.visit(left)
        visitor.binaryOperator("-")
        visitor.visit(right)
    }
}
