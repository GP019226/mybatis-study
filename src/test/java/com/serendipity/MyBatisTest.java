package com.serendipity;

import com.serendipity.mapper.MerchantMapper;
import com.serendipity.entity.Merchant;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @Author: qingshan
 * MyBatis Maven演示工程
 */
public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 通过 SqlSession.getMapper(XXXMapper.class)  接口方式
     * @throws IOException
     */
    @Test
    public void testSelect() throws IOException {
        SqlSession session = sqlSessionFactory.openSession(); // ExecutorType.BATCH
        try {
            MerchantMapper mapper = session.getMapper(MerchantMapper.class);
            Merchant merchant = mapper.selectByPrimaryKey(1);
            System.out.println(merchant);
        } finally {
            session.close();
        }
    }

    @Test
    public void testSave() throws IOException {
        SqlSession session = sqlSessionFactory.openSession(); // ExecutorType.BATCH
        try {
            MerchantMapper mapper = session.getMapper(MerchantMapper.class);
            Merchant merchant = new Merchant();
            merchant.setName("三星");
            merchant.setBusinessScope(Arrays.asList(1,2));
            mapper.insert(merchant);
            session.commit();
            System.out.println(merchant);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
