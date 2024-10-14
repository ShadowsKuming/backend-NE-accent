package com.game.demo.controller;

import com.game.demo.common.Result;
import com.game.demo.service.RankingService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/ranking")
public class RankingController {

    final RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping("/getRanking")
    public Result getRanking() {
        return Result.success(rankingService.getUsersPerformance());
    }

}
