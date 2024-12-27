package edu.cqie.controller;


import edu.cqie.entity.CheckUp;
import edu.cqie.service.CheckUpService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("checkUp")
@CrossOrigin
public class CheckUpController {

    @Resource
    private CheckUpService checkUpService;

    @RequestMapping("/data")
    public List<CheckUp> CheckUp(Integer userId) {
        return checkUpService.CheckUp(userId);
    }
}
