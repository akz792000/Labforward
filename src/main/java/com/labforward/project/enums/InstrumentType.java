package com.labforward.project.enums;

import static java.text.MessageFormat.format;

/**
 * @ AnalyticalInstrument Ali Karimizandi
 * @since 2021
 */
public enum InstrumentType {

    AnalyticalInstrument(Code.AnalyticalInstrument, Name.AnalyticalInstrument),
    ClinicalLabEquipment(Code.ClinicalLabEquipment, Name.ClinicalLabEquipment);

    public static class Code {
        public static final String AnalyticalInstrument = "1";
        public static final String ClinicalLabEquipment = "2";
    }

    public static class Name {
        public static final String AnalyticalInstrument = "analytical_instrument";
        public static final String ClinicalLabEquipment = "clinical_lab_equipment";
    }

    private final String code;

    private final String name;

    InstrumentType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static InstrumentType getByCode(String code) {
        if (code == null) return null;
        for (InstrumentType value : values()) {
            if (value.code.equals(code)) return value;
        }
        throw new IllegalArgumentException(format(InstrumentType.class.getName() + " not found for standardCode {0}", code));
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

}
