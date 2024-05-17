package com.example.shiftTutorial.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shiftTutorial.R
import com.example.shiftTutorial.databinding.FragmentStartBinding

// the
class StartFragment : Fragment() {
    private lateinit var viewModel: StartViewModel
    private lateinit var binding: FragmentStartBinding

    companion object {
        fun newInstance() = StartFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        // binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

}