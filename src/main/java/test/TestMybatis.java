package test;

import com.psy.mybatis.mapper.CounselorMapper;
import com.psy.model.Counselor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = null;

        Logger logger=Logger.getLogger(TestMybatis.class);
        // Mybatis 配置文件
        String resource = "mybatis.cfg.xml";

        //得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建会话
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        CounselorMapper mapper = session.getMapper(CounselorMapper.class);
        try {
            List<Counselor> userList = mapper.selectAll();
            session.commit();
            for (Counselor user : userList) {
                System.out.println( user);
                logger.debug(user.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();

    }
}
