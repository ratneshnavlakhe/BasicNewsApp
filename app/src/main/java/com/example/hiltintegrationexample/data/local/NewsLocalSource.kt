package com.example.hiltintegrationexample.data.local

interface NewsLocalSource {
    fun getNewsLocale(): String
    fun saveNewsLocale(locale: String)
}