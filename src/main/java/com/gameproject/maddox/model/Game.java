package com.gameproject.maddox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {
	private Long id;
    private String name;
    private String summary;
    private Cover cover;
    private Double total_rating;

    public Game() {}
    
    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public Cover getCover() { return cover; }
    public void setCover(Cover cover) { this.cover = cover; }

    public Double getTotal_rating() { return total_rating; }
    public void setTotal_rating(Double total_rating) { this.total_rating = total_rating; }
}