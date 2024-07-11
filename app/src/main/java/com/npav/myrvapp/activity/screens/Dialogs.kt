package com.npav.myrvapp.activity.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import java.sql.Time

import java.util.Calendar


@Composable
fun DatePickerDialog_(context: Context) {
    val context: Context = context
    var selectedTime by remember {
        mutableStateOf("")
    }

    val calendar = Calendar.getInstance()
    val year = calendar[Calendar.YEAR]
    val month = calendar[Calendar.MONTH]
    val day = calendar[Calendar.DAY_OF_MONTH]


    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            selectedTime = "$selectedDay-${selectedMonth + 1}-$selectedYear"
        },
        year,
        month,
        day
    )

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = if (selectedTime.isNotEmpty()) "Selected date: $selectedTime" else "Current date: $day-${month + 1}-$year",
            style = TextStyle(color = Color.Black, fontSize = 18.sp)
        )

        Button(onClick = {
            datePickerDialog.show()
        }) {
            Text(text = "Select date")
        }

    }

}

@Composable
fun TimePickerDialog_(context: Context) {

    val context = context
    var selectedTime by remember {
        mutableStateOf("")
    }

    val calendar = Calendar.getInstance()
    val hour = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    val timePickerDialog =
        TimePickerDialog(context, { _: TimePicker, selectedHour: Int, selectedMinute: Int ->
            selectedTime = "Selected Time: $selectedHour : $selectedMinute"

        }, hour, minute, false)


    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = if (selectedTime.isNotEmpty()) selectedTime else "Current time: $hour : $minute",
            style = TextStyle(color = Color.Black, fontSize = 18.sp)
        )

        Button(onClick = {
            timePickerDialog.show()
        }) {
            Text(text = "Select Time")
        }

    }

}
