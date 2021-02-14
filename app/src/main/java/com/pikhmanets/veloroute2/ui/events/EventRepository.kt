package com.pikhmanets.veloroute2.ui.events

import android.app.Application
import com.pikhmanets.veloroute2.db.AppDatabase
import com.pikhmanets.veloroute2.ui.events.model.Event

class EventRepository(application: Application) {

    private val eventDao = AppDatabase.getInstance(application).eventDao

    suspend fun findAll(): List<Event>? {
        return eventDao.findAll()
    }
}