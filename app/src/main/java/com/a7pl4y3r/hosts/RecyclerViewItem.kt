package com.a7pl4y3r.hosts


class RecyclerViewItem(
    private val title: Int,
    private val description: Int,
    private val actionName: Int) {

    fun mTitle(): String = title.toString()
    fun mDescription(): String = description.toString()
    fun mActionName(): String = actionName.toString()
}