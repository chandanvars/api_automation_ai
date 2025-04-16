package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Pet {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    // Constructors, Getters and Setters
}