package campus.tech.kakao.map

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val search = findViewById<EditText>(R.id.search)
        val close = findViewById<ImageView>(R.id.close_icon)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dataGeneration = findViewById<TextView>(R.id.data_generation)
        val searchBotton = findViewById<TextView>(R.id.searchBotton)
        val delete = findViewById<TextView>(R.id.data_delete)
        val recentSearch = findViewById<RecyclerView>(R.id.recent_search)

        val dbManager = DatabaseManager(context = this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recentSearch.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)    //마지막 인자는 역순으로 배치 여부

        dataGeneration.setOnClickListener{
            with(dbManager){
                for(i in 1..20){
                    insertPlace("카페$i","주소$i","카페")
                }
            }
            Toast.makeText(this, "데이터 생성 완료", Toast.LENGTH_SHORT).show()

        }

        searchBotton.setOnClickListener {
            val query = search.text.toString()
            if (query.isEmpty()) {
                Toast.makeText(this, "검색어를 입력하세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val dummy = dbManager.searchPlacesKind(query)
            recyclerView.adapter = PlaceAdapter(dummy)
            Log.d("testt", dummy.toString())
        }

        delete.setOnClickListener{
            dbManager.dropTable()
            dbManager.createTable()
        }


    }
}

