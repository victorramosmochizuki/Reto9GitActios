package model;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class Software {
    
    private Integer IDSOF;
    private Integer IDDETEQU;
    private String SOFTWARE;
    private Date INIGAR = Timestamp.from(Instant.now());
    private Date FINGAR = Timestamp.from(Instant.now());
    private String ESTSOF;

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
