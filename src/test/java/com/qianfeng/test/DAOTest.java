package com.qianfeng.test;

import com.poem.dao.PoemDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName JiaMiTest
 * @Description: TODO
 * @Author 臧红久PoemDao
 * @Date 2019/10/10
 * @Version V1.0
 **/
public class DAOTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        PoemDao poems=context.getBean("poemDao", PoemDao.class);
        poems.selectPoemRandom();

    }
}
