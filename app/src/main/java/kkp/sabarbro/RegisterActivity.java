package kkp.sabarbro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String REGISTER_URL = "http://amranswandy.com/KKP_Rizky/registerbismillah.php";

    public static final String KEY_EMAIL = "email";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    private EditText editTextEmail;
    private EditText editTextUsername;
    private EditText editTextPassword;

    private Button buttonRegister;
    private TextView gotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextEmail= (EditText) findViewById(R.id.editTextEmail);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);


        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        gotoLogin = (TextView) findViewById(R.id.gotoLogin);

        buttonRegister.setOnClickListener(this);
        gotoLogin.setOnClickListener(this);
    }

    private void registerUser(){
        final String email = editTextEmail.getText().toString().trim();
        if (email.trim().equals("")) {
            Toast.makeText(this, "Masukkan email anda", Toast.LENGTH_SHORT).show();
            return;
        }
        final String username = editTextUsername.getText().toString().trim();
        if (username.trim().equals("")) {
            Toast.makeText(this, "Masukkan username anda", Toast.LENGTH_SHORT).show();
            return;
        }
        final String password = editTextPassword.getText().toString().trim();
        if (password.trim().equals("")) {
            Toast.makeText(this, "Masukkan password anda", Toast.LENGTH_SHORT).show();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RegisterActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_EMAIL,email);
                params.put(KEY_USERNAME,username);
                params.put(KEY_PASSWORD,password);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonRegister){
            registerUser();
        }
        if(v == gotoLogin){
            startActivity(new Intent(this,LoginActivity.class));
        }
    }
    @Override
    public void onBackPressed() {
    }
}
