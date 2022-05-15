package za.ac.cput.assignment03_prac03

sealed class Screen(val route: String)
{
    object First :Screen(route = "first_screen")
    object Second :Screen(route = "second_screen")
    object Third :Screen(route = "third_screen")
}


