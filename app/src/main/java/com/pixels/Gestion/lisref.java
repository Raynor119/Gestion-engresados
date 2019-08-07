package com.pixels.Gestion;

public class lisref {
    private String USUARIO, CELULARRL, NOMBRERL, CELULARRF, NOMBRERF, PROFRL, PROFRF;

    public lisref() {
    }

    public lisref(String USUARIO, String CELULARRL, String NOMBRERL, String CELULARRF, String NOMBRERF, String PROFRL, String PROFRF) {
        this.USUARIO = USUARIO;
        this.CELULARRL = CELULARRL;
        this.NOMBRERL = NOMBRERL;
        this.CELULARRF = CELULARRF;
        this.NOMBRERF = NOMBRERF;
        this.PROFRL = PROFRL;
        this.PROFRF = PROFRF;
    }

    public String getPROFRL() {
        return PROFRL;
    }

    public void setPROFRL(String PROFRL) {
        this.PROFRL = PROFRL;
    }

    public String getPROFRF() {
        return PROFRF;
    }

    public void setPROFRF(String PROFRF) {
        this.PROFRF = PROFRF;
    }



    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getCELULARRL() {
        return CELULARRL;
    }

    public void setCELULARRL(String CELULARRL) {
        this.CELULARRL = CELULARRL;
    }

    public String getNOMBRERL() {
        return NOMBRERL;
    }

    public void setNOMBRERL(String NOMBRERL) {
        this.NOMBRERL = NOMBRERL;
    }

    public String getCELULARRF() {
        return CELULARRF;
    }

    public void setCELULARRF(String CELULARRF) {
        this.CELULARRF = CELULARRF;
    }

    public String getNOMBRERF() {
        return NOMBRERF;
    }

    public void setNOMBRERF(String NOMBRERF) {
        this.NOMBRERF = NOMBRERF;
    }


}
