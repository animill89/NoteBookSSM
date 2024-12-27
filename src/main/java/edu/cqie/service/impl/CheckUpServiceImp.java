package edu.cqie.service.impl;

import edu.cqie.entity.CheckUp;
import edu.cqie.mapper.CheckUpDao;
import edu.cqie.service.CheckUpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CheckUpService")
public class CheckUpServiceImp implements CheckUpService {

    @Resource
    private CheckUpDao checkUpDao;

    @Override
    public List<CheckUp> CheckUp(Integer userId) {
        return this.checkUpDao.CheckUp(userId);
    }

}
