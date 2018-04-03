package kkp.sabarbro;

/**
 * Created by rizky on 12/06/2017.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.List;

public class AdapterRestoran extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataRestoran> data2= Collections.emptyList();


    // create constructor to innitilize context and data sent from FragmentList
    public AdapterRestoran(Context context, List<DataRestoran> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data2=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_restoran, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        DataRestoran current=data2.get(position);
        myHolder.nama1.setText(current.getNama());
        myHolder.alamat1.setText("Alamat: " + current.getAlamat());
        myHolder.harga1.setText("Mulai dari Rp " + current.getHarga());
        myHolder.harga1.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        myHolder.hp1.setText("Call: " + current.getHp());

        // load image into imageview using glide
        Glide.with(context).load("http://masgandos.pe.hu/sabarbro/gambar_resto/" + current.getGambar())
                .error(R.drawable.wait)
                .into(myHolder.ivRestoran1);

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data2.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView nama1;
        ImageView ivRestoran1;
        TextView alamat1;
        TextView harga1;
        TextView hp1;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            nama1= (TextView) itemView.findViewById(R.id.textNamaRestoran);
            ivRestoran1= (ImageView) itemView.findViewById(R.id.ivRestoran);
            alamat1 = (TextView) itemView.findViewById(R.id.textAlamat);
            harga1 = (TextView) itemView.findViewById(R.id.textHarga);
            hp1 = (TextView) itemView.findViewById(R.id.textHp);
        }

    }
}
