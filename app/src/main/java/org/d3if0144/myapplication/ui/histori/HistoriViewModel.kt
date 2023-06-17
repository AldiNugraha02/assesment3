package org.d3if0144.myapplication.ui.histori
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0144.myapplication.db.Dao

class HistoriViewModel(private val db: Dao) : ViewModel() {
    val data = db.getData()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}