package com.pikhmanets.veloroute2.ui.events.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.time.LocalTime

@Entity(tableName = "events")
data class Event(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var type: String,
    var title: String,
    @ColumnInfo(name = "sample_track_id")
    var sampleTrackId: Int,
    @ColumnInfo(name = "time_start")
    var timeStart: LocalDateTime,
    @ColumnInfo(name = "time_limit")
    var timeLimit: LocalTime,
    var distance: Int,
    var content: String,
    @ColumnInfo(name = "created_at")
    var createdAt: LocalDateTime,
    @ColumnInfo(name = "edited_at")
    var editedAt: LocalDateTime
)
