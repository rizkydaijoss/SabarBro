package kkp.sabarbro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kkp.sabarbro.helper.JSONParser;

public class LoginActivity extends Activity {
    private TextView gotoRegister;

    public static final String KEY_USERNAME="username";
    //public static final String KEY_PASSWORD="password";

    Button login;
    Intent a;
    EditText username, password;
    String url, success;
    SessionManager session;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        login = (Button) findViewById(R.id.buttonLogin);
        username = (EditText) findViewById(R.id.editTextUsername);
        password = (EditText) findViewById(R.id.editTextPassword);

        login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //url = "http://amranswandy.com/KKP_Rizky/loginbismillah.php?" + "username="
                url = "http://amran.me/KKP_Rizky/loginbismillah.php?" + "username="
                        + username.getText().toString() + "&password="
                        + password.getText().toString();

                if (username.getText().toString().trim().length() > 0
                        && password.getText().toString().trim().length() > 0) {
                    if (cek_status(getApplication()))
                    { new Masuk().execute();
                    } else {
                        Toast.makeText(getApplicationContext(), "Koneksi tidak tersedia.!!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Username/Password belum terisi.!!", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
    public boolean cek_status(Context cek) {
        ConnectivityManager cm   = (ConnectivityManager) cek.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        if (info != null && info.isConnected())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public class Masuk extends AsyncTask<String, String, String> {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();
        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

            pDialog = new ProgressDialog(LoginActivity.this);
            pDialog.setMessage("Sedang Process...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @Override
        protected String doInBackground(String... arg0) {
            JSONParser jParser = new JSONParser();

            JSONObject json = jParser.getJSONFromUrl(url);

            try {
                success = json.getString("success");

                Log.e("error", "nilai sukses=" + success);

                JSONArray hasil = json.getJSONArray("login");

                if (success.equals("1")) {

                    for (int i = 0; i < hasil.length(); i++) {

                        JSONObject c = hasil.getJSONObject(i);

                        /*String idg = c.getString("idg").trim();
                        String nip = c.getString("nip").trim();
                        String nama = c.getString("nama").trim();
                        String jk = c.getString("jk").trim();
                        String alamat = c.getString("alamat").trim();
                        String idk = c.getString("idk").trim();

                        session.createLoginSession(idg,nip,nama,jk,alamat,idk);
                        Log.e("ok", " ambil data");*/

                    }
                } else {
                    Log.e("erro", "tidak bisa ambil data 0");
                }

            } catch (Exception e) {
                // TODO: handle exception
                Log.e("erro", "tidak bisa ambil data 1");
            }

            return null;

        }
        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            pDialog.dismiss();
            if (success.equals("1")) {
                a = new Intent(LoginActivity.this, ActivityUserProfile.class);
                startActivity(a);
                finish();
            }else if (success.equals("0")){

                Toast.makeText(getApplicationContext(), "Username anda belum terdaftar atau belum di konfirmasi admin !!", Toast.LENGTH_LONG).show();
            }

        }

    }
    public void Register(View view){
        Intent intent = new Intent().setClass(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}