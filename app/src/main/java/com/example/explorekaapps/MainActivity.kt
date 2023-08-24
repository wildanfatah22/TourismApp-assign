package com.example.explorekaapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var rvWisata: RecyclerView
    private val list = ArrayList<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWisata = findViewById(R.id.rv_wisata)
        rvWisata.setHasFixedSize(true)

        list.addAll(getListWisata())
        showRecyclerList()

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.menu_home
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    menuItem.setIcon(R.drawable.bottom_nav_home_selector)
                    true
                }
                R.id.about_page -> {
                    val personName = getString(R.string.my_name)
                    val personEmail = getString(R.string.my_email)

                    val person = Person(personName, R.drawable.my_foto, personEmail)

                    menuItem.setIcon(R.drawable.bottom_nav_profile_selector)
                    startActivity(Intent(this, ProfileActivity::class.java).apply { putExtra(ProfileActivity.EXTRA_PERSON, person) })
                    true
                }
                else -> false
            }
        }
    }

    private fun getListWisata(): ArrayList<Wisata> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Wisata>()
        for (i in dataName.indices) {
            val hero = Wisata(dataName[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvWisata.layoutManager = LinearLayoutManager(this)
        val listWisataAdapter = ListWisataAdapter(list)
        rvWisata.adapter = listWisataAdapter
    }
}