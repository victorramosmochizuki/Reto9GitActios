package model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Marca implements Serializable{

    private Integer IDMAR;

    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String NOMMAR;

    @NotNull
    @Size(min = 1, max = 30, message = "Inserta Un dato")
    private String ESTMAR;

    public String getESTMAR() {
        return ESTMAR;
    }

    public void setESTMAR(String ESTMAR) {
        this.ESTMAR = ESTMAR;
    }

    public Integer getIDMAR() {
        return IDMAR;
    }

    public void setIDMAR(Integer IDMAR) {
        this.IDMAR = IDMAR;
    }

    public String getNOMMAR() {
        return NOMMAR;
    }

    public void setNOMMAR(String NOMMAR) {
        this.NOMMAR = NOMMAR;
    }

}
