package br.com.daniel.core.enums;

public enum BrandEnum {

    TOYOTA("Toyota"),
    FORD("Ford"),
    CHEVROLET("Chevrolet"),
    HONDA("Honda"),
    BMW("BMW"),
    MERCEDES("Mercedes"),
    TESLA("Tesla"),
    VOLKSWAGEN("Volkswagen"),
    AUDI("Audi"),
    HYUNDAI("Hyundai"),
    NISSAN("Nissan"),
    KIA("Kia"),
    VOLVO("Volvo"),
    JEEP("Jeep"),
    SUBARU("Subaru"),
    MAZDA("Mazda"),
    PORSCHE("Porsche"),
    LAND_ROVER("Land Rover"),
    LEXUS("Lexus"),
    INFINITI("Infiniti"),
    FIAT("Fiat"),
    MINI("Mini"),
    JAGUAR("Jaguar"),
    ALFA_ROMEO("Alfa Romeo"),
    FERRARI("Ferrari"),
    MITSUBISHI("Mitsubishi");

    private final String name;

    BrandEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
