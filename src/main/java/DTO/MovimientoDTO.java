package DTO;

import java.io.Serializable;

public class MovimientoDTO implements Serializable {

    private Integer IDMOV;
    private Integer IDUSUORIGEN;
    private String Origen;
    private Integer IDUSUDESTINO;
    private String Destino;
    private Integer IDDETEQU;
    private String Detalle;
    private Integer IDTIPMOV;
    private String tipo;
    private String DESCRIPCION;
    private String ESTMOV;

    public String getESTMOV() {
        return ESTMOV;
    }

    public void setESTMOV(String ESTMOV) {
        this.ESTMOV = ESTMOV;
    }

    public Integer getIDMOV() {
        return IDMOV;
    }

    public void setIDMOV(Integer IDMOV) {
        this.IDMOV = IDMOV;
    }

    public Integer getIDUSUORIGEN() {
        return IDUSUORIGEN;
    }

    public void setIDUSUORIGEN(Integer IDUSUORIGEN) {
        this.IDUSUORIGEN = IDUSUORIGEN;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public Integer getIDUSUDESTINO() {
        return IDUSUDESTINO;
    }

    public void setIDUSUDESTINO(Integer IDUSUDESTINO) {
        this.IDUSUDESTINO = IDUSUDESTINO;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public Integer getIDDETEQU() {
        return IDDETEQU;
    }

    public void setIDDETEQU(Integer IDDETEQU) {
        this.IDDETEQU = IDDETEQU;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public Integer getIDTIPMOV() {
        return IDTIPMOV;
    }

    public void setIDTIPMOV(Integer IDTIPMOV) {
        this.IDTIPMOV = IDTIPMOV;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

}
