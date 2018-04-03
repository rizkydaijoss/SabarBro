package kkp.sabarbro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DataRestoranMysql extends AppCompatActivity {

    private TextView txtnamarestoran, txtalamat, txtmenu, txtharga, txtfasilitas, txthp, txtlatitude, txtlongitude;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_restoran_mysql);

        //String url = "http://amranswandy.com/KKP_Rizky/getdata.php";
        String url = "http://amran.me/KKP_Rizky/getdata.php";

        txtnamarestoran = (TextView)findViewById(R.id.txtnamarestoran);
        txtalamat = (TextView)findViewById(R.id.txtalamat);
        txtmenu = (TextView)findViewById(R.id.txtmenu);
        txtharga = (TextView)findViewById(R.id.txtharga);
        txtfasilitas = (TextView)findViewById(R.id.txtfasilitas);
        txthp = (TextView)findViewById(R.id.txthp);
        txtlatitude = (TextView)findViewById(R.id.txtlatitude);
        txtlongitude = (TextView)findViewById(R.id.txtlongitude);

        requestQueue = Volley.newRequestQueue(DataRestoranMysql.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("datarestoran");
                    for (int a = 0; a < jsonArray.length(); a ++){
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map  = new HashMap<String, String>();
                        map.put("id", json.getString("id_restoran"));
                        map.put("namarestoran", json.getString("namarestoran"));
                        map.put("alamat", json.getString("alamat"));
                        map.put("menu", json.getString("menu"));
                        map.put("harga", json.getString("harga"));
                        map.put("fasilitas", json.getString("fasilitas"));
                        map.put("hp", json.getString("hp"));
                        map.put("latitude", json.getString("latitude"));
                        map.put("longitude", json.getString("longitude"));
                        list_data.add(map);
                    }

                    txtnamarestoran.setText(list_data.get(0).get("namarestoran"));
                    txtalamat.setText(list_data.get(0).get("alamat"));
                    txtmenu.setText(list_data.get(0).get("menu"));
                    txtharga.setText(list_data.get(0).get("harga"));
                    txtfasilitas.setText(list_data.get(0).get("fasilitas"));
                    txthp.setText(list_data.get(0).get("hp"));
                    txtlatitude.setText(list_data.get(0).get("latitude"));
                    txtlongitude.setText(list_data.get(0).get("longitude"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DataRestoranMysql.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);
    }


}
