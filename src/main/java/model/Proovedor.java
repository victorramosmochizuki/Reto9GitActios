package model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Proovedor implements Serializable{

    private Integer IDPRO;
    
    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String RAZSOC;
    
    private String NOMCOM;

    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String RUC;

    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String VENDEDOR;

    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String EMAIL;

    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String NUMPRO;


    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String ESTPRO;

    public String getNOMCOM() {
        return NOMCOM;
    }

    public void setNOMCOM(String NOMCOM) {
        this.NOMCOM = NOMCOM;
    }

    public Proovedor() {
    }

    public Proovedor(Integer IDPRO, String CODUBI, String RAZSOC, String NOMCOM, String RUC, String VENDEDOR, String EMAIL, String NUMPRO, String ESTPRO) {
        this.IDPRO = IDPRO;
        this.RAZSOC = RAZSOC;
        this.NOMCOM = NOMCOM;
        this.RUC = RUC;
        this.VENDEDOR = VENDEDOR;
        this.EMAIL = EMAIL;
        this.NUMPRO = NUMPRO;
        this.ESTPRO = ESTPRO;
    }
        
    public String getESTPRO() {
        return ESTPRO;
    }

    public void setESTPRO(String ESTPRO) {
        this.ESTPRO = ESTPRO;
    }

    public Integer getIDPRO() {
        return IDPRO;
    }

    public void setIDPRO(Integer IDPRO) {
        this.IDPRO = IDPRO;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getNUMPRO() {
        return NUMPRO;
    }

    public void setNUMPRO(String NUMPRO) {
        this.NUMPRO = NUMPRO;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getRAZSOC() {
        return RAZSOC;
    }

    public void setRAZSOC(String RAZSOC) {
        this.RAZSOC = RAZSOC;
    }

    public String getVENDEDOR() {
        return VENDEDOR;
    }

    public void setVENDEDOR(String VENDEDOR) {
        this.VENDEDOR = VENDEDOR;
    }

}
