package edu.cqie.controller;


import edu.cqie.entity.TitleValue;
import edu.cqie.service.TitleValueService;
import edu.cqie.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("titlevalue")
@CrossOrigin
public class TitleValueController {
    @Resource
    private TitleValueService titleValueService;


    @PostMapping("/getvalue")
    public List<TitleValue> getTitleValue(Integer userId) {
        return titleValueService.getTitleValue(userId);
    }
}
