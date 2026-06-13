import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // deklarasi array
        ArrayList<Hewan> hewans = new ArrayList<>();

        // polimirpism
        Hewan k1 = new Kucing("A",10,Gender.LAKILAKI,1000000, "Orange");
        Hewan k2 = new Kucing("B",12,Gender.PEREMPUAN,1100000, "Hitam");

        // Menambahkan ke array
        hewans.add(k1);
        hewans.add(k2);

        // foreach untuk menampilkan semua data
        for (Hewan h : hewans) {
            h.info();
            System.out.println("Ini yang info lengkap");
            h.info(true);
            System.out.println("Suara:");
            h.suara();
            System.out.println();
        }

        // test untuk setter dan getter
        System.out.println();
        System.out.println("Nama sebelum diubah: "+k1.getNama());
        k1.setNama("K");
        System.out.println("Nama sebelum diubah: "+k1.getNama());

        System.out.println("Nama sebelum diubah: "+k2.getNama());
        k2.setNama("LP");
        System.out.println("Nama sesudah diubah: "+k2.getNama());

    }
}

// class abstract
abstract class Hewan {
    private String nama;
    private int umur;
    private Gender gender;
    private int harga;

    public Hewan(String nama, int umur, Gender gender, int harga) {
        this.nama = nama;
        this.umur = umur;
        this.gender = gender;
        this.harga = harga;
    }

    // getter setter
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }
    public void setUmur(int umur) {
        this.umur = umur;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
    }

    // abstract method
    abstract void suara();
    abstract void info();
    abstract void info(boolean status);
}

class Kucing extends Hewan implements Pajak{
    private String warna;

    public Kucing(String nama, int umur, Gender gender, int harga,String warna) {
        super(nama, umur, gender, harga);
        this.warna = warna;
    }

    // getter setter
    public String getWarna() {
        return warna;
    }
    public void setWarna(String warna) {
        this.warna = warna;
    }

    // override untuk suara dan info
    @Override
    void suara() {
        System.out.println("Miauwww");
    }
    @Override
    void info() {
        System.out.println("Kucing:");
        System.out.println("Warna   : "+getWarna());
    }
    // overloading untuk emnampilkan info yang lebih lengkap
    void info(boolean status) {
        info();

        if (status) {
            System.out.println("Nama    : "+getNama());
            System.out.println("Umur    : "+getUmur());
            System.out.println("Gender  : "+getGender());
            System.out.println("Harga   : "+jumlahPajak());
        }
    }

    // untuk menghitung harga
    @Override
    public int jumlahPajak() {
        return getHarga() + pajak;
    }
}

// interface untuk menghitung pajak
interface Pajak {
    // final untuk nilai pajak yang constanta
    final int pajak = 10000;
    // untuk menghitung pajak
    abstract int jumlahPajak();
}

// enum gender
enum Gender {
    LAKILAKI,PEREMPUAN
}