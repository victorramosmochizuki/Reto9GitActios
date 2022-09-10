package model;

import java.io.Serializable;

public class Usuario implements Serializable{
    
    private Integer IDUSU;
    private Integer IDARE;
    private String NOMUSU;
    private String APEUSU;
    private String DNIUSU;
    private String CORREO;
    private String SEXUSU;
    private String TELUSU;
    private String TIPUSU;
    private String ESTUSU;

    public Integer getIDUSU() {
        return IDUSU;
    }

    public void setIDUSU(Integer IDUSU) {
        this.IDUSU = IDUSU;
    }

    public Integer getIDARE() {
        return IDARE;
    }

    public void setIDARE(Integer IDARE) {
        this.IDARE = IDARE;
    }

    public String getNOMUSU() {
        return NOMUSU;
    }

    public void setNOMUSU(String NOMUSU) {
        this.NOMUSU = NOMUSU;
    }

    public String getAPEUSU() {
        return APEUSU;
    }

    public void setAPEUSU(String APEUSU) {
        this.APEUSU = APEUSU;
    }

    public String getDNIUSU() {
        return DNIUSU;
    }

    public void setDNIUSU(String DNIUSU) {
        this.DNIUSU = DNIUSU;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getSEXUSU() {
        return SEXUSU;
    }

    public void setSEXUSU(String SEXUSU) {
        this.SEXUSU = SEXUSU;
    }

    public String getTELUSU() {
        return TELUSU;
    }

    public void setTELUSU(String TELUSU) {
        this.TELUSU = TELUSU;
    }

    public String getTIPUSU() {
        return TIPUSU;
    }

    public void setTIPUSU(String TIPUSU) {
        this.TIPUSU = TIPUSU;
    }

    public String getESTUSU() {
        return ESTUSU;
    }

    public void setESTUSU(String ESTUSU) {
        this.ESTUSU = ESTUSU;
    }
    
    
}
