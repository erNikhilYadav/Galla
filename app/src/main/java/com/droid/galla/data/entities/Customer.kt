package com.droid.galla.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customer(
    @PrimaryKey(autoGenerate = false)
    val customerName: String
)