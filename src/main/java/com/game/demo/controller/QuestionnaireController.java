package com.game.demo.controller;


import com.game.demo.common.Result;
import com.game.demo.dto.QuestionnaireAnswer;
import com.game.demo.service.QuestionnaireService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questionnaire")
@CrossOrigin
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @PostMapping("/submit")
    public Result checkUserSelection(@RequestBody QuestionnaireAnswer questionnaireAnswer) {
        System.out.println(questionnaireAnswer.getCommentsFeedback());
        return Result.success(questionnaireService.addQuestionnaire(questionnaireAnswer));
    }
}
