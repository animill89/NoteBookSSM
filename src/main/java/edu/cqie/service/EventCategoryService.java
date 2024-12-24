package edu.cqie.service;

import edu.cqie.entity.EventCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (EventCategory)表服务接口
 *
 * @author makejava
 * @since 2024-12-17 16:07:44
 */
public interface EventCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    EventCategory queryById(Integer categoryId);

    /*
     * 查询所有任务分类
     * */
    List<EventCategory> queryAll();

    List<EventCategory> queryEventAll(Integer userId);

    /**
     * 分页查询
     *
     * @param eventCategory 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    Page<EventCategory> queryByPage(EventCategory eventCategory, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param eventCategory 实例对象
     * @return 实例对象
     */
    EventCategory insert(EventCategory eventCategory);

    /**
     * 修改数据
     *
     * @param eventCategory 实例对象
     * @return 实例对象
     */
    EventCategory update(EventCategory eventCategory);

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer categoryId);

}
