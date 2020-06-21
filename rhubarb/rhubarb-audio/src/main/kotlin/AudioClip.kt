package com.rhubarb_lip_sync.rhubarb.audio

import kotlin.time.seconds

interface AudioClip {
    val sampleRate: Int
    val sampleCount: Int
    fun createAudioStreamAt(offset: Int): AudioStream
}

interface AutoCloseableAudioClip : AudioClip, AutoCloseable

fun AudioClip.createAudioStream() =
    createAudioStreamAt(0)

val AudioClip.duration
    get() = (sampleCount.toDouble() / sampleRate).seconds
