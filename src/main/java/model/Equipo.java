package model;

import java.io.Serializable;

public class Equipo implements Serializable{
    
    private Integer IDEQU;
    private Integer IDMAR;
    private Integer IDTIPEQU;
    private String MODEQU;
    private String ESTEQU;

    public Integer getIDEQU() {
        return IDEQU;
    }

    public void setIDEQU(Integer IDEQU) {
        this.IDEQU = IDEQU;
    }

    public Integer getIDMAR() {
        return IDMAR;
    }

    public void setIDMAR(Integer IDMAR) {
        this.IDMAR = IDMAR;
    }

    public Integer getIDTIPEQU() {
        return IDTIPEQU;
    }

    public void setIDTIPEQU(Integer IDTIPEQU) {
        this.IDTIPEQU = IDTIPEQU;
    }

    public String getMODEQU() {
        return MODEQU;
    }

    public void setMODEQU(String MODEQU) {
        this.MODEQU = MODEQU;
    }

    public String getESTEQU() {
        return ESTEQU;
    }

    public void setESTEQU(String ESTEQU) {
        this.ESTEQU = ESTEQU;
    }
    
}
