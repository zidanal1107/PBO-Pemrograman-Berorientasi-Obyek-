import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String merk1 = "a";
        String merk2 = "b";

        double harga1 = 200000;
        double harga2 = 220000;

        int volumeAwal1 = 50;
        int volumeAwal2 = 90;

        Perangkat t1 = new Televisi(merk1, harga1, volumeAwal1);
        Televisi t2 = new Televisi(merk2, harga2, volumeAwal2);

        ArrayList<Perangkat> perangkats = new ArrayList<>();

        perangkats.add(t1);
        perangkats.add(t2);

        for (Perangkat p : perangkats) {
            System.out.println("Info tidak detail");
            p.info();
            System.out.println("Info yang detail");
            p.info(true);
            System.out.println();
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Merk televisi1 sebelum diganti: "+t1.getMerk());
        System.out.print("Masukkan merk untuk televisi: ");
        merk1 = in.nextLine();
        t1.setMerk(merk1);
        System.out.println("Setelah diubah: "+t1.getMerk());

        System.out.println("Harga televisi1 sebelum diganti: "+t1.getHarga());
        System.out.print("Masukkan harga untuk televisi: ");
        harga1 = in.nextDouble();
        in.nextLine();
        t1.setHarga(harga1);
        System.out.println("Setelah diubah: "+t1.getHarga());

        t2.operasikan();
        System.out.println("Ubah volume? (0 untuk tidak ubah 1 untuk ubah): ");
        int pilihan = in.nextInt();
        in.nextLine();
        if (pilihan == 1) {
            System.out.println("Volume awal: "+t2.getVolume());
            System.out.println("Ubah volume: ");
            volumeAwal2 = in.nextInt();
            t2.setVolume(volumeAwal2);
            in.nextLine();
            System.out.println("Berhasil di ubah");
            t2.operasikan();
        } else {
            System.out.println("Gagal diubah");
        }

    }
}

abstract class Perangkat {
    private String merk;
    private double harga;

    public Perangkat(String merk, double harga) {
        this.merk = merk;
        this.harga = harga;
    }

    public String getMerk() {
        return merk;
    }
    public void setMerk(String merk) {
        this.merk = merk;
    }

    public double getHarga() {
        return harga;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }

    public abstract void operasikan();
    public abstract void info();
    public abstract void info(boolean detail);
}

class Televisi extends Perangkat implements HitungPajak{
    private int volume;

    public Televisi(String merk, double harga, int volume) {
        super(merk, harga);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void operasikan() {
        System.out.printf("Televisi dengan merk %s sedang di operasikan",getMerk());
        System.out.println("Dengan volume: "+getVolume());
    }

    @Override
    public void info() {
        System.out.println("Televisi:");
        System.out.println("Merk    : "+getMerk());
    }

    @Override
    public void info(boolean detail) {
        info();
        if (detail) {
            System.out.println("Harga   : "+getHarga());
            System.out.println("Volume  : "+getVolume());
        }
    }

    @Override
    public double HitungHarga() {
        return getHarga() + pajak;
    }
}

interface HitungPajak {
    final double pajak = 0.9;
    abstract double HitungHarga();
}