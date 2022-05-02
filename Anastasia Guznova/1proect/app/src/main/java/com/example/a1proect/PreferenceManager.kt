package com.example.a1proect

import android.content.Context

class PreferenceManager(private val context: Context?) {

    companion object{
        private const val PREFERENCES_NAME = "entrance"
        private const val KEY_EMAIL = "email"
    }

    fun writeToPreferencesEmail(email: String) {
        val preferences = context?.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        preferences
            ?.edit()
            ?.putString(KEY_EMAIL, email)
            ?.apply()
    }

    fun readFromPreferenceEmail(): String {
        val preferences = context?.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        return preferences?.getString(KEY_EMAIL, null) ?: ""
    }

    fun clearPreference() {
        val preferences = context?.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        preferences
            ?.edit()
            ?.clear()
            ?.apply()
    }
}
