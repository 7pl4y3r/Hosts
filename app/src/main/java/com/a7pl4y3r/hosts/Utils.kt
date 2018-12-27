package com.a7pl4y3r.hosts

import android.content.Context
import android.widget.Toast

fun showMessage(context: Context, message: String, isLong: Boolean) {
    Toast.makeText(context, message, if (isLong) Toast.LENGTH_LONG else
        Toast.LENGTH_SHORT).show()
}