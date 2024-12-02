import java.util.Scanner;

public class Tugas {
    static String[][ ] dataKRS = new String[100][5];
    int jumlahData=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("=======Menu Utama=======");
            System.out.println("1. Tambahkan Data KRS Mahasiswa");
            System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("3. Analisis Mahasiswa dengan SKS kurang dari 20");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            if (pilihan==1){
                tambahData(sc);
            } else if (pilihan==2){
                tampilDaftar(sc);
            } else if (pilihan==3){
                analisisJumlah();
            } else if (pilihan==4){
                System.out.println("Keluar dari program.");
            } else {
                System.out.println("Pilihan tidak valid! Silahkan input ulang!");
            }
        } while (pilihan !=4);
    }

    static void tambahData(Scanner sc){

    }

    static void tampilDaftar(Scanner sc){

    }

    static void analisisJumlah(){
        
    }
    
}