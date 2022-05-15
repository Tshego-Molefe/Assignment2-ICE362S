package za.ac.cput.assignment03_prac03

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Welcome()
{
    Text(text = "My Journey!!!",
        fontSize = 50.sp, modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(
                top = 80.dp,
                bottom = 40.dp,
                start = 20.dp,
                end = 20.dp
            )
            .wrapContentSize(Alignment.TopCenter)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentHeight(Alignment.CenterVertically),
        color = Color.DarkGray,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyJourney(
    navController: NavController
) {
    Column(
        //horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentSize(Alignment.TopCenter)
            .background(Color.Gray)
    )
    {
        Row() {

            Text(
                text = "First Name: ",
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Tshegofatso\n", fontSize = 16.sp)
        }


        Row() {
            Text(
                text = "Last Name: ",
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Molefe\n", fontSize = 16.sp)
        }

        Row() {
            Text(
                text = "Student Number: ",
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("219001235\n", fontSize = 16.sp)
        }

        Row() {
            Text(
                text = "Course of Study: ",
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("DIP: ICT in\n" + " Applications Development\n", fontSize = 16.sp)
        }
        Row() {
            Spacer(modifier = Modifier
                .width(20.dp).align(Alignment.CenterVertically)
            )
            Button(onClick = {navController.navigate(Screen.Third.route) },Modifier.padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFC0C0C0))  ) {
                Text(text = "Current Modules: ")
                Icon(
                    painter = painterResource(id = R.drawable.ic_subject_24),
                    contentDescription = null
                )
            }

        }
    }

}

@Composable
fun BackButton(
    navController: NavController
)
{
    Box(
        Modifier
            .fillMaxSize()
            .padding(24.dp), Alignment.BottomCenter){
        Button(onClick = { navController.navigate(Screen.First.route) }) {
            Text(text = "B A C K")
            Icon(painter = painterResource(id = R.drawable.ic_arrow_back_24),
                contentDescription = null)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview2() {

        Welcome()
      //  MyJourney()

}