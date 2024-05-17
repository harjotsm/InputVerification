package com.example.shiftTutorial.activation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.shiftTutorial.R
import com.example.shiftTutorial.databinding.FragmentActivationBinding
import com.example.shiftTutorial.splash.SplashViewModel

class ActivationFragment : Fragment() {

    private lateinit var binding : FragmentActivationBinding
    private lateinit var viewModel: ActivationViewModel

    companion object {
        fun newInstance() = ActivationFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_activation, container, false)
       return binding.root
    }

    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        viewModel = ViewModelProvider(this)[ActivationViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

}