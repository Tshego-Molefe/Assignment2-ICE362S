package za.ac.cput.assignment03_prac03

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetUpNavGraph(navController: NavHostController)
{
    NavHost(
        navController = navController,
        startDestination = Screen.First.route){
        composable(
            route = Screen.First.route
        ){
            WelcomeText()
            WelcomeImage()
            InfoButton()
            NextButton(navController)
        }
        composable(
            route = Screen.Second.route
        ){
            Welcome()
            MyJourney(navController)
            BackButton(navController)
        }
        composable(
            route = Screen.Third.route
        ){
            MyModules()
            BackTo2(navController)
            GoodbyeBtn(navController)
            //AlertButton(MutableState<Boolean>)
        }
    }
}