package edu.cqie.mapper;

import edu.cqie.entity.Event;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Event)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-17 16:05:21
 */
public interface EventDao {

    /**
     * 通过ID查询单条数据
     *
     * @param eventId 主键
     * @return 实例对象
     */
    Event queryById(Integer eventId);

    /**
     * 查询指定行数据
     *
     * @param event    查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Event> queryAllByLimit(Event event, @Param("pageable") Pageable pageable);


    /*
     * 作者：刘星
     * 根据用户Id查询用户自己的任务列表
     * */
    List<Event> selectListByUserId(@Param("userId") Integer userId);

    /*
     * 作者：刘星
     * 搜索任务详情
     * */
    List<Event> searchEvent(
            @Param("userId") int userId,
            @Param("eventLevel") String eventLevel,
            @Param("isCompleted") String isCompleted,
            @Param("eventContent") String eventContent);

    /**
     * 统计总行数
     *
     * @param event 查询条件
     * @return 总行数
     */
    long count(Event event);

    /**
     * 新增数据
     *
     * @param event 实例对象
     * @return 影响行数
     */
    int insert(Event event);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Event> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Event> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Event> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Event> entities);

    /**
     * 修改数据
     *
     * @param event 实例对象
     * @return 影响行数
     */
    int update(Event event);

    /**
     * 通过主键删除数据
     *
     * @param eventId 主键
     * @return 影响行数
     */
    int deleteById(Integer eventId);

}

