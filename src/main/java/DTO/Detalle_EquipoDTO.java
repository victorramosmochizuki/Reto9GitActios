package DTO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class Detalle_EquipoDTO implements Serializable {

    private Integer IDDETEQU;
    private Integer IDADQ;
    private String Adquisicion;
    private Integer IDUSU;
    private String Usuario;
    private Integer IDEQU;
    private String Equipo;
    private String NROSER;
    private String DETEQU;
    private String COLEQU;
    private Date GARINI = Timestamp.from(Instant.now());
    private Date GARFIN = Timestamp.from(Instant.now());
    private Double PRECIO;
    private String ESTDET;

    public Date getGARINI() {
        return GARINI;
    }

    public void setGARINI(Date GARINI) {
        this.GARINI = GARINI;
    }

    public Date getGARFIN() {
        return GARFIN;
    }

    public void setGARFIN(Date GARFIN) {
        this.GARFIN = GARFIN;
    }

    public Double getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(Double PRECIO) {
        this.PRECIO = PRECIO;
    }

    public String getAdquisicion() {
        return Adquisicion;
    }

    public void setAdquisicion(String Adquisicion) {
        this.Adquisicion = Adquisicion;
    }

    public Integer getIDDETEQU() {
        return IDDETEQU;
    }

    public void setIDDETEQU(Integer IDDETEQU) {
        this.IDDETEQU = IDDETEQU;
    }

    public Integer getIDADQ() {
        return IDADQ;
    }

    public void setIDADQ(Integer IDADQ) {
        this.IDADQ = IDADQ;
    }

    public Integer getIDUSU() {
        return IDUSU;
    }

    public void setIDUSU(Integer IDUSU) {
        this.IDUSU = IDUSU;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public Integer getIDEQU() {
        return IDEQU;
    }

    public void setIDEQU(Integer IDEQU) {
        this.IDEQU = IDEQU;
    }

    public String getEquipo() {
        return Equipo;
    }

    public void setEquipo(String Equipo) {
        this.Equipo = Equipo;
    }

    public String getNROSER() {
        return NROSER;
    }

    public void setNROSER(String NROSER) {
        this.NROSER = NROSER;
    }

    public String getDETEQU() {
        return DETEQU;
    }

    public void setDETEQU(String DETEQU) {
        this.DETEQU = DETEQU;
    }

    public String getCOLEQU() {
        return COLEQU;
    }

    public void setCOLEQU(String COLEQU) {
        this.COLEQU = COLEQU;
    }

    public String getESTDET() {
        return ESTDET;
    }

    public void setESTDET(String ESTDET) {
        this.ESTDET = ESTDET;
    }

}
