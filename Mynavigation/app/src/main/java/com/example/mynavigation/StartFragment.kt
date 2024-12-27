package com.example.mynavigation

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView

class StartFragment : Fragment(R.layout.fragment_start) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment = AddActivity()
        val sendDataIntent = requireView().findViewById<Button>(R.id.sendDataIntent)
        sendDataIntent.setOnClickListener {
            val imageUri: Uri = android.net.Uri.parse("/data/data/com.example.mynavigation/files/tiger.jpg")
            val bundle = Bundle().apply {
                putString("EXTRA_KEY", imageUri.toString())
                putString("EXTRA_KEY_TEXT", "Фото тигра")
            }
            fragment.arguments = bundle
            replaceFragment(fragment)
        }

        val getDataIntent = requireView().findViewById<Button>(R.id.getDataIntent)
        getDataIntent.setOnClickListener {
            val value = arguments?.getString("EXTRA_KEY_1")
            val resultIntent =  view.findViewById<TextView>(R.id.resultIntent)
            resultIntent.text = value
        }

        val bundle = Bundle()
        val user = DataClassUser("Екатерина","Колосова", 19, "06.09.2006")
        val sendDataSerializable = requireView().findViewById<Button>(R.id.sendDataSerializable)
        sendDataSerializable.setOnClickListener{
            bundle.putSerializable("EXTRA_KEY_USER", user)
            fragment.arguments = bundle
            replaceFragment(fragment)
        }

        val userq = DataClassUserParcelable("Екатерина", "Колосова", 16, "06.09.2006")
        val sendDataParcelable = requireView().findViewById<Button>(R.id.sendDataParcelable)
        sendDataParcelable.setOnClickListener {
            bundle.putParcelable("EXTRA_KEY_USER1", userq)
            fragment.arguments = bundle
            replaceFragment(fragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmet, fragment)
            .addToBackStack(null)
            .commit()
    }
}