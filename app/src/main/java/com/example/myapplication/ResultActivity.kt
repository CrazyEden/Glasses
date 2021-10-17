package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private var gameWin:Boolean?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gameWin = intent.getBooleanExtra("res",false)
        if (gameWin!!){
            binding.imageResult.setImageResource(R.drawable.yes)
            binding.textResult.text=getString(R.string.game_Win)
        }
        else{
            binding.imageResult.setImageResource(R.drawable.no)
            binding.textResult.text=getString(R.string.game_over)
        }
        binding.button.setOnClickListener {
            finish()
        }

    }
}