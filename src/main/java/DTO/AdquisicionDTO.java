package DTO;

import java.io.Serializable;
import java.util.Date;

public class AdquisicionDTO implements Serializable{

    private Integer IDADQ;
    private Integer IDPRO;
    private String Proovedor;
    private Integer CANTIDAD;
    private Date FECCOM;
    private Date FECADQ;
    private String ESTADQ;
    private String CODADQ;

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

    public String getProovedor() {
        return Proovedor;
    }

    public void setProovedor(String Proovedor) {
        this.Proovedor = Proovedor;
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
