package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var opt:MainActivity.Option
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSettings()
        onClickListeners()
    }
    private fun getSettings(){
        opt=intent.extras?.get("opt") as MainActivity.Option
        binding.switchTimer.isChecked= opt.timerWork
        binding.countGlasses.text = opt.timerSec.toString()
    }
    private fun onClickListeners(){
        binding.bMinus.setOnClickListener {
            var temp = binding.countGlasses.text.toString().toInt()
            if (temp >=2) {
                temp -= 1
                binding.countGlasses.text = temp.toString()
            }
        }
        binding.bPlus.setOnClickListener {
            var temp = binding.countGlasses.text.toString().toInt()
            if (temp <=14) {
                temp += 1
                binding.countGlasses.text = temp.toString()
            }
        }
        binding.bDone.setOnClickListener {
            val i = Intent()
            i.putExtra("optionGame", MainActivity.Option(binding.countGlasses.text.toString().toInt(), binding.switchTimer.isChecked))
            setResult(RESULT_OK,i)
            finish()
        }
    }
}