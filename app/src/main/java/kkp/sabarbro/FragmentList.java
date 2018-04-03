package kkp.sabarbro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.SearchView;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;

public class FragmentList extends Fragment {
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    private RecyclerView mRVRestoranList;
    private AdapterRestoran mAdapter;
    private SimpleCursorAdapter myAdapter;

    SearchView searchView = null;
    private String[] strArrData = {"No Suggestions"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Set title bar
        return inflater.inflate(R.layout.activity_fragment_list, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        final String[] from = new String[] {"fishName"};
        final int[] to = new int[] {android.R.id.text1};

        // setup SimpleCursorAdapter
        myAdapter = new SimpleCursorAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, null, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);




        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity())
                .setActionBarTitle("Sabar Bro");
        new AsyncLogin().execute();

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



    private class AsyncLogin extends AsyncTask<String, String, String> {
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your json file resides
                // Even you can make call to php file which returns json data
                url = new URL("http://masgandos.pe.hu/sabarbro/datarestoran.json");

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return e.toString();
            }
            try {

                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("GET");

                // setDoOutput to true as we recieve data from json file
                conn.setDoOutput(true);

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return e1.toString();
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread


            final List<DataRestoran> data=new ArrayList<>();


            try {

                JSONArray jArray = new JSONArray(result);



                // Extract data from json and store into ArrayList as class objects
                for(int i=0;i<jArray.length();i++) {

                    JSONObject json_data = jArray.getJSONObject(i);


                    String GambarRestoran = json_data.getString("gambar");
                    String NamaRestoran = json_data.getString("nama");
                    String AlamatRestoran = json_data.getString("alamat");
                    String Menu = json_data.getString("menu");
                    String Harga = json_data.getString("harga");
                    String Fasilitas = json_data.getString("fasilitas");
                    String Hp= json_data.getString("hp");
                    DataRestoran restoran1 = new DataRestoran(GambarRestoran, NamaRestoran, AlamatRestoran, Menu, Harga, Fasilitas, Hp);
                    data.add(restoran1);

                }

                // Setup and Handover data to recyclerview
                mRVRestoranList = (RecyclerView)getActivity().findViewById(R.id.RestoranPriceList);
                mAdapter = new AdapterRestoran(getActivity().getApplicationContext(), data);
                mRVRestoranList.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
                mRVRestoranList.setAdapter(mAdapter);
                mRVRestoranList.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                mRVRestoranList.addOnItemTouchListener(new RecycleTouchListener(getActivity().getApplicationContext(), mRVRestoranList,
                        new RecycleTouchListener.ClickListener() {
                            @Override
                            public void onClick(View view, int position) {
                                Intent intent = new Intent(getActivity(), DetilRestoran.class);
                                intent.putExtra("jdl_id_key", data.get(position).getNama());
                                intent.putExtra("gam_id_key", data.get(position).getGambar());
                                intent.putExtra("alm_id_key", data.get(position).getAlamat());
                                intent.putExtra("menu_id_key", data.get(position).getMenu());
                                intent.putExtra("hrg_id_key", data.get(position).getHarga());
                                intent.putExtra("fas_id_key", data.get(position).getFasilitas());
                                intent.putExtra("hp_id_key", data.get(position).getHp());
                                startActivity(intent);





                            }

                            @Override
                            public void onLongClick(View view, int position) {

                            }
                        }));


            } catch (JSONException e) {
                Toast.makeText(getActivity().getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }

        }

    }



}