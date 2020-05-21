package com.albertattard.examples.design

object StringExpressionFormatter {

    private class InternalVisitor : ExpressionVisitor {

        private val builder = StringBuilder()

        override fun value(value: Long) {
            builder.append(value)
        }

        override fun unaryOperator(symbol: String) {
            builder.append("$symbol")
        }

        override fun binaryOperator(symbol: String) {
            builder.append(" $symbol ")
        }

        override fun function(name: String) {
            builder.append(name)
        }

        override fun open() {
            builder.append("(")
        }

        override fun close() {
            builder.append(")")
        }

        override fun visit(expression: Expression) =
            expression.accept(this)

        fun asString() =
            builder.toString()
    }

    fun format(expression: Expression) =
        InternalVisitor().apply {
            visit(expression)
        }.asString()
}
