package deedev.diliver

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Signup: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val haveAccText: TextView=findViewById(R.id.haveAccountText)
        haveAccText.setOnClickListener {
            val intent= Intent(this,LoginPage::class.java)
            startActivity(intent)
            finish()
        }

    }
}