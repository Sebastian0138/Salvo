
package com.codeoftheweb.salvo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String userName;


    @OneToMany(mappedBy="playerID", fetch=FetchType.EAGER)
    private  Set<GamePlayer> gamePlayer;

    public Player() { }
    public Map<String,Object> makePlayerDTO(){

        Map<String,Object> dto= new LinkedHashMap<>();
        dto.put("id",this.getId());
        dto.put("email",this.getUserName());
        return dto;

    }
    @JsonIgnore
    public List<Game> getGame() {
        return gamePlayer.stream().map(x -> x.getGameID()).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player(String userName) {
        this.userName = userName;

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<GamePlayer> getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(Set<GamePlayer> gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
}