package auto.cc.info.domain;

public enum ChassisType {
    LCV("LCV"),
    LIGHT_WEIGHT("Light Weight"),
    MPV("MPV"),
    PICKUP("Pick up"),
    SUV("SUV"),
    SEDAN("Sedan"),
    STATION_WAG("Station Wagon");
    String name;
    ChassisType(String name) {
        this.name = name;
    }
}
