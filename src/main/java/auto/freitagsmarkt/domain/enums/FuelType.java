package auto.freitagsmarkt.domain.enums;

public enum FuelType {
    DIESEL("Diesel"),
    ELECTRIC("Electric"),
    ETHANOL("Ethanol"),
    FUEL_CELL("Fuel Cell"),
    LPG("LPG"),
    NATURAL_GAS("Natural Gas(CNG)"),
    PETROL("Petrol"),
    HYBRID_PETROL("Hybrid Petrol"),
    HYBRID_DIESEL("Hybrid Diesel"),
    PLUG_IN_HYBRID_PETROL("Plug-in Hybrid Petrol"),
    PLUG_IN_HYBRID_DIESEL("Plug-in Hybrid Diesel"),
    MID_H_P("Mid Hybrid Petrol");

    String description;
    FuelType(String description) {
    this.description = description;
    }
}
