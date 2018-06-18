package com.example.study.spinner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var countries = arrayOf("한국", "미국")
    var city_korea = arrayOf("서울", "대전", "부산")
    var city_usa = arrayOf("뉴욕", "워싱턴", "로스엔젤레스")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countryAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, countries)
        spinner_country.adapter = countryAdapter
        spinner_country.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var country = parent!!.getItemAtPosition(position)
                if (country == "한국")
                {
                    var adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, city_korea)
                    spinner_city.adapter = adapter
                }
                else if (country == "미국")
                {
                    var adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, city_usa)
                    spinner_city.adapter = adapter
                }
            }
        }

        spinner_city.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var country = parent!!.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, country + "을 선택하셨습니다", Toast.LENGTH_LONG)
            }
        }
    }
}
