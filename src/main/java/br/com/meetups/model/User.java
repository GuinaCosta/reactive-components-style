package br.com.meetups.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    @JsonProperty("name")
    private String name;

    @JsonProperty("secondname")
    private String secondName;

    @JsonProperty("nickname")
    private String nickname;
}
