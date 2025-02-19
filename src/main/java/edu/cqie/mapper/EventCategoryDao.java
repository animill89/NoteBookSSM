package edu.cqie.mapper;

import edu.cqie.entity.EventCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (EventCategory)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-17 16:07:44
 */
public interface EventCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    EventCategory queryById(Integer categoryId);

    /*
     * 查询所有分类
     * */
    List<EventCategory> queryAll();

    List<EventCategory> queryEventAll(@Param("userId") Integer userId);

    /**
     * 查询指定行数据
     *
     * @param eventCategory 查询条件
     * @param pageable      分页对象
     * @return 对象列表
     */
    List<EventCategory> queryAllByLimit(EventCategory eventCategory, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param eventCategory 查询条件
     * @return 总行数
     */
    long count(EventCategory eventCategory);

    /**
     * 新增数据
     *
     * @param eventCategory 实例对象
     * @return 影响行数
     */
    int insert(EventCategory eventCategory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EventCategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EventCategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EventCategory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EventCategory> entities);

    /**
     * 修改数据
     *
     * @param eventCategory 实例对象
     * @return 影响行数
     */
    int update(EventCategory eventCategory);

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 影响行数
     */
    int deleteById(Integer categoryId);

}

