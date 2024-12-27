package edu.cqie.mapper;

import edu.cqie.entity.CheckUp;

import java.util.List;

public interface CheckUpDao {

    List<CheckUp> CheckUp(Integer userId);
}
