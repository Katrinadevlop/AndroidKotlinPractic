package com.example.mynavigation

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.emptyLongSet
import com.example.mynavigation.databinding.ActivityMain2Binding

@Suppress("INFERRED_TYPE_VARIABLE_INTO_POSSIBLE_EMPTY_INTERSECTION")
class MainActivity2 : AppCompatActivity() {

    private lateinit var binding:ActivityMain2Binding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            sendDataIntent.setOnClickListener {
                val intent = Intent(this@MainActivity2, MainActivity::class.java)
                intent.putExtra("EXTRA_KEY_1", "Меня зовут Катя")
                startActivity(intent)
                Toast.makeText(this@MainActivity2, "Данные отправлены", Toast.LENGTH_SHORT).show()
            }

            getDataIntent.setOnClickListener {
                val imageUri = intent.getStringExtra("EXTRA_KEY")
                resultIntent.text = intent.getStringExtra("EXTRA_KEY_TEXT")
                val uri = Uri.parse(imageUri)
                imageView.setImageURI(uri)
            }

            getDataSerializable.setOnClickListener{
                val user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                    intent.getSerializableExtra("EXTRA_KEY_USER", DataClassUser::class.java) as DataClassUser
                else intent.getSerializableExtra("EXTRA_KEY_USER") as DataClassUser

                resultSerializable.text = "Имя: ${user.name}, Surname: ${user.surname}, Возраст: ${user.age}, Birthday: ${user.birthday}"
            }

            getDataParcelable.setOnClickListener{
                val user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                    intent.getParcelableExtra("EXTRA_KEY_USER1", DataClassUserParcelable::class.java)
                else intent.getParcelableExtra("EXTRA_KEY_USER1")

                resultParcelable.text = "Имя: ${user?.name}, Surname: ${user?.surname}, Birthday: ${user?.birthday}"
            }
        }
    }
}