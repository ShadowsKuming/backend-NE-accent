package com.game.demo.service;


import com.game.demo.dao.GamePerformanceRepository;
import com.game.demo.dao.UserRepository;
import com.game.demo.dto.UserPerformance;
import com.game.demo.entity.database.GamePerformance;
import com.game.demo.entity.database.User;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankingService {

    final GamePerformanceRepository gamePerformanceRepository;
    final UserRepository userRepository;

    public RankingService(GamePerformanceRepository gamePerformanceRepository, UserRepository userRepository) {
        this.gamePerformanceRepository = gamePerformanceRepository;
        this.userRepository = userRepository;
    }


    public List<UserPerformance> getUsersPerformance() {
        List<GamePerformance> gamePerformanceList = gamePerformanceRepository.findTop20ByOrderByScoreDesc();

        List<UserPerformance> userPerformanceList = new ArrayList<>();
        for (GamePerformance gamePerformance : gamePerformanceList) {
            if(gamePerformance.getScore()>0){
                // check if it is a valid player
                User user = userRepository.getReferenceById((long)gamePerformance.getId());
                int accuracy = (gamePerformance.getRight_answer_num_county()
                        +gamePerformance.getRight_answer_num_borough())*100/(GameService.gameNumber*2);
                UserPerformance userPerformance =
                        new UserPerformance(gamePerformanceList.indexOf(gamePerformance)+1,user.getUsername()
                                ,gamePerformance.getScore()
                                ,accuracy);

                userPerformanceList.add(userPerformance);
            }
        }

        return userPerformanceList;
    }



}
