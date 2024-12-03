package org.example.analisi;

public enum TypeEnum {
    GIOCO_ZERO("gioco zero"),
    ORFANELLI("orfanelli"),
    SERIE_5_8("serie 5/8"),
    VICINI_DELLO_ZERO("vicini dello zero");

    private final String type;

    private TypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

