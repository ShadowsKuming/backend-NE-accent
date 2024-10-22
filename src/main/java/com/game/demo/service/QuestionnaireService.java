package com.game.demo.service;

import com.game.demo.common.Result;
import com.game.demo.dao.QuestionnaireRepository;
import com.game.demo.dto.QuestionnaireAnswer;
import com.game.demo.entity.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {
    private final QuestionnaireRepository questionnaireRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }


    public Result addQuestionnaire(QuestionnaireAnswer questionnaireAnswer) {
        Questionnaire questionnaire =
                new Questionnaire(questionnaireAnswer.getId(),
                        questionnaireAnswer.getAttendedEvent(),
                        questionnaireAnswer.getLearnedSomething(),
                        questionnaireAnswer.getVenueUse(),
                        questionnaireAnswer.getLearnedNew(),
                        questionnaireAnswer.getEnjoyedMostOrLeast(),
                        questionnaireAnswer.getChangedViews(),
                        questionnaireAnswer.getCommentsFeedback());
        questionnaireRepository.save(questionnaire);

        return Result.success();
    }
}
