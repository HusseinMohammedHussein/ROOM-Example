package com.husseinmohammed.applyroom.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.husseinmohammed.applyroom.data.api.ApiClient
import com.husseinmohammed.applyroom.data.api.ApiHelperImpl
import com.husseinmohammed.applyroom.data.local.AppDatabase
import com.husseinmohammed.applyroom.data.local.DbHelperImpl
import com.husseinmohammed.applyroom.databinding.ActivityCharRoomBinding
import com.husseinmohammed.applyroom.ui.adapters.CharAdapter
import com.husseinmohammed.applyroom.utils.Status
import com.husseinmohammed.applyroom.utils.ViewModelFactory

class CharRoomActivity : AppCompatActivity() {
    private var _binding: ActivityCharRoomBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharactersRoomViewModel
    private lateinit var charAdapter: CharAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCharRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        methods()

    }

    private fun methods() {
        setupViewModel()
        initViews()
        getData()
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProviders.of(
                this,
                ViewModelFactory(
                    ApiHelperImpl(ApiClient.apiServer),
                    DbHelperImpl(AppDatabase.getInstance(applicationContext))
                )
            ).get(CharactersRoomViewModel::class.java)
    }

    private fun initViews() {
        charAdapter = CharAdapter(this)
        binding.rvChars.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@CharRoomActivity, LinearLayoutManager.VERTICAL, false)
            adapter = charAdapter
        }
    }

    private fun getData() {
        viewModel.getChars().observe(this) { char ->
            when (char.status) {
                Status.LOADING -> {
                    binding.rvChars.visibility = View.GONE
                }
                Status.SUCCESS -> {
                    binding.rvChars.visibility = View.VISIBLE
                    char.data?.let { charAdapter.addData(it) }
                }
                Status.ERROR -> {
                    binding.rvChars.visibility = View.GONE
                    Toast.makeText(this, "${char.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}