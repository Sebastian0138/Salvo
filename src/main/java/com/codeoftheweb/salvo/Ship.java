package com.codeoftheweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String shipType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gamePlayerID")
    private GamePlayer gamePlayerID;

    @JsonIgnore

    @ElementCollection
    @Column(name="shipLocation")
    private List<String> shipLocation = new ArrayList<>();



    public Ship() { }

    public Ship(String shipType, GamePlayer gamePlayerID, List<String> shipLocation) {
        this.shipType = shipType;
        this.gamePlayerID = gamePlayerID;
        this.shipLocation = shipLocation;
    }

    public GamePlayer getGamePlayerId() {
        return gamePlayerID;
    }

    public Map<String,Object> makeShipDTO(){

        Map<String,Object> dto= new LinkedHashMap<>();
        dto.put("types",this.getShipType());
        dto.put("location",this.getShipLocation());

        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setGamePlayerId(GamePlayer gamePlayerId) {
        this.gamePlayerID = gamePlayerId;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public List<String> getShipLocation() {
        return shipLocation;
    }

    public void setShipLocation(List<String> shipLocation) {
        this.shipLocation = shipLocation;
    }

    public GamePlayer getGamePlayerID() {
        return gamePlayerID;
    }

    public void setGamePlayerID(GamePlayer gamePlayerID) {
        this.gamePlayerID = gamePlayerID;
    }



}

