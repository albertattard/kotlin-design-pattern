package com.albertattard.examples.design

import java.util.Stack

object TreeExpressionVisitor {

    private class InternalVisitor() : ExpressionVisitor {

        private var root: MutableTreeNode? = null
        private val stack = Stack<MutableTreeNode>()

        override fun value(value: Long) {
            stack.peek()?.caption = "$value"
        }

        override fun unaryOperator(symbol: String) {
            stack.peek()?.caption = symbol
        }

        override fun binaryOperator(symbol: String) {
            stack.peek()?.caption = symbol
        }

        override fun function(name: String) {
            stack.peek()?.caption = "${name}()"
        }

        override fun open() {}

        override fun close() {}

        override fun visit(expression: Expression) {
            val child = MutableTreeNode()

            if (stack.isEmpty()) {
                root = child
            } else {
                stack.peek().children.add(child)
            }

            stack.push(child)
            expression.accept(this)
            stack.pop()
        }

        /**
         * @throws IllegalStateException if the tree is not yet rendered.  The [asTreeNode] function needs to be called before
         *  invoking this method, otherwise an [IllegalStateException] is thrown
         */
        @Throws(IllegalStateException::class)
        fun asTreeNode(): MutableTreeNode =
            root ?: throw IllegalStateException("Tree root was not yet rendered")
    }

    fun asTreeNode(expression: Expression) =
        InternalVisitor().apply {
            visit(expression)
        }.asTreeNode()
}
