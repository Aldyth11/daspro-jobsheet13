import java.util.Scanner;

public class Kelompok3 {
    static String[][] dataKRS = new String[100][5];
    static int jumlahData = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan = 0;
        do {
            System.out.println("=======Menu Utama=======");
            System.out.println("1. Tambahkan Data KRS Mahasiswa");
            System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("3. Analisis Mahasiswa dengan SKS kurang dari 20");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            if (pilihan == 1) {
                tambahData(sc);
            } else if (pilihan == 2) {
                tampilDaftar(sc);
            } else if (pilihan == 3) {
                analisisJumlah();
            } else if (pilihan == 4) {
                System.out.println("Keluar dari program.");
            } else {
                System.out.println("Pilihan tidak valid! Silahkan input ulang!");
            }
        } while (pilihan != 4);
    }

    static void tambahData(Scanner sc) {
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        int totalSKS = hitungTotalSKS(nim);
        if (totalSKS >= 24) {
            System.out.println("Total SKS Mahasiswa sudah mencapai atau melebihi batas maksimal!");
            return;
        }

        System.out.print("Masukkan kode mata kuliah: ");
        String kodeMatKul = sc.nextLine();
        System.out.print("Masukkan nama mata kuliah: ");
        String namaMatKul = sc.nextLine();
        System.out.print("Masukkan jumlah SKS mata kuliah: ");
        String jmlhSKSString = sc.nextLine();
        int jumlahSKS = 0;
        for (int i = 0; i < jmlhSKSString.length(); i++) {
            jumlahSKS = jumlahSKS * 10 + (jmlhSKSString.charAt(i) - '0');
        }
        if (jumlahSKS < 1 || jumlahSKS > 3) {
            System.out.println("Jumlah SKS per mata kuliah harus antara 1-3");
            return;
        }
        if (totalSKS + jumlahSKS > 24) {
            System.out.println("Menambahkan mata kuliah ini akan melebihi batas maksimal!");
        }

        dataKRS[jumlahData][0] = nama;
        dataKRS[jumlahData][1] = nim;
        dataKRS[jumlahData][2] = kodeMatKul;
        dataKRS[jumlahData][3] = namaMatKul;
        dataKRS[jumlahData][4] = jmlhSKSString;
        jumlahData++;

        System.out.println("Data KRS berhasil ditambahkan.");

    }

    static void tampilDaftar(Scanner sc) {
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        int totalSKS = 0;
        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {
            if (dataKRS[i][1].equals(nim)) {
                ditemukan = true;
                int sks = 0;
                for (int j = 0; j < dataKRS[i][4].length(); j++) {
                    sks = sks * 10 + (dataKRS[i][4].charAt(j) - '0');
                }
                System.out.println("Daftar KRS untuk NIM "  + nim + ": ");
                System.out.println("Nama: " + dataKRS[i][0]);
                System.out.println("NIM: " + dataKRS[i][1]);
                System.out.println("Kode Mata Kuliah: " + dataKRS[i][2]);
                System.out.println("Nama Mata Kuliah: " + dataKRS[i][3]);
                System.out.println("Jumlah SKS: " + dataKRS[i][4]);

                totalSKS += sks;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada data KRS untuk NIM ini.");
        } else {
            System.out.println("Total SKS yang diambil: " + totalSKS);
        }
    }

        

    static void analisisJumlah() {
        String [] daftarNIM = new String [100];
        int[] totalSKS = new int[100];
        int jumlahMahasiswa = 0; 
        for (int i = 0; i < jumlahData; i++) {
            String nim = dataKRS[i][1];
            boolean ditemukan = false;

            for (int j = 0; j < jumlahMahasiswa; j++) {
                if (daftarNIM[j].equals(nim)) {
                    int sks = 0;
                    for (int k = 0; k < dataKRS[i][4].length(); k++) {
                        sks = sks * 10 + (dataKRS[i][4].charAt(k) - '0');
                    }
                    totalSKS[j] += sks;
                    ditemukan = true;
                    break;
                }
            }
            if (!ditemukan) {
                daftarNIM[jumlahMahasiswa] = nim;
                int sks = 0;
                for (int k = 0; k < dataKRS[i][4].length(); k++) {
                    sks = sks * 10 + (dataKRS[i][4].charAt(k) - '0');
                }
                totalSKS[jumlahMahasiswa] = sks;
                jumlahMahasiswa++;
            }
        }

        boolean ada = false;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (totalSKS[i] < 20) {
                ada = true;
                System.out.println("Mahasiswa dengan total SKS kurang dari 20: " + jumlahMahasiswa);
            }
        }

        if (!ada) {
            System.out.println("Semua mahasiswa telah mengambil SKS 20 atau lebih.");
        }
    }


    static int hitungTotalSKS(String nim) {
        int totalSKS = 0;
        for (int i = 0; i < jumlahData; i++) {
            if (dataKRS[i][1].equals(nim)) {
                for (int j = 0; j < dataKRS[i][4].length(); j++) {
                    totalSKS = totalSKS * 10 + (dataKRS[i][4].charAt(j) - '0');
                }
            }
        }
        return totalSKS;
    }

}