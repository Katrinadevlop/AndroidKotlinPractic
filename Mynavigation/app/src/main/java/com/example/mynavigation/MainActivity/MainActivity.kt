package com.example.mynavigation.MainActivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mynavigation.DataClass.DataClassUser
import com.example.mynavigation.R
import com.example.mynavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            sendDataIntent.setOnClickListener{
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                val imageUri: Uri = Uri.parse("/data/data/com.example.mynavigation/files/tiger.jpg")
                intent.putExtra("EXTRA_KEY", imageUri.toString())
                intent.putExtra("EXTRA_KEY_TEXT", "Фото тигра")
                startActivity(intent)
                Toast.makeText(this@MainActivity, "Данные отправлены", Toast.LENGTH_SHORT).show()
            }

            getDataIntent.setOnClickListener{
                binding.resultIntent.text = intent.getStringExtra("EXTRA_KEY_1").toString()
            }

            val user = DataClassUser("Екатерина","Колосова", 19, "06.09.2006")
            sendDataSerializable.setOnClickListener{
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra("EXTRA_KEY_USER", user)
                startActivity(intent)
            }

            sendDataParcelable.setOnClickListener{
                val userq = DataClassUser("Екатерина", "Колосова", 16, "06.09.2006")
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra("EXTRA_KEY_USER1", userq)
                startActivity(intent)
            }
        }
    }
}