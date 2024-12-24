package edu.cqie.controller;

import edu.cqie.entity.Event;
import edu.cqie.service.EventCategoryService;
import edu.cqie.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("search")
public class SearchController {
    @Resource
    private EventService eventService;


    /*
     * 作者：刘星
     * 搜索功能
     * required=false表示这个参数不是必须的，可以为null
     * */
    @GetMapping("/event")
    @ResponseBody
    public List<Event> searchEvent(@RequestParam("userId") int userId,
                                   @RequestParam(value = "eventLevel", required = false) String eventLevel,
                                   @RequestParam(value = "isCompleted", required = false) String isCompleted,
                                   @RequestParam(value = "eventContent", required = false) String eventContent) {
        return eventService.searchEvent(userId, eventLevel, isCompleted, eventContent);
    }

}
