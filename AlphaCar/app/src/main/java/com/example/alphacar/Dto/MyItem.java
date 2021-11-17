package com.example.alphacar.Dto;

import java.io.Serializable;

/**
 * Created by LG on 2017-02-08.
 */

public class MyItem implements Serializable {
    /*public String id;
    public String name;
    public String hire_date;
    public String image_path;

    public MyItem(String id, String name, String hire_date, String image_path) {
        this.id = id;
        this.name = name;
        this.hire_date = hire_date;
        this.image_path = image_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return hire_date;
    }

    public void setDate(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
*/
    int store_number,inventory, store_favorite_cnt;
    String customer_email, store_name, store_addr, store_tel,
            store_time, store_dayoff, introduce, picture, store_price, store_master_name
            , store_registration_number;

    public MyItem(int store_number, int inventory, int store_favorite_cnt, String customer_email, String store_name, String store_addr, String store_tel, String store_time, String store_dayoff, String introduce, String picture, String store_price, String store_master_name, String store_registration_number) {
        this.store_number = store_number;
        this.inventory = inventory;
        this.store_favorite_cnt = store_favorite_cnt;
        this.customer_email = customer_email;
        this.store_name = store_name;
        this.store_addr = store_addr;
        this.store_tel = store_tel;
        this.store_time = store_time;
        this.store_dayoff = store_dayoff;
        this.introduce = introduce;
        this.picture = picture;
        this.store_price = store_price;
        this.store_master_name = store_master_name;
        this.store_registration_number = store_registration_number;
    }

    public MyItem(int store_number, int inventory, String customer_email, String store_name) {
        this.store_number = store_number;
        this.inventory = inventory;
        this.customer_email = customer_email;
        this.store_name = store_name;
    }

    public int getStore_number() {
        return store_number;
    }

    public void setStore_number(int store_number) {
        this.store_number = store_number;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getStore_favorite_cnt() {
        return store_favorite_cnt;
    }

    public void setStore_favorite_cnt(int store_favorite_cnt) {
        this.store_favorite_cnt = store_favorite_cnt;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
}
