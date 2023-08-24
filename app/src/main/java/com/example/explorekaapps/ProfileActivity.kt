package com.example.explorekaapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

//    private lateinit var tvNama: TextView
//    private lateinit var tvEmail: TextView
//    private lateinit var ivProfile: ImageView
    private lateinit var bottomNavigationView: BottomNavigationView

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON)
        if (person != null) {
            displayProfileData(person)
        }


        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.about_page
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    menuItem.setIcon(R.drawable.bottom_nav_home_selector)
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.about_page -> {
                    menuItem.setIcon(R.drawable.bottom_nav_profile_selector)
                    true
                }
                else -> false
            }
        }
    }

    private fun displayProfileData(person: Person) {
        var tvNama: TextView = findViewById(R.id.text_name)
        var tvEmail: TextView = findViewById(R.id.text_email)
        var ivProfile: ImageView = findViewById(R.id.profile_image)

        // Set profile data to the UI elements
        tvNama.text = person.name
        tvEmail.text = person.email
        ivProfile.setImageResource(person.photo!!)
    }
}