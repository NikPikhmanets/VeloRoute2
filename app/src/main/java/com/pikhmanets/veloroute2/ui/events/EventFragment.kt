package com.pikhmanets.veloroute2.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pikhmanets.veloroute2.ViewModelFactory
import com.pikhmanets.veloroute2.databinding.FragmentEventBinding

class EventFragment : Fragment() {

    private var binding: FragmentEventBinding? = null

    private lateinit var eventViewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventBinding.inflate(inflater, container, false)

        eventViewModel = ViewModelProvider(this, ViewModelFactory()).get(EventViewModel::class.java)
//        eventViewModel.getRemoteEvents().Observer()
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}