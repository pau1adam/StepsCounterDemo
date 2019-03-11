package io.github.stepscounterdemo.ui.mainactivity

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private var isInitialised = false
    val counter: MutableLiveData<Int> = MutableLiveData<Int>().default(0)

    fun init(context: Context) {
        if (isInitialised) return
        val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val countSensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
        sensorManager.registerListener(listener, countSensor, SensorManager.SENSOR_DELAY_UI)
        isInitialised = true
    }

    private val listener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit

        override fun onSensorChanged(event: SensorEvent) {
            counter.value = counter.value!! + event.values[0].toInt()
        }
    }
}


fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }
