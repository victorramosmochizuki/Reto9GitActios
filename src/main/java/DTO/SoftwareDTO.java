package DTO;

import java.util.Date;

public class SoftwareDTO {

    private Integer IDSOF;
    private Integer IDDETEQU;
    private String detalle;
    private String SOFTWARE;
    private Date INIGAR;
    private Date FINGAR;
    private String ESTSOF;

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getIDSOF() {
        return IDSOF;
    }

    public void setIDSOF(Integer IDSOF) {
        this.IDSOF = IDSOF;
    }

    public Integer getIDDETEQU() {
        return IDDETEQU;
    }

    public void setIDDETEQU(Integer IDDETEQU) {
        this.IDDETEQU = IDDETEQU;
    }

    public String getSOFTWARE() {
        return SOFTWARE;
    }

    public void setSOFTWARE(String SOFTWARE) {
        this.SOFTWARE = SOFTWARE;
    }

    public Date getINIGAR() {
        return INIGAR;
    }

    public void setINIGAR(Date INIGAR) {
        this.INIGAR = INIGAR;
    }

    public Date getFINGAR() {
        return FINGAR;
    }

    public void setFINGAR(Date FINGAR) {
        this.FINGAR = FINGAR;
    }

    public String getESTSOF() {
        return ESTSOF;
    }

    public void setESTSOF(String ESTSOF) {
        this.ESTSOF = ESTSOF;
    }
}
