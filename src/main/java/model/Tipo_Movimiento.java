package model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Tipo_Movimiento implements Serializable{

    private Integer IDTIPMOV;

    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String TIPMOV;
       
    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String ESTTIP;

    public String getESTTIP() {
        return ESTTIP;
    }

    public void setESTTIP(String ESTTIP) {
        this.ESTTIP = ESTTIP;
    }

    public Integer getIDTIPMOV() {
        return IDTIPMOV;
    }

    public void setIDTIPMOV(Integer IDTIPMOV) {
        this.IDTIPMOV = IDTIPMOV;
    }

    public String getTIPMOV() {
        return TIPMOV;
    }

    public void setTIPMOV(String TIPMOV) {
        this.TIPMOV = TIPMOV;
    }

}
