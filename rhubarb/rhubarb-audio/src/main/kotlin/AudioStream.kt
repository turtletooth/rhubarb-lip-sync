package com.rhubarb_lip_sync.rhubarb.audio

interface AudioStream {
    var offset: Int
    fun readSamples(sampleCount: Int): SampleBuffer
    fun readSamples(sampleCount: Int, target: NativePointer): Int
}
