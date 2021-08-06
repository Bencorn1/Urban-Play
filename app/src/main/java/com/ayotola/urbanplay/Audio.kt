package com.ayotola.urbanplay

import java.io.Serializable

open class Audio : Serializable {
    private lateinit var data: String
    private lateinit var title: String
    private lateinit var album: String
    private lateinit var artist: String

    fun Audio(data: String, title: String, album: String, artist: String) {
        this.data = data
        this.title = title
        this.album = album
        this.artist = artist
    }

    fun getData(): String {
        return data
    }

    fun setData(data: String) {
        this.data = data
    }

    fun getTitle(): String {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getAlbum(): String {
        return album
    }

    fun setAlbum(album: String) {
        this.album = album
    }

    fun getArtist(): String {
        return artist
    }

    fun setArtist(artist: String) {
        this.artist = artist
    }
}