package com.game.demo.service;


import com.game.demo.dao.AnswerRecordRepository;
import com.game.demo.dao.GamePerformanceRepository;
import com.game.demo.dao.StimuliRepository;
import com.game.demo.entity.database.GamePerformance;
import com.game.demo.entity.GameStatus;
import com.game.demo.entity.database.UserAnswer;
import com.game.demo.entity.database.UserAnswerId;
import com.game.demo.entity.database.StimuliAnswer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    public static final String COUNTY = "county";
    public static final String BOROUGH = "borough";

    private final GamePerformanceRepository gamePerformanceRepository;
    private final StimuliRepository stimuliRepository;
    private final AnswerRecordRepository answerRecordRepository;
    protected static final int gameNumber = 20;

    private final ArrayList<StimuliAnswer> questionList = new ArrayList<>();


    public GameService(StimuliRepository stimuliRepository, GamePerformanceRepository gamePerformanceRepository, AnswerRecordRepository answerRecordRepository) {
        this.stimuliRepository = stimuliRepository;
        this.gamePerformanceRepository = gamePerformanceRepository;
        this.answerRecordRepository = answerRecordRepository;
    }


    /**
     * Initializes the game status for a user based on their ID.
     * This method checks if a game performance record exists for the given user ID.
     * If the record does not exist, it creates a new game performance record with default values.
     * If the record exists, it retrieves the current game performance for the user.
     *
     * The method then prepares a GameStatus object to be sent back to the frontend.
     * The GameStatus object includes the user's current score, progress as a percentage,
     * and the current question number. If the user has answered 30 or more questions,
     * the game is marked as finished.
     *
     * @param id The user's unique identifier.
     * @return A GameStatus object containing the user's game progress and status.
     */
    public GameStatus initialGame(int id) {
        GamePerformance gamePerformance;

        // Check if a game performance record exists for the user
        if (!gamePerformanceRepository.existsById((long) id)) {
            // Create a new game performance record with default values if none exists
            gamePerformance = new GamePerformance(0, 0, 0, 0,1,0, id );
            gamePerformanceRepository.save(gamePerformance);

            //initialize the question List with user id
            initialQuestionsList(id);
        } else {
            // Retrieve the existing game performance record
            gamePerformance = gamePerformanceRepository.getReferenceById((long) id);
        }

        // Prepare the game status to be sent back to the frontend
        GameStatus gameStatus = new GameStatus();
        gameStatus.setScore(gamePerformance.getScore());

        if (gamePerformance.getQuestionNumber()<=gameNumber){
            gameStatus.setProgress(Math.round(((double) (gamePerformance.getQuestionNumber()-1) * 100 / gameNumber))*100.0/100.0);

        }else{
            gameStatus.setProgress(Math.round(((double) (gamePerformance.getQuestionNumber()-1-gameNumber) * 100 / gameNumber))*100.0/100.0);
        }

        gameStatus.setQuestionNum(gamePerformance.getQuestionNumber());

        // Send to front end that last question wrong or right
        if (gamePerformance.getQuestionNumber() > 1) {
            gameStatus.setCorrectAnswer(answerRecordRepository
                    .getReferenceById(new UserAnswerId(gamePerformance.getQuestionNumber()-1,id)).isCorrect());
        }

        // Mark the game as finished if 30 questions have been answered
        if (gamePerformance.getQuestionNumber() == 2 * gameNumber+1) {
            gameStatus.setFinished(true);
        }

        return gameStatus;
    }

    /**
     * Evaluates the player's answer to the current question and updates the game status.
     *
     * This method retrieves the current game performance for the player based on the player's ID.
     * It then fetches the player's answer for the current question and compares it with the correct answer.
     * Depending on whether the player's selection is correct or not, the method updates the number of correct or wrong answers,
     * adjusts the player's score, and increments the question number for the next round.
     * The updated game performance and answer records are saved back to the database.
     * Finally, the method returns the updated game status.
     *
     * @param id The player's ID, used to fetch the current game performance and answer records.
     * @param selection The player's selected answer for the current question.
     * @return The updated game status after processing the answer, including score, progress, and question number.
     */
    public GameStatus answerQuestion(int id, String selection) {
        // Retrieve the player's current game performance based on their ID.
        GamePerformance gamePerformance = gamePerformanceRepository.getReferenceById((long)id);
        int questionNumber = gamePerformance.getQuestionNumber();

        // Retrieve the player's answer for the current question using the composite key (questionNumber, playerId).
        UserAnswer answer = answerRecordRepository.getReferenceById(new UserAnswerId(questionNumber, id));

        // Set the player's selected answer.
        answer.setPlayerAnswer(selection);

        // Check if the player's answer matches the correct answer.
        if(answer.getPlayerAnswer().equalsIgnoreCase(answer.getCorrectAnswer())) {
            // If the answer is correct, update the player's correct answer count and increase the score.
            answer.setCorrect(true);

            //check the game level, if the question number <= game Number, then, is county level; else, it is borough level
            if(questionNumber<=gameNumber){
                gamePerformance.setRight_answer_num_county(gamePerformance.getRight_answer_num_county()+1);
            }else{
                gamePerformance.setRight_answer_num_borough(gamePerformance.getRight_answer_num_borough()+1);
            }
            gamePerformance.setScore(gamePerformance.getScore() + 20);
        } else {
            // If the answer is incorrect, update the player's wrong answer count.
            answer.setCorrect(false);

            //check the game level, if the question number <= game Number, then, is county level; else, it is borough level
            if(questionNumber<=gameNumber){
                gamePerformance.setWrong_answer_num_county(gamePerformance.getWrong_answer_num_county()+1);
            }else{
                gamePerformance.setWrong_answer_num_borough(gamePerformance.getWrong_answer_num_borough()+1);
            }
        }

        // Move to the next question by incrementing the question number.
        gamePerformance.setQuestionNumber(questionNumber + 1);

        // Save the updated game performance and answer records back to the database.
        gamePerformanceRepository.save(gamePerformance);
        answerRecordRepository.save(answer);

        // Return the updated game status, including score, progress, and question number.
        return initialGame(id);
    }


    /**
     * initial the Question List selected from the database
     * @param id userId
     */
    private void initialQuestionsList(int id){

        //random select 20 questions from the stimuliRepository for county level
        List<StimuliAnswer> stimuliAnswerListCounty = stimuliRepository.findRandomEntitiesByLevel(GameService.COUNTY,gameNumber);
        for(StimuliAnswer stimuliAnswer : stimuliAnswerListCounty){

            int i = stimuliAnswerListCounty.indexOf(stimuliAnswer);
            UserAnswer playerAnswer = new UserAnswer(i+1,id,stimuliAnswer.getFileName(),"",stimuliAnswer.getCorrectAnswer(),null,GameService.COUNTY);
            answerRecordRepository.save(playerAnswer);
        }

        //random select 20 questions from the stimuliRepository for borough
        List<StimuliAnswer> stimuliAnswerListBorough = stimuliRepository.findRandomEntitiesByLevel(GameService.BOROUGH,gameNumber);
        for(StimuliAnswer stimuliAnswer : stimuliAnswerListBorough){

            int i = stimuliAnswerListBorough.indexOf(stimuliAnswer);
            UserAnswer playerAnswer = new UserAnswer(i+1+gameNumber,id,stimuliAnswer.getFileName(),"",stimuliAnswer.getCorrectAnswer(),null,GameService.BOROUGH);
            answerRecordRepository.save(playerAnswer);
        }
    }



    /**
     * Retrieves the audio file path associated with the question answered by the player.
     *
     * This method fetches the game performance for a given player ID to determine the current
     * question number. It then retrieves the corresponding UserAnswer record based on the
     * question number and player ID. The method constructs the file path to the audio file
     * associated with the question and returns the path as a string.
     * @param id The player's ID, which is used to fetch the current game performance and the corresponding answer.
     * @return The URL path to the audio file associated with the player's current question.
     */
    public String PlayAudio(int id) {
        // Retrieve the player's game performance record based on the player ID.
        GamePerformance gamePerformance = gamePerformanceRepository.getReferenceById((long)id);

        // Get the current question number the player is on.
        int questionNumber = gamePerformance.getQuestionNumber();

        // Retrieve the player's answer for the current question using a composite key (questionNumber, playerId).
        UserAnswer answer = answerRecordRepository.getReferenceById(new UserAnswerId(questionNumber, id));

        // Get the associated audio file name for the question.
        String audioFile = answer.getQuestionName();

        // Load the audio file resource from the classpath.
        Resource audioResource = new ClassPathResource("Audio/" + audioFile);

        // Return the relative URL to access the audio file with a ".wav" extension.
        return "/audio/" + audioResource.getFilename() + ".wav";
    }

}
