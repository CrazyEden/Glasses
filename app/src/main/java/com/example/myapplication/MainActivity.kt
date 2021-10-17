package com.example.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.parcel.Parcelize


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var option = Option()
    private var launchSettings : ActivityResultLauncher<Intent>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launchSettings =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    option = result.data?.getParcelableExtra("optionGame")!!
                }
            }
        clickListeners()
    }
    private fun clickListeners(){
        binding.bStart.setOnClickListener {
            val i = Intent(this,GameActivity::class.java)
            i.putExtra("opt",option)
            startActivity(i) }
         binding.bSettings.setOnClickListener {
            val i = Intent(this,SettingsActivity::class.java)
            i.putExtra("opt",option)
            launchSettings?.launch(i)
        }
        binding.bAbout.setOnClickListener {
            val intent = Intent(this,AboutActivity::class.java)
            startActivity(intent)
        }
    }



    @Parcelize
    class Option(var timerSec:Int=5, var timerWork:Boolean=false):Parcelable
}