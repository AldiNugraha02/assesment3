package org.d3if0144.myapplication.ui.result

import androidx.lifecycle.ViewModel
import org.d3if0144.myapplication.db.Dao

class ResultViewModel(private val db: Dao): ViewModel() {
    val data = db.getLastData()
}