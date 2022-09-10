package model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Tipo_Equipo implements Serializable{
    
    private Integer IDTIPEQU;
    
    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String NOMEQU;
    
    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String ESTEQU;

    public Integer getIDTIPEQU() {
        return IDTIPEQU;
    }

    public void setIDTIPEQU(Integer IDTIPEQU) {
        this.IDTIPEQU = IDTIPEQU;
    }

    public String getNOMEQU() {
        return NOMEQU;
    }

    public void setNOMEQU(String NOMEQU) {
        this.NOMEQU = NOMEQU;
    }

    public String getESTEQU() {
        return ESTEQU;
    }

    public void setESTEQU(String ESTEQU) {
        this.ESTEQU = ESTEQU;
    }
    
}
