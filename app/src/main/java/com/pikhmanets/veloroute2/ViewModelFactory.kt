package com.pikhmanets.veloroute2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pikhmanets.veloroute2.ui.events.EventRepository
import com.pikhmanets.veloroute2.ui.events.EventViewModel

class ViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventViewModel::class.java)) {
            return EventViewModel(EventRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}