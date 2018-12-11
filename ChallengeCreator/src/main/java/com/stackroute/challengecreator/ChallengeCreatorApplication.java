package com.stackroute.challengecreator;

import com.stackroute.challengecreator.domain.Challenge;
import com.stackroute.challengecreator.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeCreatorApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeCreatorApplication.class, args);
	}

}

/*
{
    "id": "2",
    "userId": "judshhff",
    "challengeTitle": "MovieCruer",
    "challengeDescription": "Your task is to find the city number in which Dory will find Nemo.",
    "challengeStatement": "First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city and uses it to mark the city that comes after. This marking scheme continues in a cyclic format until she finds Nemo. Nemo however, doesn't want to get caught. He travels to one of the un-marked cities to stay away from Dory as long as possible. Nemo cannot travel to the marked cities.You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.For example, if your niece is turningyears old, and the cake will have candles of height , , , , she will be able to blow out candles successfully, since the tallest candles are of height and there are such candles.First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city and uses it to mark the city that comes after. This marking scheme continues in a cyclic format until she finds Nemo. Nemo however, doesn't want to get caught. He travels to one of the un-marked cities to stay away from Dory as long as possible. Nemo cannot travel to the marked cities.You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.For example, if your niece is turningyears old, and the cake will have candles of height , , , , she will be able to blow out candles successfully, since the tallest candles are of height and there are such candles.he city that comes after. This marking scheme continues in a cyclic format until she finds Nemo. Nemo however, doesn't want to get caught. He travels to one of the un-marked cities to stay away from Dory as long as possible. Nemo cannot travel to the marked cities.You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.For example, if your niece is turningyears old, and the cake will have candles of height , , , , she will be able to blow out candles successfully, since the tallest candles are of height and there are such candles.First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city and uses it to mark the city that comes after. This marking scheme continues in a cyclic format until she finds Nemo. Nemo however, doesn't want to get caught. He travels to one of the un-marked cities to stay away from Dory as long as possible. Nemo cannot travel to the marked cities.You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.For example, if your niece is turningyears old, and the cake will have candles of height , , , , she will be able to blow out candles successfully, since the tallest candles are of height and there arehe city that comes after. This marking scheme continues in a cyclic format until she finds Nemo. Nemo however, doesn't want to get caught. He travels to one of the un-marked cities to stay away from Dory as long as possible. Nemo cannot travel to the marked cities.You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.For example, if your niece is turningyears old, and the cake will have candles of height , , , , she will be able to blow out candles successfully, since the tallest candles are of height and there are such candles.First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city and uses it to mark the city that comes after. This marking scheme continues in a cyclic format until she finds Nemo. Nemo however, doesn't want to get caught. He travels to one of the un-marked cities to stay away from Dory as long as possible. Nemo cannot travel to the marked cities.You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.For example, if your niece is turningyears old, and the cake will have candles of height , , , , she will be able to blow out candles successfully, since the tallest candles are of height and there are   ",
    "solutionUrl": "string",
    "boilerPlateUrl": "string",
    "programmingLang": "string",
    "constraints": "1 <= T <= 20 1 <= T <= 200 1 <= T <= 2000 1 <= T <= 299990 ",
    "topic": "Array",
    "inputFormat": "First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.",
    "outputFormat": "T lines containing the city number where Nemo is found for each input.Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.",
    "maxScore": 100,
    "maxRuntime": 8,
    "level": 1,
    "rating": 4
}
 */