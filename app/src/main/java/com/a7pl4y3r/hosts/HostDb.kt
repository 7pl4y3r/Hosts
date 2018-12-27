package com.a7pl4y3r.hosts

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private const val dbName = "HostDb"
private const val tableName = "HostTable"
private const val col0 = "ID"
private const val col1 = "Name"
private const val col2 = "Password"

class HostDb(context: Context) : SQLiteOpenHelper(context, dbName, 1, null) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $tableName ($col0 INTEGER PRIMARY KEY AUTOINCREMENT, $col1 TEXT, $col2 TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $tableName")
        onCreate(db)
    }

    fun insertHost(name: String, password: String): Boolean {

        val cv = ContentValues()
        cv.put(col1, name)
        cv.put(col2,password)

        return this.writableDatabase.insert(tableName, null, cv) != -1L
    }

    fun readData() = this.writableDatabase.rawQuery("select * from $tableName", null)

    fun updateHost(id: String, name: String, password: String) {

        val cv = ContentValues()
        cv.put(col1, name)
        cv.put(col2, password)

        this.writableDatabase.update(tableName, cv, "ID = ?", arrayOf(id))
    }

    fun deleteHost(id: String): Int? = this.writableDatabase.delete(tableName, "ID = ?", arrayOf(id))

}