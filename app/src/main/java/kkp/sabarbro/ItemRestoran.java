package kkp.sabarbro;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

/**
 * Created by rizky on 12/06/2017.
 */

public class ItemRestoran implements ClusterItem {

    private final LatLng mPosition;
    private  String GambarRestoran, NamaRestoran, AlamatRestoran, Menu, Harga, Fasilitas, Hp;
    public ItemRestoran(String gambar, String nama, String alamat, String menu, String harga, String fasilitas, String hp,double latitude, double longitude) {
        mPosition = new LatLng(latitude, longitude);

        NamaRestoran =  nama;
        GambarRestoran = gambar;
        AlamatRestoran = alamat;
        Harga = harga;
        Menu = menu;
        Fasilitas = fasilitas;
        Hp = hp;

    }

    @Override
    public LatLng getPosition() {

        return mPosition;
    }
    public String getGambar() {
        return GambarRestoran;
    }

    public String getAlamat() {
        return AlamatRestoran;
    }

    public String getMenu() {
        return Menu;
    }

    public String getHarga() {
        return Harga;
    }
    public String getFasilitas() {
        return Fasilitas;
    }

    public String getHp() {
        return Hp;
    }
    public String getNama() {
        return NamaRestoran;
    }
}

class MyClusterRenderer extends DefaultClusterRenderer<ItemRestoran> {

    public MyClusterRenderer(Context context, GoogleMap map,
                             ClusterManager<ItemRestoran> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected void onBeforeClusterItemRendered(ItemRestoran item, MarkerOptions markerOptions) {
        super.onBeforeClusterItemRendered(item, markerOptions);
        markerOptions.title(item.getNama());
    }

}
