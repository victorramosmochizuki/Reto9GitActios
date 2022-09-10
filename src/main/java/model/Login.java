package model;

import java.io.Serializable;

public class Login implements Serializable {

    private Integer IDLOG;
    private String NOMPER;
    private String APEPER;
    private String DNIPER;
    private String SEXPER;
    private String TIPPER;
    private String USEPER;
    private String PASSPER;
    private String ESTLOG;

    public Integer getIDLOG() {
        return IDLOG;
    }

    public void setIDLOG(Integer IDLOG) {
        this.IDLOG = IDLOG;
    }

    public String getNOMPER() {
        return NOMPER;
    }

    public void setNOMPER(String NOMPER) {
        this.NOMPER = NOMPER;
    }

    public String getAPEPER() {
        return APEPER;
    }

    public void setAPEPER(String APEPER) {
        this.APEPER = APEPER;
    }

    public String getDNIPER() {
        return DNIPER;
    }

    public void setDNIPER(String DNIPER) {
        this.DNIPER = DNIPER;
    }

    public String getSEXPER() {
        return SEXPER;
    }

    public void setSEXPER(String SEXPER) {
        this.SEXPER = SEXPER;
    }

    public String getTIPPER() {
        return TIPPER;
    }

    public void setTIPPER(String TIPPER) {
        this.TIPPER = TIPPER;
    }

    public String getUSEPER() {
        return USEPER;
    }

    public void setUSEPER(String USEPER) {
        this.USEPER = USEPER;
    }

    public String getPASSPER() {
        return PASSPER;
    }

    public void setPASSPER(String PASSPER) {
        this.PASSPER = PASSPER;
    }

    public String getESTLOG() {
        return ESTLOG;
    }

    public void setESTLOG(String ESTLOG) {
        this.ESTLOG = ESTLOG;
    }


}
