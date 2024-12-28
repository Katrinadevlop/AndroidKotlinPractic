package com.example.navigationdrawer

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val drawerLayout = findViewById<DrawerLayout>(R.id.main)
        val menuButton = findViewById<ImageView>(R.id.menuButton)

        menuButton.setOnClickListener{
            drawerLayout.open()
        }

        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val controller = fragment.navController
        val navidationView = findViewById<NavigationView>(R.id.navigationView)
        navidationView.setNavigationItemSelectedListener {menuItem->
            when (menuItem.itemId) {
                R.id.Profile -> controller.navigate(R.id.profileFragment)
                R.id.Home ->  controller.navigate(R.id.homeFragment)
                R.id.Favorites ->  controller.navigate(R.id.favoritesFragment)
                R.id.Books ->  controller.navigate(R.id.booksFragment)
                R.id.Shelves ->  controller.navigate(R.id.shelvesFragment)
                R.id.Subscription ->  controller.navigate(R.id.subscriptionFragment)
            }
            drawerLayout.close()
            true
        }
    }
}