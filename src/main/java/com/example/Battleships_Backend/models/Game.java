package com.example.Battleships_Backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_started")
    private boolean isStarted;

    @Column(name = "is_finished")
    private boolean isFinished;

    @Column(name = "player_one_turn")
    private boolean playerOneTurn;

    @OneToMany(mappedBy = "game")
    @JsonIgnoreProperties({"games"})
    private List<Grid> grids;

    public Game(){
        this.isStarted = false;
        this.isFinished = false;
        this.playerOneTurn = true;
        this.grids = new ArrayList<>();
//        this.grids.add(gridPlayerOne);
//        this.grids.add(gridPlayerTwo);
    }

//    public Game(){
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isPlayerOneTurn() {
        return playerOneTurn;
    }

    public void setPlayerOneTurn(boolean playerOneTurn) {
        this.playerOneTurn = playerOneTurn;
    }

    public List<Grid> getGrids() {
        return grids;
    }

    public void setGrids(List<Grid> grids) {
        this.grids = grids;
    }
}
