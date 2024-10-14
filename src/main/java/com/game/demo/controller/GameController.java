package com.game.demo.controller;

import com.game.demo.common.Result;
import com.game.demo.entity.UserSelection;
import com.game.demo.service.GameService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/game")
@CrossOrigin
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/initialize")
    public Result initialize(@RequestBody int i) {
        return Result.success(gameService.initialGame(i));
    }

    @GetMapping("/playAudio")
    public Result playAudio(@RequestParam int id) {
        return Result.success(gameService.PlayAudio(id));
    }


    @PostMapping("/selection")
    public Result checkUserSelection(@RequestBody UserSelection userSelection) {
        return Result.success(gameService.answerQuestion(userSelection.getId(), userSelection.getSelection()));
    }


}
