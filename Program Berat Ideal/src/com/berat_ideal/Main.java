package com.berat_ideal;

import java.util.Scanner;
import java.time.LocalDate;

abstract class Pembuka{
    public abstract void pembuka_program();
}

class Opening extends Pembuka{
    @Override
    public void pembuka_program(){
        LocalDate tanggal_cek = LocalDate.now();

        System.out.println("===============================");
        System.out.println("     Menghitung Berat Ideal    ");
        System.out.println("        ----------------       ");
        System.out.println("\t\t   " + tanggal_cek);
        System.out.println("===============================");
    }
}

class Pengguna{
    private String nama;
    private String jenis_kelamin;
    private int tinggi;

    Scanner input = new Scanner(System.in);

    public void setNama(){
        System.out.print("Masukkan Nama          : ");
        this.nama = input.nextLine();
    }

    public String getJenis_kelamin(){
        return this.jenis_kelamin;
    }
    public void setJenis_kelamin(){
        System.out.print("Masukkan Jenis Kelamin : ");
        this.jenis_kelamin = input.nextLine();
    }

    public int getTinggi(){
        return this.tinggi;
    }
    public void setTinggi(){
        System.out.print("Masukkan Tinggi Badan  : ");
        this.tinggi = input.nextInt();
    }

    public void display(){
        System.out.println("-------------------------------");
        System.out.println("Nama            : " + this.nama);
        System.out.println("Jenis Kelamin   : " + this.jenis_kelamin);
        System.out.println("Tinggi Badan    : " + this.tinggi + " cm");
        System.out.println("Berat Ideal     : " + HitungBI.berat_ideal + " kg");
    }
}

class HitungBI{
    static double berat_ideal;

    HitungBI(String jenis_kelamin, int tinggi){
        if(jenis_kelamin.equals("Laki-laki")){
            berat_ideal = (tinggi-100) - ((tinggi-100) * 0.10);
        }else if(jenis_kelamin.equals("Perempuan")){
            berat_ideal = (tinggi-100) - ((tinggi-100) * 0.15);
        }else{
            System.out.println("Inputan Salah");
        }
    }
}

public class Main{
    public static void main(String[] args){
        Opening opening = new Opening();
        opening.pembuka_program();

        Pengguna pengguna1 = new Pengguna();
        pengguna1.setNama();
        pengguna1.setJenis_kelamin();
        pengguna1.setTinggi();
        HitungBI hitungBI = new HitungBI(pengguna1.getJenis_kelamin(), pengguna1.getTinggi());
        pengguna1.display();
    }
}