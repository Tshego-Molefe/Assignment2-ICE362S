package za.ac.cput.assignment03_prac03

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.system.exitProcess

@Composable
fun MyModules()

    {
        Column(
            //horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(Alignment.CenterVertically)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .wrapContentSize(Alignment.TopCenter)
                .background(Color.LightGray)
                .padding(
                    top = 80.dp,
                    bottom = 40.dp,
                    start = 20.dp,
                    end = 20.dp
                )
                .fillMaxSize()
                .background(Color.Gray)
        ){
            Row() {

                Text(
                    text = "CURRENT MODULES... \n\n\n",
                    fontSize = 24.sp,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(12.dp))
            }

            Column() {
                Text(
                    text = "1. Applications Development Practice: ",
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold
                )
                //Spacer(modifier = Modifier.width(8.dp))
                Text("This is a second year practical module. It runs all year round. \n", fontSize = 16.sp)
            }

            Column() {
                Text(
                    text = "2. Professional Practice: ",
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold
                )
                //Spacer(modifier = Modifier.width(8.dp))
                Text("This is a third year theory module. This module lasts for only a semester\n", fontSize = 16.sp)
            }

            Column() {
                Text(
                    text = "3. Mobile Programming (Elective): ",
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold
                )
                //Spacer(modifier = Modifier.width(8.dp))
                Text("This is a third year practical module. I believe it only runs for one semester\n", fontSize = 16.sp)
            }


            Column() {
                Text(
                    text = "4. Project Management: ",
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold
                )
                //Spacer(modifier = Modifier.width(8.dp))
                Text("This is a third year module. \n" +
                        "It has theory and practical elements and I believe it only runs for a semester\n", fontSize = 16.sp)
            }
        }
}

@Composable
fun BackTo2(navController: NavController
)
{
    Box(
        Modifier
            .fillMaxSize()
            .padding(24.dp), Alignment.BottomStart){
        Button(onClick = { navController.navigate(Screen.Second.route) }) {
            Text(text = "B A C K")
            Icon(painter = painterResource(id = R.drawable.ic_arrow_back_24),
                contentDescription = null)
        }

    }

}

@Composable
fun GoodbyeBtn(navController: NavController)
{
    val visible: MutableState<Boolean> = remember { mutableStateOf(false) }

    AlertButton(
        visible = visible,
        navController
    )

    Box(
        Modifier
            .fillMaxSize()
            .padding(24.dp), Alignment.BottomEnd){
        Button(onClick = { visible.value = true }) {
            Text(text = "Exit")
            Icon(
                painterResource(id = R.drawable.ic_close_24),
                contentDescription = null)
        }
    }
}



@Composable
fun AlertButton(visible: MutableState<Boolean>, navController: NavController)
{
    if(visible.value){
        AlertDialog(
            onDismissRequest = {visible.value = false },
            dismissButton = {
                TextButton(onClick = { visible.value = false;
                    exitProcess(0) }) {
                    Text(text = "Yes")
                }
            },
            confirmButton = {
                TextButton(onClick = { visible.value = false;
                    navController.navigate(Screen.Third.route) }) {
                    Text(text = "No")
                }
            },
            title = {Text(text = "ALERT DIALOG" , fontWeight = FontWeight.Bold)},
            text = {Text(text = "Leaving now?" )}

        )
    }
}