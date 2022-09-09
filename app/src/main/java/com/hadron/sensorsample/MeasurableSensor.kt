package com.hadron.sensorsample

abstract class MeasurableSensor(
    protected val sensorType: Int
) {
    abstract val doesSensorExist: Boolean

    abstract fun startListening()
    abstract fun stopListening()

    protected var onSensorValueChanged: ((List<Float>) -> Unit)? = null
    fun setOnSensorValueChangedListener(listener: ((List<Float>) -> Unit)) {
        onSensorValueChanged = listener
    }
}