package kkp.sabarbro;

/**
 * Created by rizky on 12/06/2017.
 */

public class DataRestoran {

    private String GambarRestoran,NamaRestoran,AlamatRestoran,Menu,Harga,Fasilitas,Hp;


    public DataRestoran(String gambar, String nama, String alamat, String menu, String harga, String fasilitas, String hp) {

        GambarRestoran = gambar;
        NamaRestoran =  nama;
        AlamatRestoran = alamat;
        Menu = menu;
        Harga = harga;
        Fasilitas = fasilitas;
        Hp = hp;
    }

    public String getGambar() {
        return GambarRestoran;
    }


    public String getNama() {
        return NamaRestoran;
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


}
