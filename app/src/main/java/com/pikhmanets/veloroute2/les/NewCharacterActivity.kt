package com.pikhmanets.veloroute2.les

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.pikhmanets.veloroute2.R
import com.pikhmanets.veloroute2.databinding.ActivityCharacterBinding
import com.pikhmanets.veloroute2.les.retrofit.Common
import com.pikhmanets.veloroute2.les.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewCharacterActivity : AppCompatActivity() {

    private lateinit var service: RetrofitServices
    private lateinit var binding: ActivityCharacterBinding

    companion object {
        private const val CHARACTER_DATA_KEY = "CHARACTER_DATA_KEY"
        private var characterData = CharacterGenerator.generate()
    }

    private var Bundle.characterData
        get() = getSerializable(CHARACTER_DATA_KEY) as CharacterGenerator.CharacterData
        set(value) = putSerializable(CHARACTER_DATA_KEY, value)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        service = Common.retrofitService
        characterData = savedInstanceState?.characterData ?: CharacterGenerator.generate()

        binding.generateButton.setOnClickListener {
            service.getModel().enqueue(object : Callback<String?> {
                override fun onResponse(call: Call<String?>, response: Response<String?>) {
                    characterData = CharacterGenerator.fromApiData(response.body()!!)
                    displayCharacterData()
                }

                override fun onFailure(call: Call<String?>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
        displayCharacterData()
    }

    private fun displayCharacterData() {
        characterData.run {
            binding.nameTextView.text = name
            binding.raceTextView.text = race
            binding.dexterityTextView.text = dex
            binding.wisdomTextView.text = wis
            binding.strengthTextView.text = str
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.characterData
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}