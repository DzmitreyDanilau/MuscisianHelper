package com.musicianhelper.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.musicianhelper.MusicianHelperApp
import com.musicianhelper.R
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }
}
