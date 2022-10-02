package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    lateinit var binding:ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getSerializableExtra("person") as Person

        binding.apply {
            imMain.setImageResource(person.imageId)
            tvTitle.text = person.title
            tvContent.text = person.desc
        }
    }
}