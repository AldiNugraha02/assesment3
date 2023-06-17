package org.d3if0144.myapplication.ui.about

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import org.d3if0144.myapplication.databinding.FragmentAboutBinding
import org.d3if0144.myapplication.network.ApiStatus

class AboutFragment: Fragment()  {
    private lateinit var binding: FragmentAboutBinding
    private val viewModel: AboutViewModel by lazy {
        ViewModelProvider(this)[AboutViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(layoutInflater,
            container, false)

        val imageView = binding.imageView
        Glide.with(this).load("https://raw.githubusercontent.com/AldiNugraha02/Asessmen2-Mobpro/master/kalkulator.jpg").into(imageView)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.copyright.observe(viewLifecycleOwner, Observer {
            // updating data in displayMsg
            binding.copyright.text = it
        })

        viewModel.status.observe(viewLifecycleOwner, {
            updateProgress(it)
        })

    }

    private fun updateProgress(status: ApiStatus) {
        when (status) {
            ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
                binding.copyright.visibility = View.GONE
            }
            ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
                binding.copyright.visibility = View.VISIBLE
                binding.imageView.visibility = View.VISIBLE
                binding.networkError.visibility = View.GONE
            }
            ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }


}