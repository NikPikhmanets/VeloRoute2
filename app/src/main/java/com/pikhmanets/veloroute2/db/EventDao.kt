package com.pikhmanets.veloroute2.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pikhmanets.veloroute2.ui.events.model.Event

@Dao
interface EventDao {

    @Insert
    suspend fun insert(event: Event)

    @Insert
    suspend fun insert(events: List<Event>)

    @Query("SELECT * FROM events ORDER BY created_at DESC")
    fun findAll(): List<Event>
}