package com.example.sasensorsproj

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_acccerlormeter.*

class AcccerlormeterActivity : AppCompatActivity(),SensorEventListener {

    lateinit var  sensoryManager : SensorManager
    lateinit var myText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acccerlormeter)

        myText = findViewById(R.id.textViewResult)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        sensoryManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensoryManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also {
            sensoryManager.registerListener(this, it,SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST)

        }


    }

    override fun onSensorChanged(event: SensorEvent?) {
                if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
                    val sides = event.values[0]
                    val upDown = event.values[1]

                    textViewResult.apply {
                        rotationX = upDown * 3f
                        rotationY = sides * 3f
                        rotation = -sides
                        translationX = sides * -10
                        translationY = upDown * 10

                    }

                    val color = if(upDown.toInt() == 0 && sides.toInt() == 0){
                        Color.GREEN
                    }
                    else
                    {
                       Color.BLUE
                    }

                    textViewResult.setBackgroundColor(color)
                    textViewResult.text = " up and Down --  ${upDown.toInt()} \n  sides -- ${sides.toInt()}"
                }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }


}