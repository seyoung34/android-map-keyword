package campus.tech.kakao.map

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val search = findViewById<EditText>(R.id.search)
        val close = findViewById<ImageView>(R.id.close_icon)
        val listView = findViewById<ListView>(R.id.list_view)
        val dataGeneration = findViewById<TextView>(R.id.data_generation)
        val refresh = findViewById<TextView>(R.id.refresh)
        val delete = findViewById<TextView>(R.id.data_delete)
        val dbManager = DatabaseManager(context = this)

        dataGeneration.setOnClickListener{
            with(dbManager){
                for(i in 1..20){
                    insertPlace("카페$i","주소$i","카페")
                }
            }
            Toast.makeText(this, "데이터 생성 완료", Toast.LENGTH_SHORT).show()

        }

        refresh.setOnClickListener {
            val query = search.text.toString()
            if (query.isEmpty()) {
                Toast.makeText(this, "검색어를 입력하세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val dummy = dbManager.searchPlacesKind(query)
            listView.adapter = PlaceAdapter(dummy)
        }

        delete.setOnClickListener{
            dbManager.dropTable()
            dbManager.createTable()
        }


    }
}

