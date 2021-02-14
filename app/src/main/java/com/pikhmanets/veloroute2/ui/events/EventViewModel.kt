package com.pikhmanets.veloroute2.ui.events

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pikhmanets.veloroute2.ui.events.model.Event
import kotlinx.coroutines.launch

class EventViewModel(
    private val repository: EventRepository,
    application: Application
) : AndroidViewModel(application) {

    private var events = MutableLiveData<List<Event>>()

    public fun getEvents() {
        viewModelScope.launch {
            val list = repository.findAll()
            events.value = list!!
        }
    }

    fun getRemoteEvents() {
        TODO("Not yet implemented")
    }
}