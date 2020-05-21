package com.albertattard.examples.design

class Group(private val expression: Expression) : Expression {

    override fun evaluate() =
            expression.evaluate()

    override fun accept(visitor: ExpressionVisitor) {
        visitor.open()
        visitor.visit(expression)
        visitor.close()
    }
}
