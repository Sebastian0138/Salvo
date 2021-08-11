package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository,GamePlayerRepository gamePlayerRepository,ShipRepository shipRepository) {
		return (args) -> {

			Game juego1 =new Game(LocalDateTime.now());
			Game juego2 =new Game(LocalDateTime.now().plusHours(1));
			Game juego3 =new Game(LocalDateTime.now().plusHours(2));
			Game juego4 =new Game(LocalDateTime.now().plusHours(3));
			Game juego5 =new Game(LocalDateTime.now().plusHours(4));
			Game juego6 =new Game(LocalDateTime.now().plusHours(5));

			gameRepository.save(juego1);
			gameRepository.save(juego2);
			gameRepository.save(juego3);
			gameRepository.save(juego4);
			gameRepository.save(juego5);
			gameRepository.save(juego6);

			Player player1 = new Player("Hernan@gmail.com");
			Player player2 = new Player("Leandro@gmail.com");
			Player player3 = new Player("pepe@gmail.com");
			Player player4 = new Player("ricardo@gmail.com");


			playerRepository.save(player1);
			playerRepository.save(player2);
			playerRepository.save(player3);
			playerRepository.save(player4);


			GamePlayer gamePlayer1 = new GamePlayer(player1,LocalDateTime.now(),juego1);
			gamePlayerRepository.save(gamePlayer1);

			GamePlayer gamePlayer2 = new GamePlayer(player2,LocalDateTime.now(),juego1);
			gamePlayerRepository.save(gamePlayer2);

			GamePlayer gamePlayer3 = new GamePlayer(player1,LocalDateTime.now(),juego2);
			gamePlayerRepository.save(gamePlayer3);

			GamePlayer gamePlayer4 = new GamePlayer(player2,LocalDateTime.now(),juego2);
			gamePlayerRepository.save(gamePlayer4);

			GamePlayer gamePlayer5 = new GamePlayer(player4,LocalDateTime.now(),juego3);
			gamePlayerRepository.save(gamePlayer5);

			GamePlayer gamePlayer6 = new GamePlayer(player3,LocalDateTime.now(),juego3);
			gamePlayerRepository.save(gamePlayer6);

			Ship ship1= new Ship("crusero",gamePlayer1, Arrays.asList("H1","H2","H3"));
			shipRepository.save(ship1);

			Ship ship2= new Ship("Submarino",gamePlayer2, Arrays.asList("H6","H4","H5"));
			shipRepository.save(ship2);



		};
	}
}
