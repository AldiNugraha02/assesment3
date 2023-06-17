package org.d3if0144.myapplication.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if0144.myapplication.databinding.FragmentResultBinding
import org.d3if0144.myapplication.db.Db
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    private val viewModel: ResultViewModel by lazy {
        val db = Db.getInstance(requireContext())
        val factory = ResultViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[ResultViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater,
            container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.data.observe(viewLifecycleOwner, {
            binding.bilangan.text = it.get(0).bil1.toString() + " " + it.get(0).aksi + " " + it.get(0).bil2.toString()
            binding.result.text = "Hasil: " + it.get(0).hasil.toString()
        })
    }



}