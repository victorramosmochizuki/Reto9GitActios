package model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Area implements Serializable{

    private Integer IDARE;

    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String NOMARE;

    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String ESTARE;

    public Integer getIDARE() {
        return IDARE;
    }

    public void setIDARE(Integer IDARE) {
        this.IDARE = IDARE;
    }

    public String getNOMARE() {
        return NOMARE;
    }

    public void setNOMARE(String NOMARE) {
        this.NOMARE = NOMARE;
    }

    public String getESTARE() {
        return ESTARE;
    }

    public void setESTARE(String ESTARE) {
        this.ESTARE = ESTARE;
    }
}
