package edu.cqie.service;

import edu.cqie.entity.CheckUp;

import java.util.List;

public interface CheckUpService {
    List<CheckUp> CheckUp(Integer userId);
}
