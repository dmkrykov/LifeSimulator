package org.dk.loaders;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
public class CanEat {
    @Getter
    private String animal;
    private String value;

    public int getValue() {
        return Integer.getInteger(value);
    }

    @JsonCreator
    public CanEat(List<String> data) {
        this.animal = data.get(0);
        this.value = data.get(1);
    }
}
