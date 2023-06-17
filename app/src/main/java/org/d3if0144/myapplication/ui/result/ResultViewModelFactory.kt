package org.d3if0144.myapplication.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0144.myapplication.db.Dao
import org.d3if0144.myapplication.ui.main.MainViewModel

class ResultViewModelFactory (
    private val db: Dao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {
            return ResultViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}