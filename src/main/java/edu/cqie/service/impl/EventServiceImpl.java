package edu.cqie.service.impl;

import edu.cqie.entity.Event;
import edu.cqie.mapper.EventDao;
import edu.cqie.service.EventService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Event)表服务实现类
 *
 * @author makejava
 * @since 2024-12-17 16:05:23
 */
@Service("eventService")
public class EventServiceImpl implements EventService {
    @Resource
    private EventDao eventDao;

    /**
     * 通过ID查询单条数据
     *
     * @param eventId 主键
     * @return 实例对象
     */
    @Override
    public Event queryById(Integer eventId) {
        return this.eventDao.queryById(eventId);
    }

    /*
     * 作者：刘星
     * 根据用户Id查询用户自己的事件列表
     * 2024年12月17日18:25:27
     * */

    @Override
    public List<Event> selectListByUserId(Integer userId) {
//        System.out.print(this.eventDao.queryUserById(userId));
        return this.eventDao.selectListByUserId(userId);
    }


    /*
     * 作者：刘星
     * 搜索引擎
     * 2024年12月17日18:25:27
     * */

    @Override
    public List<Event> searchEvent(int userId, String eventLevel, String isCompleted, String eventContent) {
        return eventDao.searchEvent(userId, eventLevel, isCompleted, eventContent);
    }

    /**
     * 分页查询
     *
     * @param event       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Event> queryByPage(Event event, PageRequest pageRequest) {
        long total = this.eventDao.count(event);
        return new PageImpl<>(this.eventDao.queryAllByLimit(event, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param event 实例对象
     * @return 实例对象
     */
    @Override
    public Event insert(Event event) {
        this.eventDao.insert(event);
        return event;
    }

    /**
     * 修改数据
     *
     * @param event 实例对象
     * @return 实例对象
     */
    @Override
    public Event update(Event event) {
        this.eventDao.update(event);
        return this.queryById(event.getEventId());
    }

    /**
     * 通过主键删除数据
     *
     * @param eventId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer eventId) {
        return this.eventDao.deleteById(eventId) > 0;
    }
}
