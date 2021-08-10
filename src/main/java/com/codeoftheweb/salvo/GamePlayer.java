package com.codeoftheweb.salvo;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gameID")
    private Game gameID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="playerID")
    private Player playerID;

    @OneToMany(mappedBy="gamePlayerID", fetch=FetchType.EAGER)
    private Set<Ship>ships;

    private LocalDateTime joinDate;


    public GamePlayer () { }



    public GamePlayer(Player playerID,LocalDateTime joinDate,Game gameID) {
        this.playerID = playerID;
        this.joinDate = joinDate;
        this.gameID = gameID;

    }
    public Map<String, Object> makeGamePlayerDTO(){

        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", this.getId());
        dto.put("player",this.getPlayerID().makePlayerDTO() );

        return dto;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGameID() {
        return gameID;
    }

    public void setGameID(Game gameID) {
        this.gameID = gameID;
    }

    public Player getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Player playerID) {
        this.playerID = playerID;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public Set<Ship> getShip() {
        return ships;
    }

    public void setShip(Set<Ship> ship) {
        this.ships = ship;
    }
}