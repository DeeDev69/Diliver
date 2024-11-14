package deedev.diliver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import androidx.navigation.findNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var NavController:NavController=findNavController(R.id.fragmentContainerView)
    }
}