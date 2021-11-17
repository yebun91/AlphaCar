package com.example.alphacar.Dto;

public class MemberDTO {
    private String customer_email,customer_pw, customer_name, admin, customer_picture;


    // 암호 없이 멤버정보를 가져올때
    public MemberDTO(String customer_email, String customer_name, String admin, String customer_picture) {
        this.customer_email = customer_email;
        this.customer_name = customer_name;
        this.admin = admin;
        this.customer_picture = customer_picture;
    }

    // 데이터베이스에 멤버정보를 추가할때


    public MemberDTO(String customer_email, String customer_pw, String customer_name, String admin, String customer_picture) {
        this.customer_email = customer_email;
        this.customer_pw = customer_pw;
        this.customer_name = customer_name;
        this.admin = admin;
        this.customer_picture = customer_picture;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_pw() {
        return customer_pw;
    }

    public void setCustomer_pw(String customer_pw) {
        this.customer_pw = customer_pw;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getCustomer_picture() {
        return customer_picture;
    }

    public void setCustomer_picture(String customer_picture) {
        this.customer_picture = customer_picture;
    }
}
