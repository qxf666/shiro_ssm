package com.poem.service;

import com.poem.dao.PoemDao;
import com.poem.pojo.PoemRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoemServicImpl implements PoemService {
@Autowired PoemDao poemDao;
    @Override
    public List<PoemRandom> selectPoemRandom() {
        return poemDao.selectPoemRandom();
    }
}
