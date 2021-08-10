package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ElementCollection
    @Column(name="shipLocation")
    private List<String> shipLocation = new ArrayList<>();
    public Ship() { }

    public Ship(GamePlayer gamePlayerId, String shipType) {
        this.gamePlayerID = gamePlayerId;
        this.shipType = shipType;
    }

    public GamePlayer getGamePlayerId() {
        return gamePlayerID;
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
}