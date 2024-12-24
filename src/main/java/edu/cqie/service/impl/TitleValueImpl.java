package edu.cqie.service.impl;

import edu.cqie.entity.TitleValue;
import edu.cqie.mapper.EventCategoryDao;
import edu.cqie.mapper.TitleValueDao;
import edu.cqie.service.TitleValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("TitleValueService")
public class TitleValueImpl implements TitleValueService {

    @Resource
    private TitleValueDao titleValueDao;

    @Override
    public List<TitleValue> getTitleValue(Integer userId) {
        return this.titleValueDao.getTitleValue(userId);
    }
}
