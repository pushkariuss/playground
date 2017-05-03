package com.company;

/**
 * Created by vdmitrieva on 27.04.2017.
 */
public class Pet {
    private String type_of_pet;
    private String name_of_pet;

    public Pet (String type_of_pet, String name_of_pet){
        this.type_of_pet = type_of_pet;
        this.name_of_pet = name_of_pet;
    }
public String toString() {
        return "The "+this.type_of_pet+" "+this.name_of_pet;
}
    }
