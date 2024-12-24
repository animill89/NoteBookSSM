package edu.cqie.controller;

import edu.cqie.entity.EventCategory;
import edu.cqie.service.EventCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EventCategory)表控制层
 *
 * @author makejava
 * @since 2024-12-17 16:07:44
 */
@RestController
@RequestMapping("eventCategory")
@CrossOrigin
public class EventCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private EventCategoryService eventCategoryService;

    /**
     * 分页查询
     *
     * @param eventCategory 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<EventCategory>> queryByPage(EventCategory eventCategory, PageRequest pageRequest) {
        return ResponseEntity.ok(this.eventCategoryService.queryByPage(eventCategory, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<EventCategory> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.eventCategoryService.queryById(id));
    }

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("/queryAll")
    public ResponseEntity<List<EventCategory>> queryById() {
        return ResponseEntity.ok(this.eventCategoryService.queryAll());
    }

    @GetMapping("/queryEventAll")
    public ResponseEntity<List<EventCategory>> queryEventAll(Integer userId) {
        return ResponseEntity.ok(this.eventCategoryService.queryEventAll(userId));
    }

    /**
     * 新增数据
     *
     * @param eventCategory 实体
     * @return 新增结果
     */
    @PostMapping("/addEventCategory")
    public ResponseEntity<EventCategory> add(@RequestBody EventCategory eventCategory) {
        return ResponseEntity.ok(this.eventCategoryService.insert(eventCategory));
    }

    /**
     * 编辑数据
     *
     * @param eventCategory 实体
     * @return 编辑结果
     */
    @PutMapping("/update")
    public ResponseEntity<EventCategory> edit(@RequestBody EventCategory eventCategory) {
        System.out.print(eventCategory);
        return ResponseEntity.ok(this.eventCategoryService.update(eventCategory));
    }

    /**
     * 删除数据
     *
     * @param categoryId 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@RequestParam("categoryId") Integer categoryId) {
        return ResponseEntity.ok(this.eventCategoryService.deleteById(categoryId));
    }

}

