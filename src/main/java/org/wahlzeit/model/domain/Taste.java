package org.wahlzeit.model.domain;


import org.wahlzeit.utils.EnumValue;

public enum  Taste implements EnumValue {

    /**
     *
     */
    TASTELESS(0),
    SOUR(1),
    SPICY(2),
    SWEET(3),
    MILD(4),
    SALTY(5);

    private int value;

    private static Taste[] allValues = {
            TASTELESS,
            SALTY,
            SOUR,
            SPICY,
            SWEET,
            MILD,
    };

    private static String[] valueNames = {
            "tasteless",
            "sour",
            "spicy",
            "sweet",
            "mild",
            "salty",
    };

    Taste(int value){
        this.value = value;
    }

    @Override
    public int asInt() {
        return value;
    }

    @Override
    public String asString() {
        return valueNames[value];
    }

    @Override
    public EnumValue[] getAllValues() {
        return allValues;
    }

    @Override
    public String getTypeName() {
        return this.getClass().getName();
    }
}
