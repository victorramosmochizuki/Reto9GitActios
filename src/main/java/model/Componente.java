package model;

import java.io.Serializable;

public class Componente implements Serializable{
    
    private Integer IDCOM;
    private Integer IDDETEQU;
    private String CLAVE;
    private String VALOR;
    private String ESTCOM;

    public String getESTCOM() {
        return ESTCOM;
    }

    public void setESTCOM(String ESTCOM) {
        this.ESTCOM = ESTCOM;
    }

    public Integer getIDCOM() {
        return IDCOM;
    }

    public void setIDCOM(Integer IDCOM) {
        this.IDCOM = IDCOM;
    }

    public Integer getIDDETEQU() {
        return IDDETEQU;
    }

    public void setIDDETEQU(Integer IDDETEQU) {
        this.IDDETEQU = IDDETEQU;
    }

    public String getCLAVE() {
        return CLAVE;
    }

    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
    }

    public String getVALOR() {
        return VALOR;
    }

    public void setVALOR(String VALOR) {
        this.VALOR = VALOR;
    }
        
}
