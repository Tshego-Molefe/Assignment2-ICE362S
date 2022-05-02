package za.ac.cput.assignment03_prac02

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import za.ac.cput.assignment03_prac02.ui.theme.Assignment03_Prac02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment03_Prac02Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WelcomeText()
                    WelcomeImage()
                    InfoButton()
                    NextButton()
                }
            }
        }
    }
}
@Composable
fun WelcomeText()
{
    Text(text = "Welcome to my Jetpack Compose Journey!!!",
        fontSize = 30.sp, modifier = Modifier
            .fillMaxSize()
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
fun WelcomeImage()
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentSize(Alignment.Center)
            .background(Color.Black)) {
        Image(painter = painterResource(id = R.drawable.ic_jetpack),
            contentDescription = null)
    }
}

@Composable
fun InfoButton()
{
    val visible: MutableState<Boolean> = remember { mutableStateOf(false) }

    ShowDialog(visible = visible)

    Box(
        Modifier
            .fillMaxSize()
            .padding(24.dp), Alignment.BottomStart){
        Button(onClick = { visible.value = true }) {
            Text(text = "I N F O ")
            Icon(imageVector = Icons.Default.Info,
                contentDescription = null)
        }
    }
}

@Composable
fun NextButton()
{
    val btnContxt = LocalContext.current
    Box(
        Modifier
            .fillMaxSize()
            .padding(24.dp), Alignment.BottomEnd){
        Button(onClick = { btnContxt.startActivity(Intent(btnContxt, SecondActivity::class.java)) }) {
            Text(text = "START JOURNEY ")
            Icon(painter = painterResource(id = R.drawable.ic_next_24),
                contentDescription = null)
        }

    }
}

@Composable
fun ShowDialog(visible:MutableState<Boolean>){
    if(visible.value){
        AlertDialog(
            onDismissRequest = {visible.value = false },
            dismissButton = {
                TextButton(onClick = { visible.value = false }) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                TextButton(onClick = { visible.value = false }) {
                    Text(text = "OK")
                }
            },
            title = {Text(text = "ALERT DIALOG" )},
            text = {Text(text = "Jetpack Compose very  different from \n " +
                    "what I learnt in Mobile Programming 1 with XML\n " +
                    "It is trickier bit seems more rounded\n "+
                    "I can't wait to learn more")}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Assignment03_Prac02Theme {
        WelcomeText()
        WelcomeImage()
        InfoButton()
        NextButton()
    }
}