package kkp.sabarbro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;
import android.os.Handler;

public class ActivityUserProfile extends AppCompatActivity {

    private TextView textView;
    private TextView textUser;
    private static int splashInterval = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_profile);

        textView = (TextView) findViewById(R.id.txtSelamatDatang);
        textUser = (TextView) findViewById(R.id.txtuser);


        Intent intent = getIntent();

        textView.setText("Selamat Datang ");
        textUser.setText(intent.getStringExtra(LoginActivity.KEY_USERNAME));

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(ActivityUserProfile.this, MainActivity.class);
                startActivity(i); // menghubungkan activity splashscren ke main activity dengan intent


                //jeda selesai Splashscreen
                this.finish();
            }

            private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval);

    }
}
