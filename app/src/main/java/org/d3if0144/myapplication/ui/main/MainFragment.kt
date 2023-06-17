package org.d3if0144.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.d3if0144.myapplication.R
import org.d3if0144.myapplication.databinding.FragmentMainBinding
import org.d3if0144.myapplication.db.Db

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by lazy {
        val db = Db.getInstance(requireContext())
        val factory = MainViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(
                    R.id.action_mainFragment_to_historiFragment
                )
                return true
            }
            R.id.menu_about -> {
                findNavController().navigate(
                    R.id.action_mainFragment_to_aboutFragment
                )
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(layoutInflater,
            container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tambah.setOnClickListener {
            tambah()
            findNavController().navigate(
                R.id.action_mainFragment_to_resultFragment
            )
        }

        binding.kurang.setOnClickListener {
            kurang()
            findNavController().navigate(
                R.id.action_mainFragment_to_resultFragment
            )
        }

        binding.kali.setOnClickListener {
            kali()
            findNavController().navigate(
                R.id.action_mainFragment_to_resultFragment
            )
        }

        binding.bagi.setOnClickListener {
            bagi()
            findNavController().navigate(
                R.id.action_mainFragment_to_resultFragment
            )
        }

        binding.pangkat.setOnClickListener {
            pangkat()
            findNavController().navigate(
                R.id.action_mainFragment_to_resultFragment
            )
        }
    }

    fun tambah()
    {
        val data1 = binding.bi1EditText.text.toString()
        val data2 = binding.bil2EditText.text.toString()
        viewModel.tambah(
            data1.toFloat(),
            data2.toFloat()
        )
    }

    fun kurang()
    {
        val data1 = binding.bi1EditText.text.toString()
        val data2 = binding.bil2EditText.text.toString()
        viewModel.kurang(
            data1.toFloat(),
            data2.toFloat()
        )
    }

    fun kali()
    {
        val data1 = binding.bi1EditText.text.toString()
        val data2 = binding.bil2EditText.text.toString()
        viewModel.kali(
            data1.toFloat(),
            data2.toFloat()
        )
    }

    fun bagi()
    {
        val data1 = binding.bi1EditText.text.toString()
        val data2 = binding.bil2EditText.text.toString()
        viewModel.bagi(
            data1.toFloat(),
            data2.toFloat()
        )
    }

    fun pangkat()
    {
        val data1 = binding.bi1EditText.text.toString()
        val data2 = binding.bil2EditText.text.toString()
        viewModel.pangkat(
            data1.toFloat(),
            data2.toFloat()
        )
    }


}