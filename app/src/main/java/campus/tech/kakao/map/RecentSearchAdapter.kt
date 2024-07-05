package campus.tech.kakao.map

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecentSearchAdapter(private val items : List<Place>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        //val id : TextView = view.findViewById(R.id.recent_search_id)
        val name: TextView = view.findViewById(R.id.recent_search_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent?.context).inflate(R.layout.item_saved_search, parent, false)
        return PlaceAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceAdapter.ViewHolder, position: Int) {
        val item = items[position]
        with(holder) {
            //id.text = item.id.toString()
            name.text = item.name
            Log.d("Testt",holder.name.text.toString())
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

