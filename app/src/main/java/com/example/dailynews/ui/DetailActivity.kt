package com.example.dailynews.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.dailynews.R
import com.example.dailynews.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val photoId = intent.getIntExtra("PHOTO_ID", 0)
        val photoTitle = intent.getStringExtra("PHOTO_TITLE") ?: ""
        val photoURL = intent.getStringExtra("PHOTO_URL") ?: ""
        val photoThumbnilURL = intent.getStringExtra("PHOTO_THUMBNAIL") ?: ""

        binding.textTitle.text = photoTitle
        binding.textId.text = photoId.toString()
        Glide.with(this)
            .load(photoURL)
            .into(binding.imageFullSize)
        Glide.with(this)
            .load(photoThumbnilURL)
            .into(binding.imageThumbnail)
    }

}