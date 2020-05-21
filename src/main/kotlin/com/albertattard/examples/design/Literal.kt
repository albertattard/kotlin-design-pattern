package com.albertattard.examples.design

class Literal(private val value: Long) : Expression {

    override fun evaluate() =
            value

    override fun accept(visitor: ExpressionVisitor) =
            visitor.value(value)

}
