package edu.cqie.service;

import edu.cqie.entity.TitleValue;

import java.util.List;

public interface TitleValueService {

    List<TitleValue> getTitleValue(Integer userId);
}
