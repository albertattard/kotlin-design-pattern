package com.albertattard.examples.design

data class MutableTreeNode(
    var caption: String = "",
    val children: MutableList<MutableTreeNode> = mutableListOf<MutableTreeNode>()
)
