package com.husseinmohammed.applyroom.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.husseinmohammed.applyroom.data.api.ApiClient
import com.husseinmohammed.applyroom.data.api.ApiHelperImpl
import com.husseinmohammed.applyroom.data.local.AppDatabase
import com.husseinmohammed.applyroom.data.local.DbHelperImpl
import com.husseinmohammed.applyroom.databinding.FragmentCharactersRoomBinding
import com.husseinmohammed.applyroom.ui.adapters.CharAdapter
import com.husseinmohammed.applyroom.utils.Status
import com.husseinmohammed.applyroom.utils.ViewModelFactory

class CharactersRoomFragment : Fragment() {
    private var _binding: FragmentCharactersRoomBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharactersRoomViewModel
    private lateinit var charAdapter: CharAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(
                this,
                ViewModelFactory(
                    ApiHelperImpl(ApiClient.apiServer),
                    DbHelperImpl(AppDatabase.getInstance(requireContext()))
                )
            ).get(CharactersRoomViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersRoomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        methods()
    }

    private fun methods() {
        initViews()
        getData()
    }

    private fun initViews() {
        charAdapter = CharAdapter(requireContext())
        binding.rvChars.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = charAdapter
        }
    }

    private fun getData() {
        viewModel.getChars().observe(viewLifecycleOwner) { char ->
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
                    Toast.makeText(requireContext(), "${char.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}