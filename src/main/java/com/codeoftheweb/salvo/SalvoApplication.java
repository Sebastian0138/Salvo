package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDateTime;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository,GamePlayerRepository gamePlayerRepository) {
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


			GamePlayer gamelayer1 = new GamePlayer(juego1,LocalDateTime.now(),player1);
			gamePlayerRepository.save(gamelayer1);

			GamePlayer gamelayer2 = new GamePlayer(juego1,LocalDateTime.now(),player2);
			gamePlayerRepository.save(gamelayer2);


			GamePlayer gamelayer3 = new GamePlayer(juego2,LocalDateTime.now(),player3);
			gamePlayerRepository.save(gamelayer3);

			GamePlayer gamelayer4 = new GamePlayer(juego2,LocalDateTime.now(),player4);
			gamePlayerRepository.save(gamelayer4);


			GamePlayer gamelayer5 = new GamePlayer(juego3,LocalDateTime.now(),player2);
			gamePlayerRepository.save(gamelayer5);

			GamePlayer gamelayer6 = new GamePlayer(juego3,LocalDateTime.now(),player3);
			gamePlayerRepository.save(gamelayer6);

			GamePlayer gamelayer7 = new GamePlayer(juego4,LocalDateTime.now(),player3);
			gamePlayerRepository.save(gamelayer7);

			GamePlayer gamelayer8 = new GamePlayer(juego4,LocalDateTime.now(),player1);
			gamePlayerRepository.save(gamelayer8);

			GamePlayer gamelayer9 = new GamePlayer(juego5,LocalDateTime.now(),player3);
			gamePlayerRepository.save(gamelayer9);

			GamePlayer gamelayer10 = new GamePlayer(juego5,LocalDateTime.now(),player2);
			gamePlayerRepository.save(gamelayer10);

		};
	}
}
