package com.example.shiftTutorial.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.shiftTutorial.R
import com.example.shiftTutorial.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var viewModel: SplashViewModel
    private lateinit var binding: FragmentSplashBinding

    companion object {
        fun newInstance() = SplashFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_splash, container, false)
        return binding.root
    }

    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.ivKobilLogo.alpha = 0F
        binding.ivKobilLogo.animate().setDuration(1500).alpha(1F).withEndAction{
            viewModel.launchApplication()
        }
    }


}