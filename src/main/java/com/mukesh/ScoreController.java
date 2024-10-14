package com.mukesh;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ScoreController {

	static Score score = new Score(30, 20, 10);

	@PutMapping("/score")
	public Score replaceScore(@RequestBody Score newScore) {
		score = newScore;
		return score;
	}

	@DeleteMapping("/score")
	public void deleteScore() {
		score = null;
	}

	@PatchMapping("/score/wins")
	public Score updateWins(@RequestParam(name = "new-value") int newValue) {
		score.wins = newValue;
		return score;
	}

	@GetMapping("health-check")
	public String getHealthCheck() {
		return "SITUATION NORMAL ALL FIRED UP!";
	}

	@PostMapping("/score/wins")
	public Score increaseWins() {
		score.wins++;
		return score;
	}
	
	@PostMapping("/score/losses")
	public Score increaseLosses() {
		score.losses++;
		return score;
	}
	
	@PostMapping("/score/ties")
	public Score increaseTies() {
		score.ties++;
		return score;
	}

	@GetMapping("/score")
	public Score getScore() {
		return score;
	}

	@GetMapping("/score/{winslossesorties}")
	public int getWinsLossesOrTies(@PathVariable String winslossesorties) {
		if (winslossesorties.equalsIgnoreCase("wins")) {
			return score.wins;
		}
		if (winslossesorties.equalsIgnoreCase("ties")) {
			return score.ties;
		}
		return score.losses;
	}

}
