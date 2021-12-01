package homeMypage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeStoreVO {
	private int store_number               ;
	private String customer_email             ;
	private String store_name                 ;
	private String store_addr                 ;
	private String store_tel                  ;
	private String store_time                 ;
	private String store_dayoff               ;
	private String introduce                  ;
	private int inventory                  ;
	private String store_price                ;
	private String store_master_name          ;
	private String store_registration_number  ;
	//private String imgpath  ;
	private int store_favorite_cnt         ;
	private ArrayList<String> now_state = new ArrayList<String>();
	//private ArrayList<String> imgpath = new ArrayList<String>();
	private ArrayList<String> imgname = new ArrayList<String>();
	private List<String> imgpath = new ArrayList<String>();
	private int file_id      ;
	private int rank         ;

	
	public List<String> getImgpath() {
		return imgpath;
	}
	public void setImgpath(List<String> imgpath) {
		this.imgpath = imgpath;
	}
	//	public String getImgpath() {
//		return imgpath;
//	}
//	public void setImgpath(String imgpath) {
//		this.imgpath = imgpath;
//	}
//	public ArrayList<String> getImgpath() {
//		return imgpath;
//	}
//	public void setImgpath(ArrayList<String> imgpath) {
//		this.imgpath = imgpath;
//	}
	public ArrayList<String> getImgname() {
		return imgname;
	}
	public void setImgname(ArrayList<String> imgname) {
		this.imgname = imgname;
	}
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setNow_state(ArrayList<String> now_state) {
		this.now_state = now_state;
	}
	public ArrayList<String> getNow_state() {
		return now_state;
	}
	public void setNow_state(String now_state) {
		this.now_state.add(now_state);
	}
	public int getStore_number() {
		return store_number;
	}
	public void setStore_number(int store_number) {
		this.store_number = store_number;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getStore_addr() {
		return store_addr;
	}
	public void setStore_addr(String store_addr) {
		this.store_addr = store_addr;
	}
	public String getStore_tel() {
		return store_tel;
	}
	public void setStore_tel(String store_tel) {
		this.store_tel = store_tel;
	}
	public String getStore_time() {
		return store_time;
	}
	public void setStore_time(String store_time) {
		this.store_time = store_time;
	}
	public String getStore_dayoff() {
		return store_dayoff;
	}
	public void setStore_dayoff(String store_dayoff) {
		this.store_dayoff = store_dayoff;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public String getStore_price() {
		return store_price;
	}
	public void setStore_price(String store_price) {
		this.store_price = store_price;
	}
	public String getStore_master_name() {
		return store_master_name;
	}
	public void setStore_master_name(String store_master_name) {
		this.store_master_name = store_master_name;
	}
	public String getStore_registration_number() {
		return store_registration_number;
	}
	public void setStore_registration_number(String store_registration_number) {
		this.store_registration_number = store_registration_number;
	}
	public int getStore_favorite_cnt() {
		return store_favorite_cnt;
	}
	public void setStore_favorite_cnt(int store_favorite_cnt) {
		this.store_favorite_cnt = store_favorite_cnt;
	}
	
	
	
	
}
