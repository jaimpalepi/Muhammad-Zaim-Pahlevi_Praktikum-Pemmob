package com.example.ifunsoedmobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifunsoedmobile.databinding.ActivityDaftarBukuBinding
import com.example.ifunsoedmobile.ui.adapter.BookAdapter
import com.example.ifunsoedmobile.viewmodel.MainViewModel

class DaftarBukuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = BookAdapter(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter

        viewModel.books.observe(this){
            adapter.setData(it)
        }
        viewModel.fetchBooks("kotlin programming")
    }
}