package com.droid.galla.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.droid.galla.data.dao.CustomerDao
import com.droid.galla.data.entities.Customer

@Database(
    entities = [
        Customer::class
    ], version = 1
)
abstract class MainDatabase : RoomDatabase() {
    abstract val customerDao: CustomerDao
}