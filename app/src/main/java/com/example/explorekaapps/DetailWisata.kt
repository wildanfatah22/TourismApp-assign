package com.example.explorekaapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView


class DetailWisata : AppCompatActivity() {
    private lateinit var tv_touristSpotName: TextView
    private lateinit var tv_touristLocation: TextView
    private lateinit var tv_touristDescription: TextView
    private lateinit var iv_detail_wisata: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)

        // Initialize the views
        tv_touristSpotName = findViewById(R.id.tv_touristSpotName)
        tv_touristLocation = findViewById(R.id.tv_touristLocation)
        tv_touristDescription = findViewById(R.id.tv_touristDescription)
        iv_detail_wisata = findViewById(R.id.iv_detail_wisata)

        val intent = intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val location = intent.getStringExtra("location")
            val description = intent.getStringExtra("description")
            val photo = intent.getIntExtra("photo", R.drawable.ic_baseline_image_24)

            tv_touristSpotName.text = name
            tv_touristLocation.text = location
            tv_touristDescription.text = description
            iv_detail_wisata.setImageResource(photo)
        }
    }

    fun backToMainActivity(view: View) {
        onBackPressed() // Memanggil fungsi kembali seperti saat menekan tombol fisik "Back"
    }
}