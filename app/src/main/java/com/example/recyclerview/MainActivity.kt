package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter = PersonAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null


    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                adapter.addPerson(it.data?.getSerializableExtra("person") as Person)
            }
        }
    }

    private fun init() = with(binding){
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        rcView.adapter = adapter
        buttonAdd.setOnClickListener{
            editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
        }
    }
}