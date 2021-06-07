package fr.diginamic.entities;

public enum FishLivEnv {
    FRESH_WATER("Fresh_water"),
    SEA_WATER("Sea_water");

    private String libelle;

    FishLivEnv(String libelle) {
        this.libelle =libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
