package com.poem.dao;

import com.poem.pojo.PoemRandom;

import java.util.List;

public interface PoemDao {
    public List<PoemRandom> selectPoemRandom();
}
