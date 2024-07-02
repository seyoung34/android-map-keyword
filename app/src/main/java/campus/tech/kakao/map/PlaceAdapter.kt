package campus.tech.kakao.map

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PlaceAdapter(private val items : List<Place>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Place {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View =
            LayoutInflater.from(parent?.context).inflate(R.layout.item_listview, parent, false)

        val id : TextView = view.findViewById(R.id.id)
        val name: TextView = view.findViewById(R.id.name)
        val address: TextView = view.findViewById(R.id.address)
        val kind: TextView = view.findViewById(R.id.kind)

        val item = items[position]
        id.text = item.id.toString()
        name.text = item.name
        address.text = item.address
        kind.text = item.kind

        return view

    }
}