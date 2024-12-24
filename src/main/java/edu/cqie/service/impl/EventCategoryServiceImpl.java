package edu.cqie.service.impl;

import edu.cqie.entity.EventCategory;
import edu.cqie.mapper.EventCategoryDao;
import edu.cqie.service.EventCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EventCategory)表服务实现类
 *
 * @author makejava
 * @since 2024-12-17 16:07:44
 */
@Service("eventCategoryService")
public class EventCategoryServiceImpl implements EventCategoryService {
    @Resource
    private EventCategoryDao eventCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    @Override
    public EventCategory queryById(Integer categoryId) {
        return this.eventCategoryDao.queryById(categoryId);
    }


    /**
     * 查询所有任务分类
     */
    @Override
    public List<EventCategory> queryAll() {
        return this.eventCategoryDao.queryAll();
    }

    @Override
    public List<EventCategory> queryEventAll(Integer userId) {
        return this.eventCategoryDao.queryEventAll(userId);
    }

    /**
     * 分页查询
     *
     * @param eventCategory 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @Override
    public Page<EventCategory> queryByPage(EventCategory eventCategory, PageRequest pageRequest) {
        long total = this.eventCategoryDao.count(eventCategory);
        return new PageImpl<>(this.eventCategoryDao.queryAllByLimit(eventCategory, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param eventCategory 实例对象
     * @return 实例对象
     */
    @Override
    public EventCategory insert(EventCategory eventCategory) {
        this.eventCategoryDao.insert(eventCategory);
        return eventCategory;
    }

    /**
     * 修改数据
     *
     * @param eventCategory 实例对象
     * @return 实例对象
     */
    @Override
    public EventCategory update(EventCategory eventCategory) {
        this.eventCategoryDao.update(eventCategory);
        return this.queryById(eventCategory.getCategoryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer categoryId) {
        return this.eventCategoryDao.deleteById(categoryId) > 0;
    }
}
