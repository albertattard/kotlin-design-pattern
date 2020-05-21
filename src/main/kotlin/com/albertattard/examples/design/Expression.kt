package com.albertattard.examples.design

interface Expression {

    fun evaluate(): Long

    fun accept(visitor: ExpressionVisitor)
}
