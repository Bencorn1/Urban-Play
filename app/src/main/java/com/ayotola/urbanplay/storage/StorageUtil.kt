package com.ayotola.urbanplay.storage

import android.content.Context
import android.content.SharedPreferences
import com.ayotola.urbanplay.Audio
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class StorageUtil {

    private val STORAGE = " com.ayotola.urbanplay.STORAGE"
    private lateinit var preferences: SharedPreferences
    private lateinit var context: Context

    fun StorageUtil(context: Context) {
        this.context = context
    }

    fun storeAudio(arrayList: java.util.ArrayList<Audio>) {
        preferences = context.getSharedPreferences(STORAGE, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        val gson = Gson()
        val json = gson.toJson(arrayList)
        editor.putString("audioArrayList", json)
        editor.apply()
    }

    fun loadAudio(): ArrayList<Audio> {
        preferences = context.getSharedPreferences(STORAGE, Context.MODE_PRIVATE)
        val gson = Gson()
        val json = preferences.getString("audioArrayList", null)
        val type: Type = object : TypeToken<ArrayList<Audio?>?>() {}.type
        return gson.fromJson(json, type)
    }

    fun storeAudioIndex(index: Int) {
        preferences = context.getSharedPreferences(STORAGE, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putInt("audioIndex", index)
        editor.apply()
    }

    fun loadAudioIndex(): Int {
        preferences = context.getSharedPreferences(STORAGE, Context.MODE_PRIVATE)
        return preferences.getInt("audioIndex", -1) //return -1 if no data found
    }

    fun clearCachedAudioPlaylist() {
        preferences = context.getSharedPreferences(STORAGE, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
        editor.commit()
    }

}
