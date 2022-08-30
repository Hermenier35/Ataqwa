package com.example.ataqwa.Modèles;

public class Eleve {

    private int ideleve;
    private String prenom;
    private String nom;
    private String birthday;
    private char sex;
    private int idparent;

    public Eleve(int ideleve, String prenom, String nom, String birthday, char sex, int idparent) {
        this.ideleve = ideleve;
        this.prenom = prenom;
        this.nom = nom;
        this.birthday = birthday;
        this.sex = sex;
        this.idparent = idparent;
    }

    public int getIdeleve() {
        return ideleve;
    }

    public void setIdeleve(int ideleve) {
        this.ideleve = ideleve;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getIdparent() {
        return idparent;
    }

    public void setIdparent(int idparent) {
        this.idparent = idparent;
    }
}
