package kkp.sabarbro;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import kkp.sabarbro.helper.AppConfig;
import kkp.sabarbro.helper.AppController;
import java.io.File;
import java.io.FileNotFoundException;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TambahRestoran extends AppCompatActivity implements OnClickListener {

    private static final String TAG = "TambahRestoran";
    ProgressDialog progressDialog;
    private EditText InputRestoran, InputAlamat, InputMenu, InputHarga, InputFasilitas, InputHP, InputLatitude, InputLongitude;
    private Button btnSubmit;
    TextView txtSDK;
    Button btnSelectImage;
    TextView txtRealPath;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_restoran);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar abar = getSupportActionBar();
        View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);
        textviewTitle.setText("Tambah Restoran");
        assert abar != null;
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(true);
        abar.setHomeButtonEnabled(true);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        InputRestoran = (EditText) findViewById(R.id.input_namarestoran);
        InputAlamat = (EditText) findViewById(R.id.input_alamat);
        InputMenu = (EditText) findViewById(R.id.input_menu);
        InputHarga = (EditText) findViewById(R.id.input_harga);
        InputFasilitas = (EditText) findViewById(R.id.input_fasilitas);
        InputHP = (EditText) findViewById(R.id.input_hp);
        InputLatitude= (EditText) findViewById(R.id.input_latitude);
        InputLongitude = (EditText) findViewById(R.id.input_longitude);

        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        btnSelectImage = (Button) findViewById(R.id.btnSelectImage);
        txtRealPath = (TextView) findViewById(R.id.txtRealPath);

        // add click listener to button
        btnSelectImage.setOnClickListener(this);
    }

    private void submitForm() {
        Log.d(TAG, "Submit");

        if (!validate()) {
            onSubmitFailed();
            return;
        }

        tambahUser(InputRestoran.getText().toString(),
                InputAlamat.getText().toString(),
                InputMenu.getText().toString(),
                InputHarga.getText().toString(),
                InputFasilitas.getText().toString(),
                InputHP.getText().toString(),
                InputLatitude.getText().toString(),
                InputLongitude.getText().toString()
        );
    }

    private void tambahUser(final String namarestoran, final String alamat, final String menu,
                            final String harga, final String fasilitas, final String hp, final String latitude, final String longitude) {
        // Tag used to cancel the request
        String cancel_req_tag = "tambah";


        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_TAMBAH, new Response.Listener<String>() {

            @Override
            public void onResponse(final String response) {

                Log.d(TAG, "tambah Response: " + response.toString());
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Memasukkan data...");
                progressDialog.show();

                //buat delay pada saat login
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                // On complete call either onLoginSuccess or onLoginFailed
                                try {
                                    JSONObject jObj = new JSONObject(response);
                                    boolean error = jObj.getBoolean("error");

                                    if (!error) {
                                        Toast.makeText(getApplicationContext(), "Terima kasih telah berpartisipasi dengan kami.", Toast.LENGTH_SHORT).show();

                                        // Launch Main activity
                                        Intent intent = new Intent(
                                                TambahRestoran.this,
                                                MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        String errorMsg = jObj.getString("error_msg");
                                        Toast.makeText(getApplicationContext(),
                                                errorMsg, Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                // menghilangkan progress yang sedang berjalan
                                progressDialog.dismiss();
                            }
                        }, 2500);




            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "tambah Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting params to tambah url
                Map<String, String> params = new HashMap<String, String>();
                params.put("namarestoran", namarestoran);
                params.put("alamat", alamat);
                params.put("menu", menu);
                params.put("harga", harga);
                params.put("fasilitas", fasilitas);
                params.put("hp", hp);
                params.put("latitude", latitude);
                params.put("longitude", longitude);
                return params;
            }
        };
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, cancel_req_tag);
    }

    public void onSubmitFailed() {
        Toast.makeText(getBaseContext(), "gagal submit", Toast.LENGTH_LONG).show();
        btnSubmit.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String namarestoran = InputRestoran.getText().toString();
        String alamat = InputAlamat.getText().toString();
        String menu = InputMenu.getText().toString();
        String harga = InputHarga.getText().toString();
        String fasilitas = InputFasilitas.getText().toString();
        String hp = InputHP.getText().toString();
        String latitude = InputLatitude.getText().toString();
        String longitude = InputLongitude.getText().toString();

        if (namarestoran.isEmpty()) {
            InputRestoran.setError("Masukkan nama restoran");
            valid = false;
        } else {
            InputRestoran.setError(null);
        }

        if (alamat.isEmpty()) {
            InputAlamat.setError("Masukkan alamat restoran");
            valid = false;
        } else {
            InputAlamat.setError(null);
        }

        if (menu.isEmpty()) {
            InputMenu.setError("Masukkan menu andalan restoran");
            valid = false;
        } else {
            InputMenu.setError(null);

        }

        if (harga.isEmpty()) {
            InputHarga.setError("Masukkan harga minimal restoran");
            valid = false;
        } else {
            InputHarga.setError(null);

        }
        if (fasilitas.isEmpty()) {
            InputFasilitas.setError("Masukkan fasilitas restoran");
            valid = false;
        } else {
            InputFasilitas.setError(null);

        }
        if (hp.isEmpty()) {
            InputHP.setError("Masukkan nomor telepon restoran");
            valid = false;
        } else {
            InputHP.setError(null);

        }
        if (latitude.isEmpty()) {
            InputLatitude.setError("Masukkan latitude restoran");
            valid = false;
        } else {
            InputLatitude.setError(null);

        }
        if (longitude.isEmpty()) {
            InputLongitude.setError("Masukkan longitude restoran");
            valid = false;
        } else {
            InputLongitude.setError(null);

        }

        return valid;

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public void onClick(View v) {
        // 1. on Upload click call ACTION_GET_CONTENT intent
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        // 2. pick image only
        intent.setType("image/*");
        // 3. start activity
        startActivityForResult(intent, 0);

        // define onActivityResult to do something with picked image
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        if(resCode == Activity.RESULT_OK && data != null){
            String realPath;
            // SDK < API11
            if (Build.VERSION.SDK_INT < 11)
                realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(this, data.getData());

                // SDK >= 11 && SDK < 19
            else if (Build.VERSION.SDK_INT < 19)
                realPath = RealPathUtil.getRealPathFromURI_API11to18(this, data.getData());

                // SDK > 19 (Android 4.4)
            else
                realPath = RealPathUtil.getRealPathFromURI_API19(this, data.getData());


            setTextViews(Build.VERSION.SDK_INT, data.getData().getPath(),realPath);
        }
    }

    private void setTextViews(int sdk, String uriPath,String realPath){

        this.txtRealPath.setText("Real Path: "+realPath);

        Uri uriFromPath = Uri.fromFile(new File(realPath));

        // you have two ways to display selected image

        // ( 1 ) imageView.setImageURI(uriFromPath);

        // ( 2 ) imageView.setImageBitmap(bitmap);
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uriFromPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Log.d("HMKCODE", "Real Path: "+realPath);
    }

}
