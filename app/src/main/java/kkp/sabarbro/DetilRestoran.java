package kkp.sabarbro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by rizky on 12/06/2017.
 */

public class DetilRestoran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detil_layout_restoran);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //buat Tulisan ke Tengah
        final ActionBar abar = getSupportActionBar();
        View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView textJudul = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);

        assert abar != null;
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(true);
        abar.setHomeButtonEnabled(true);
        //sampai disini

        Intent i = getIntent();
        String gambar = i.getStringExtra("gam_id_key");
        String harga = i.getStringExtra("hrg_id_key");
        String alamat = i.getStringExtra("alm_id_key");
        String menu = i.getStringExtra("menu_id_key");
        String judul = i.getStringExtra("jdl_id_key");
        String fasilitas = i.getStringExtra("fas_id_key");
        String hp = i.getStringExtra("hp_id_key");


        TextView txtHarga = (TextView) findViewById(R.id.textHarga);
        TextView txtAlamat = (TextView) findViewById(R.id.textAlamat);
        TextView txtFas = (TextView) findViewById(R.id.textFasi);
        TextView txtMenu = (TextView) findViewById(R.id.textMenu);
        TextView txtNohp = (TextView) findViewById(R.id.textnohp);

        ImageView img = (ImageView) findViewById(R.id.gambar);
        Glide.with(this).load("http://masgandos.pe.hu/sabarbro/gambar_resto/" + gambar)
                .error(R.drawable.wait)
                .into(img);
        textJudul.setText(judul);
        txtMenu.setText("Menu: " + menu);
        txtHarga.setText("Mulai dari : Rp" + harga);
        txtAlamat.setText("Alamat : " + alamat);
        txtFas.setText("Fasilitas : " + fasilitas);
        txtNohp.setText("No.Handphone : " + hp);


    }
}
