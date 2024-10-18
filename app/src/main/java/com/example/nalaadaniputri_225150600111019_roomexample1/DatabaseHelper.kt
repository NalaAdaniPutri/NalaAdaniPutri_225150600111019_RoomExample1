package com.example.nalaadaniputri_225150600111019_roomexample1.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "itemDB"
        private const val DATABASE_VERSION = 1
        private const val TABLE_ITEMS = "items"
        private const val COLUMN_ITEM = "item"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_ITEMS ($COLUMN_ITEM TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_ITEMS")
        onCreate(db)
    }

    fun addItem(item: String) {
        val db = writableDatabase
        db.execSQL("INSERT INTO $TABLE_ITEMS ($COLUMN_ITEM) VALUES ('$item')")
        db.close()
    }
}
