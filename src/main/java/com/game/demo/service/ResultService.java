package com.game.demo.service;

import com.game.demo.dao.AnswerRecordRepository;
import com.game.demo.dao.GamePerformanceRepository;
import com.game.demo.dao.UserRepository;
import com.game.demo.dto.AnswerRecordDTO;
import com.game.demo.entity.GameResult;
import com.game.demo.entity.database.GamePerformance;
import com.game.demo.entity.database.UserAnswerId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for handling game results.
 *
 * This service provides methods to retrieve summarized and detailed results of a player's performance in the game.
 * It interacts with the repositories to fetch data from the database and transforms it into the appropriate format
 * to be sent to the front-end.
 */
@Service
public class ResultService {

    private final GamePerformanceRepository gamePerformanceRepository;
    private final AnswerRecordRepository answerRecordRepository;
    private final UserRepository userRepository;


    /**
     * Constructor to initialize the service with the necessary repositories.
     *
     * @param gamePerformanceRepository Repository for accessing game performance data.
     * @param answerRecordRepository Repository for accessing player answer records.
     */
    public ResultService(GamePerformanceRepository gamePerformanceRepository, AnswerRecordRepository answerRecordRepository, UserRepository userRepository) {
        this.gamePerformanceRepository = gamePerformanceRepository;
        this.answerRecordRepository = answerRecordRepository;
        this.userRepository = userRepository;
    }



    public GameResult getGameResult(int id) {
        // Retrieve the player's game performance from the repository.
        GamePerformance gamePerformance = gamePerformanceRepository.getReferenceById((long)id);

        // Calculate accuracy based on the number of correct answers out of total questions.
        int totalRight = gamePerformance.getRight_answer_num_county()+gamePerformance.getRight_answer_num_borough();
        double result = (double) totalRight * 100 /(GameService.gameNumber*2);
        double accuracy = Math.round(result*100.0)/100.0;

        long userCount = gamePerformanceRepository.count();


        List<GamePerformance> gamePerformanceList = gamePerformanceRepository.findAllByOrderByScoreDesc();

        long rank = 0;
        for (int i = 0; i < gamePerformanceList.size(); i++) {
            if (gamePerformanceList.get(i).getId() == id) {
                rank = i + 1;
            }
        }

        // Return a new GameResult object with the player's score and calculated accuracy.
        return new GameResult(gamePerformance.getScore(), accuracy, rank, userCount);
    }


//    public List<AnswerRecordDTO> getDetailResult(int id) {
//        List<AnswerRecordDTO> playerAnswerDTOList = new ArrayList<>();
//
//        // Iterate through all 30 questions and retrieve each answer.
//        for(int i = 1; i <= 2*GameService.gameNumber; i++) {
//            // Convert the UserAnswer entity to a DTO and add it to the list.
//            AnswerRecordDTO dto = AnswerRecordDTO.fromEntity(answerRecordRepository.getReferenceById(new UserAnswerId(i, id)));
//            playerAnswerDTOList.add(dto);
//        }
//
//        // Return the list of detailed answer records.
//        return playerAnswerDTOList;
//    }


}
