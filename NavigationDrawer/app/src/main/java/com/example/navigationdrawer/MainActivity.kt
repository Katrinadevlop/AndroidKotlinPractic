package com.example.navigationdrawer

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        drawerLayout = findViewById(R.id.main)
        val menuButton = findViewById<ImageView>(R.id.menuButton)

        menuButton.setOnClickListener{
            drawerLayout.open()
        }

        val navidationView = findViewById<NavigationView>(R.id.navigationView)
        navidationView.setNavigationItemSelectedListener {menuItem->
            when (menuItem.itemId) {
                R.id.Profile -> Toast.makeText(this@MainActivity, "Открылся профиль", Toast.LENGTH_SHORT).show()
                R.id.Home -> Toast.makeText(this, "Открылся главный экран", Toast.LENGTH_SHORT).show()
                R.id.Favorites -> Toast.makeText(this, "Открылись избранные", Toast.LENGTH_SHORT).show()
                R.id.Books -> Toast.makeText(this, "Открылись книги", Toast.LENGTH_SHORT).show()
                R.id.Shelves -> Toast.makeText(this, "Открылись полки", Toast.LENGTH_SHORT).show()
                R.id.Subscription -> Toast.makeText(this, "Открылись подписки", Toast.LENGTH_SHORT).show()
            }
            drawerLayout.close()
            true
        }
    }
}