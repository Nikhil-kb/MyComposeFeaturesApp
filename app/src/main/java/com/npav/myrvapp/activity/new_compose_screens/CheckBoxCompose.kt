package com.npav.myrvapp.activity.new_compose_screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxCompose(checkItemList: List<String>) {

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        val context = LocalContext.current

        LazyColumn() {
            items(checkItemList.size) { index ->
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
                ) {
                    var checkState by remember {
                        mutableStateOf(false)
                    }

                    Checkbox(
                        checked = checkState,
                        enabled = true,
                        onCheckedChange = {
                            checkState = it
                        },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color.Magenta,
                            uncheckedColor = Color.Gray,
                            checkedColor = Color.Blue
                        ),
                        modifier = Modifier.padding(start = 10.dp)
                    )

                    Text(
                        text = checkItemList[index],
                        modifier = Modifier.padding(start = 10.dp)
                    )

                    if (checkState) {
                        Toast.makeText(context, checkItemList[index], Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

}