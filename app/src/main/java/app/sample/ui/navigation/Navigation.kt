package app.sample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.sample.ui.navigation.NavigationRoutes
import app.sample.ui.composables.MainScreen
import app.sample.ui.viewModels.SampleLocalViewModel

@Composable
fun Navigation(sampleLocalViewModel: SampleLocalViewModel) {
    val navigator = rememberNavController()

    NavHost(navController = navigator, startDestination = NavigationRoutes.MainScreen.route){
        composable(NavigationRoutes.MainScreen.route){ MainScreen()}
    }
}