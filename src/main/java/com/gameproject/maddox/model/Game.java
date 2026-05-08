package com.gameproject.maddox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {
	private Long id;
    private String name;
    private String summary;
}
