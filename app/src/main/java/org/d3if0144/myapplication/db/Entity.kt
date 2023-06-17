package org.d3if0144.myapplication.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kalkulator")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var bil1: Float,
    var bil2: Float,
    var hasil: Float,
    var aksi: String
)