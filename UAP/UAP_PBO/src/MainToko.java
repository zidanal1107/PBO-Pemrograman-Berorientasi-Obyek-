import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainToko {
    public static void main(String[] args) {
        ArrayList<Produk> produks = new ArrayList();
        Scanner in = new Scanner(System.in);
        String prod1 = "Ponsel";
        String prod2 = "Laptop";
        double harga1 = (double)400000.0F;
        double harga2 = (double)550000.0F;
        Produk gadget1 = new Gadget(prod1, harga1);
        Gadget gadget2 = new Gadget(prod2, harga2);
        gadget1.beli();
        System.out.println();
        gadget2.beli((double)3.0F);
        produks.add(gadget1);
        produks.add(gadget2);
        System.out.println();
        System.out.println("Produk yang dibeli:");

        for(Produk p : produks) {
            p.info();
        }

        System.out.println();
        System.out.println("Produk Laptop sebelum nama diganti: " + gadget2.getNamaProduk());
        System.out.print("Masukkan nama pengganti: ");
        prod2 = in.nextLine();
        gadget2.setNamaProduk(prod2);
        System.out.println("Berhasil di ubah menjadi: " + gadget2.getNamaProduk());

        try {
            System.out.println("Produk Laptop sebelum harga diganti: " + gadget2.getHarga());
            System.out.print("Masukkan harga pengganti: ");
            harga2 = in.nextDouble();
            gadget2.setHarga(harga2);
            System.out.println("Berhasil di ubah menjadi: " + gadget2.getHarga());
        } catch (Exception var13) {
            System.out.println("ERROR Cuman bisa memasukkan angka");
            System.out.println("Gagal di ubah");
            return;
        }

        System.out.println();
        System.out.println("Produk yang dibeli setelah di ubah:");

        for(Produk p : produks) {
            p.info();
        }

    }
}

abstract class Produk {
    private String namaProduk;

    public Produk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getNamaProduk() {
        return this.namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public abstract void beli();

    public abstract void beli(double var1);

    public abstract void info();
}

class Gadget extends Produk implements HitungHarga {
    private double harga;

    public Gadget(String namaProduk, double harga) {
        super(namaProduk);
        this.harga = harga;
    }

    public double getHarga() {
        return this.harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void beli() {
        System.out.println("Anda sedang membeli gadget dengan nama: " + this.getNamaProduk());
        System.out.println("Dengan harga: " + this.getHarga());
        System.out.println("Harga dengan pajak: " + this.hitungHarga());
        System.out.println("Anda tidak memasukkan jumlah barang jadi kehitung membeli satu");
    }

    public void beli(double jumlah) {
        if (jumlah < (double)1.0F) {
            System.out.println("Jumlah tidak boleh kurang dari 1");
        } else {
            double hargaTotal = this.getHarga() * jumlah;
            System.out.println("Anda sedang membeli gadget dengan nama: " + this.getNamaProduk());
            System.out.println("Jumlah barang: " + jumlah);
            System.out.println("Harga tanpa pajak: " + hargaTotal);
            PrintStream var10000 = System.out;
            double var10001 = this.hitungHarga(hargaTotal);
            var10000.println("Harga dengan pajak: " + var10001);
        }
    }

    public void info() {
        System.out.println("Nama produk yang dibeli: " + this.getNamaProduk());
    }

    public double hitungHarga(double hargaTotal) {
        return hargaTotal + hargaTotal * 0.1;
    }

    public double hitungHarga() {
        return this.getHarga() + this.getHarga() * 0.1;
    }
}

interface HitungHarga {
    double pajak = 0.1;

    double hitungHarga();

    double hitungHarga(double var1);
}