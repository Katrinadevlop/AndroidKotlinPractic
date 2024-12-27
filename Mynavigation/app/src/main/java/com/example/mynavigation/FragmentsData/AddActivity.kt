package com.example.mynavigation.FragmentsData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.mynavigation.DataClass.DataClassUser
import com.example.mynavigation.DataClass.DataClassUserParcelable
import com.example.mynavigation.R

class AddActivity : Fragment(R.layout.fragment_add_activity) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment = StartFragment()
        val sendDataIntent = requireView().findViewById<Button>(R.id.sendDataIntent)
        sendDataIntent.setOnClickListener {
            val bundle = Bundle().apply {
                putString("EXTRA_KEY_1", "Меня зовут Катя")
            }
            fragment.arguments = bundle
            replaceFragment(fragment)
        }

        val getDataIntent = requireView().findViewById<Button>(R.id.getDataIntent)
        getDataIntent.setOnClickListener {
            val imageUri = arguments?.getString("EXTRA_KEY")
            val resultIntent = view.findViewById<TextView>(R.id.resultIntent)
            resultIntent.text =arguments?.getString("EXTRA_KEY_TEXT")
            val uri = android.net.Uri.parse(imageUri)
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            imageView.setImageURI(uri)
        }

        val getDataSerializable = requireView().findViewById<Button>(R.id.getDataSerializable)
        getDataSerializable.setOnClickListener {
            val user= if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU)
                arguments?.getSerializable("EXTRA_KEY_USER", DataClassUser::class.java) as DataClassUser
            else arguments?.getSerializable("EXTRA_KEY_USER") as? DataClassUser

            val resultSerializable = view.findViewById<TextView>(R.id.resultSerializable)
            resultSerializable.text = "Имя: ${user?.name}, Surname: ${user?.surname}, Возраст: ${user?.age}, Birthday: ${user?.birthday}"
        }

        val getDataParcelable = requireView().findViewById<Button>(R.id.getDataParcelable)
        getDataParcelable.setOnClickListener {
            val user = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU)
                arguments?.getParcelable("EXTRA_KEY_USER1", DataClassUserParcelable::class.java)
            else arguments?.getParcelable("EXTRA_KEY_USER1")

            val resultParcelable = view.findViewById<TextView>(R.id.resultParcelable)
            resultParcelable.text = "Имя: ${user?.name}, Surname: ${user?.surname}, Birthday: ${user?.birthday}"
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmet, fragment)
            .addToBackStack(null)
            .commit()
    }
}