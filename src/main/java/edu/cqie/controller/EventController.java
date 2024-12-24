package edu.cqie.controller;

import edu.cqie.entity.Event;
import edu.cqie.service.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Event)表控制层
 *
 * @author makejava
 * @since 2024-12-17 16:05:45
 */
@RestController
@RequestMapping("event")
@CrossOrigin
public class EventController {
    /**
     * 服务对象
     */
    @Resource
    private EventService eventService;

    /**
     * 分页查询
     *
     * @param event       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Event>> queryByPage(Event event, PageRequest pageRequest) {
        return ResponseEntity.ok(this.eventService.queryByPage(event, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<Event> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.eventService.queryById(id));
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Event>> queryUserById(@PathVariable("userId") Integer userId) {
        System.out.print(userId);
        return ResponseEntity.ok(this.eventService.selectListByUserId(userId));
    }

    /**
     * 新增数据
     *
     * @param event 实体
     * @return 新增结果
     */
    @PostMapping("/addEvent")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        eventService.insert(event);
        return ResponseEntity.ok(event);
    }

    /**
     * 编辑数据
     *
     * @param event 实体
     * @return 编辑结果
     */
    @PutMapping("/update")
    public ResponseEntity<Event> edit(@RequestBody Event event) {
        System.out.print(event);
        return ResponseEntity.ok(this.eventService.update(event));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@RequestParam("eventId") Integer eventId) {
        System.out.print(eventId); // 这里应该输出传入的 id
        return ResponseEntity.ok(this.eventService.deleteById(eventId));
    }

}

