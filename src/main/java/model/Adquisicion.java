package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class Adquisicion implements Serializable{

    private Integer IDADQ;
    private Integer IDPRO;
    private Integer CANTIDAD;
    private Date FECCOM = Timestamp.from(Instant.now());
    private Date FECADQ = Timestamp.from(Instant.now());
    private String CODADQ;
    private String ESTADQ;

    public Integer getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(Integer CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }
    
    
    
    public Integer getIDADQ() {
        return IDADQ;
    }

    public void setIDADQ(Integer IDADQ) {
        this.IDADQ = IDADQ;
    }

    public Integer getIDPRO() {
        return IDPRO;
    }

    public void setIDPRO(Integer IDPRO) {
        this.IDPRO = IDPRO;
    }
    public Date getFECCOM() {
        return FECCOM;
    }

    public void setFECCOM(Date FECCOM) {
        this.FECCOM = FECCOM;
    }

    public Date getFECADQ() {
        return FECADQ;
    }

    public void setFECADQ(Date FECADQ) {
        this.FECADQ = FECADQ;
    }

    public String getESTADQ() {
        return ESTADQ;
    }

    public void setESTADQ(String ESTADQ) {
        this.ESTADQ = ESTADQ;
    }

    public String getCODADQ() {
        return CODADQ;
    }

    public void setCODADQ(String CODADQ) {
        this.CODADQ = CODADQ;
    }



    
}
