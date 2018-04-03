package kkp.sabarbro;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListViewMysqlRevisi extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_mysql_revisi);

        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

        //JSONObject json = JSONFunctions.getJSONfromURL("http://amranswandy.com/KKP_Rizky/daftar_restoran.php");
        JSONObject json = JSONFunctions.getJSONfromURL("http://amran.me/KKP_Rizky/daftar_restoran.php");

        try{

            JSONArray  datarestoran = json.getJSONArray("datarestoran");

            for(int i=0;i<datarestoran.length();i++){
                HashMap<String, String> map = new HashMap<String, String>();
                JSONObject jsonobj = datarestoran.getJSONObject(i);

                map.put("id_restoran",  jsonobj.getString("id_restoran"));;
                map.put("namarestoran", jsonobj.getString("namarestoran"));
                map.put("alamat", jsonobj.getString("alamat"));
                map.put("menu", jsonobj.getString("menu"));
                map.put("harga", "Mulai dari Rp. " +  jsonobj.getString("harga"));
                map.put("fasilitas", jsonobj.getString("fasilitas"));
                map.put("hp", jsonobj.getString("hp"));
                map.put("latitude", jsonobj.getString("latitude"));
                map.put("longitude", jsonobj.getString("longitude"));
                mylist.add(map);
            }
        }catch(JSONException e)        {
            Log.e("log_tag", "Error parsing data "+e.toString());
        }

        ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.row_revisi,
                new String[] { "namarestoran", "alamat", "menu", "harga", "fasilitas", "hp", "latitude", "longitude" },
                new int[] { R.id.nama_restoran, R.id.alamat_restoran, R.id.menu_restoran, R.id.harga_restoran, R.id.fasilitas_restoran, R.id.hp_restoran, R.id.latitude_restoran, R.id.longitude_restoran });

        setListAdapter(adapter);

        final ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                @SuppressWarnings("unchecked")
                HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);
                Toast.makeText(ListViewMysqlRevisi.this, "Nama Restoran '" + o.get("namarestoran") + "' was clicked.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
