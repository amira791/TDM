package com.example.sqliteemployee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sqliteemployee.ui.theme.SQLiteEmployeeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SQLiteEmployeeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    val db = EmployeeDatabase.getInstance(applicationContext)
                    val dao = db.getEmployeeDao()
                    ManagerEmp(dao)

                }
            }
        }
    }
}

@Composable
fun ManagerEmp(employeeDao: EmployeeDao) {
    val loading = remember { mutableStateOf(false) }
    val nb = remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(8.dp)
    ) {
        Button(
            onClick = {
                loading.value = true
                CoroutineScope(Dispatchers.IO).launch {
                    for (i in 0..1000) {
                        employeeDao.addEmp(Employee(firstName = "fName $i", lastName = "lName $i"))
                    }
                    loading.value = false
                }
            },
        ) {
            Text(text = "Add Employees")
        }

        loadingPage(loading.value)

        Button(
            onClick = {
                CoroutineScope(Dispatchers.IO).launch {

                         nb.value = employeeDao.getNbEmp()

                }




            },
        ) {
            Text(text = "Get")
        }

        Text(text = nb.value.toString())
    }
}

@Composable
fun loadingPage(loading: Boolean) {
    if (loading) {
        CircularProgressIndicator()
    }
}