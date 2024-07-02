package campus.tech.kakao.map

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val search = findViewById<EditText>(R.id.search)
        val close = findViewById<ImageView>(R.id.close_icon)
        val listView = findViewById<ListView>(R.id.list_view)

    }
}

