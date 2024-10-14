package com.game.demo.controller;

import com.game.demo.common.Result;
import com.game.demo.service.ResultService;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/result")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }


    @GetMapping("/end")
    public Result getResult(@RequestParam int id) {

        return Result.success(resultService.getGameResult(id));
    }

//    @GetMapping("/details")
//    public Result getResultDetails(@RequestParam int id) {
//        return Result.success(resultService.getDetailResult(id));
//    }
//


}
