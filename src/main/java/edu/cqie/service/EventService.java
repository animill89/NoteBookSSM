package edu.cqie.service;

import edu.cqie.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Event)表服务接口
 *
 * @author makejava
 * @since 2024-12-17 16:05:23
 */
public interface EventService {

    /**
     * 通过ID查询单条数据
     *
     * @param eventId 主键
     * @return 实例对象
     */
    Event queryById(Integer eventId);


    /*
     * 作者：刘星
     * 根据用户自己的Id查询自己的任务列表
     * */
    List<Event> selectListByUserId(Integer userId);

    List<Event> searchEvent(int userId, String eventLevel, String isCompleted, String eventContent);

    /**
     * 分页查询
     *
     * @param event       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Event> queryByPage(Event event, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param event 实例对象
     * @return 实例对象
     */
    Event insert(Event event);

    /**
     * 修改数据
     *
     * @param event 实例对象
     * @return 实例对象
     */
    Event update(Event event);

    /**
     * 通过主键删除数据
     *
     * @param eventId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer eventId);

}
