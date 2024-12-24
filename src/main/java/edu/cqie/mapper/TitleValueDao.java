package edu.cqie.mapper;

import edu.cqie.entity.TitleValue;

import java.util.List;

public interface TitleValueDao {

    List<TitleValue> getTitleValue(Integer userId);

}
