package test;

import com.psy.mybatis.mapper.CounselorMapper;
import com.psy.model.Counselor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = null;

        // Mybatis 配置文件
        String resource = "mybatis.cfg.xml";

        // 得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建会话工厂，传入 MyBatis 的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        CounselorMapper mapper = session.getMapper(CounselorMapper.class);
        try {
            Counselor user = mapper.selectByPrimaryKey(1);
            System.out.println(user);
//            session.commit();
//            for (Counselor user : userList) {
//                System.out.println( user.getUsername() + " "
//                        + user.getPassword() + " " + user.getSex() + " "
//                        + user.getAddress());
//            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();

    }
}
