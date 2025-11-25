
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.kb.masterlyapp.presentation.screens.home.HomeScreen
import com.kb.masterlyapp.presentation.screens.home.HomeScreenViewModel
import com.kb.masterlyapp.presentation.screens.setting.SettingScreen
import com.kb.masterlyapp.presentation.screens.timer.TimerScreen

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    homeScreenViewModel: HomeScreenViewModel
) {

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home",
            ) {
            HomeScreen(modifier, homeScreenViewModel = homeScreenViewModel) {
               navController.navigate("timer/$it")
            }
        }

        composable("settings") {
           SettingScreen(modifier)
           // RememberUpdatedStateDemo()
        }

        composable(
            route = "timer/{skillName}",
            arguments = listOf(
                navArgument("skillName") {
                    type = NavType.StringType
                    defaultValue = "default_value"
                    nullable = false
                }
            ),
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://masterly.app/timer/{skillName}"
                }
            ),
            exitTransition = {
                // When we navigate AWAY from current screen TO timer
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                ) + fadeOut()
            },
            enterTransition = {
                // When we navigate TO timer
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                ) + fadeIn()
            },
            popEnterTransition = {
                // When we come BACK to this screen
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                ) + fadeIn()
            },
            popExitTransition = {
                // When we go BACK from this screen
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                ) + fadeOut()
            }
            // Forward navigation uses → enter + exit
            // Back navigation uses → popEnter + popExit
        ) { backStackEntry ->
            val skillName = backStackEntry.arguments?.getString("skillName") ?: "default_value"
            TimerScreen(skillName = skillName)
        }
    }
}