package com.mercubuana.Tb1PboMangaCafeView;

import java.io.Serializable;

public class RuangCafe implements Serializable {
	private String namaRuang;
    private char jenisRuang;
    private int jumlahSlotSewaHarian;
    private int sisaSlotSewaHarian;

    public RuangCafe(String namaRuang, char jenisRuang, int jumlahSlotSewaHarian, int sisaSlotSewaHarian) {
        this.namaRuang = namaRuang;
        this.jenisRuang = jenisRuang;
        this.jumlahSlotSewaHarian = jumlahSlotSewaHarian;
        this.sisaSlotSewaHarian = sisaSlotSewaHarian;
    }

	public String getNamaRuang() {
		return namaRuang;
	}

	public void setNamaRuang(String namaRuang) {
		this.namaRuang = namaRuang;
	}

	public char getJenisRuang() {
		return jenisRuang;
	}

	public void setJenisRuang(char jenisRuang) {
		this.jenisRuang = jenisRuang;
	}

	public int getJumlahSlotSewaHarian() {
		return jumlahSlotSewaHarian;
	}

	public void setJumlahSlotSewaHarian(int jumlahSlotSewaHarian) {
		this.jumlahSlotSewaHarian = jumlahSlotSewaHarian;
	}

	public int getSisaSlotSewaHarian() {
		return sisaSlotSewaHarian;
	}

	public void setSisaSlotSewaHarian(int sisaSlotSewaHarian) {
		this.sisaSlotSewaHarian = sisaSlotSewaHarian;
	}
    
}
