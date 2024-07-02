package campus.tech.kakao.map

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DatabaseManager(context: Context) {

    private val dbHelper = DatabaseHelper(context) //SQLiteOpenHelper객체 생성
    private val db: SQLiteDatabase = dbHelper.writableDatabase //open하고 실제 데이터베이스..?

    fun insertPlace(name: String, address: String, kind: String) {
        val values = ContentValues().apply {
            put("name", name)
            put("address", address)
            put("kind", kind)
        }
        db.insert("places", null, values)
    }

    fun searchPlacesKind(kind: String): List<Place> {
        val result = mutableListOf<Place>()
        val cursor: Cursor = db.query(
            "places",
            arrayOf("id", "name", "address", "kind"),
            "kind LIKE ?",
            arrayOf(kind),
            null,
            null,
            null
        )

        with(cursor) {
            while (moveToNext()) {
                val place = Place(
                    getInt(getColumnIndexOrThrow("id")),
                    getString(getColumnIndexOrThrow("name")),
                    getString(getColumnIndexOrThrow("address")),
                    getString(getColumnIndexOrThrow("kind"))
                )
                places.add(place)
            }
        }
        cursor.close()
        return places
    }

}