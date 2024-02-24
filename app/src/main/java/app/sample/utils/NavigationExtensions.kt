package app.sample.utils

import androidx.navigation.NavHostController
import app.sample.ui.navigation.NavigationRoutes

fun NavHostController.safePopBackStack(): Boolean{
    return if(this.currentBackStackEntry?.destination?.route!! != NavigationRoutes.MainScreen.route) {
        this.popBackStack()
    } else {
        false
    }
}