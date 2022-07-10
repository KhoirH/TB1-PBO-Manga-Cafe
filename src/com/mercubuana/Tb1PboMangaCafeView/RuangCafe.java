package com.mercubuana.Tb1PboMangaCafeView;

import java.io.Serializable;

public class RuangCafe implements Serializable {
	private int idPembooking;
	private String namaPembooking;
	private String namaRuangan;
	private String jenisRuangan;
	private int jumlahSlotSewaHarian;
	private int sisaSLotSewaHarian;
	
	public RuangCafe(int idPembooking, String namaPembooking, String namaRuangan, String jenisRuangan, int jumlahSlotSewaHarian, int sisaSLotSewaHarian) {
		super();
		this.idPembooking = idPembooking;
		this.namaPembooking = namaPembooking;
		this.namaRuangan = namaRuangan;
		this.jenisRuangan = jenisRuangan;
		this.jumlahSlotSewaHarian = jumlahSlotSewaHarian;
		this.sisaSLotSewaHarian = sisaSLotSewaHarian;
	}
	
	public int getIdPembooking() {
		return idPembooking;
	}
	
	public void setIdPembooking(int idPembooking) {
		this.idPembooking = idPembooking;
	}

	public String getNamaPembooking() {
		return namaPembooking;
	}

	public void setNamaPembooking(String namaPembooking) {
		this.namaPembooking = namaPembooking;
	}

	public String getNamaRuangan() {
		return namaRuangan;
	}

	public void setNamaRuangan(String namaRuangan) {
		this.namaRuangan = namaRuangan;
	}

	public String getJenisRuangan() {
		return jenisRuangan;
	}

	public void setJenisRuangan(String jenisRuangan) {
		this.jenisRuangan = jenisRuangan;
	}

	public int getJumlahSlotSewaHarian() {
		return jumlahSlotSewaHarian;
	}

	public void setJumlahSlotSewaHarian(int jumlahSlotSewaHarian) {
		this.jumlahSlotSewaHarian = jumlahSlotSewaHarian;
	}

	public int getSisaSLotSewaHarian() {
		return sisaSLotSewaHarian;
	}

	public void setSisaSLotSewaHarian(int sisaSLotSewaHarian) {
		this.sisaSLotSewaHarian = sisaSLotSewaHarian;
	}
	
	
}
