package com.example.quiz2

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz2.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var anagrams = mutableListOf<String>()
    var secondAnagram = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        save()
        output()
    }
    private fun save(){
        binding.btnSave.setOnClickListener {
            val anagram = binding.edEnterAnagram.text.toString()
            if (anagram.isNotEmpty()){
                anagrams.add(anagram)
                Toast.makeText(this, "Anagram added successfully", Toast.LENGTH_SHORT).show()
                binding.edEnterAnagram.text!!.clear()
                d("saba", "$anagrams")
            }else{
                Toast.makeText(this, "Enter Anagram", Toast.LENGTH_SHORT).show()
            }

        }
    }
    private fun output() {

        binding.btnOutput.setOnClickListener {

            anagrams.forEach { one ->

                anagrams.forEach { two ->

                    if (one.toSortedSet() == two.toSortedSet() && one !in secondAnagram){

                        if(!(one === two)){

                            secondAnagram.add(one)

                        }
                    }
                }
            }
            binding.tvAnagramsCount.text = "${secondAnagram.size}"
            d("saba", secondAnagram.toString())

        }
    }
}