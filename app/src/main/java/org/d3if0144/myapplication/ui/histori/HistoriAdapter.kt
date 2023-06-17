package org.d3if0144.myapplication.ui.histori
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0144.myapplication.databinding.ItemHistoriBinding
import org.d3if0144.myapplication.db.Entity
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter :
    ListAdapter<Entity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<Entity>() {
                override fun areItemsTheSame(
                    oldData: Entity, newData: Entity
                ): Boolean {
                    return oldData.id == newData.id
                }
                override fun areContentsTheSame(
                    oldData: Entity, newData: Entity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding

    ) : RecyclerView.ViewHolder(binding.root) {

        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: Entity) = with(binding) {
            val bilanganInput = item.bil1.toString() + " " + item.aksi + " " + item.bil2.toString()
            bilangan.text = bilanganInput
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            val hasilOutput = item.hasil.toString()
            hasil.text = hasilOutput
        }


    }
}