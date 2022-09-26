package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.person_1

    private val imageIdList = listOf(
        R.drawable.person_1,
        R.drawable.person_2,
        R.drawable.person_3,
        R.drawable.person_4,)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
    }

    private fun initButton() = with(binding){
        bNext.setOnClickListener{
            indexImage++
            if(indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener{
            val person = Person(imageId, edTitle.text.toString(), edDesc.text.toString())
            val editIntent = Intent().apply {
                putExtra("person", person)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}