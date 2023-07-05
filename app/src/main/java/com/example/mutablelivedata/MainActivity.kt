package com.example.mutablelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mutablelivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
     lateinit var viewModel: MainActivityViewModel
     lateinit var viewModelFactory: ViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModelFactory = ViewModelFactory(124)
        viewModel = ViewModelProvider(this,viewModelFactory)[MainActivityViewModel::class.java]
        viewModel.total.observe(this, Observer {
            binding.textView.text = it.toString()
        })

        binding.click.setOnClickListener {
            viewModel.setTotal(binding.editText.text.toString().toInt())
        }

    }
}