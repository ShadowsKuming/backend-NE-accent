package com.game.demo.controller;

import com.game.demo.common.Result;
import com.game.demo.entity.UserFormData;
import com.game.demo.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/personal-information")
@CrossOrigin // Allow cross-origin requests (e.g., from frontend applications)
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add-user")
    public Result submit(@RequestBody UserFormData formData) {

        int userId = userService.addUser(formData);
        return Result.success(userId);
    }


}
