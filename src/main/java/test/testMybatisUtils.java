package test;

import com.psy.mybatis.mapper.UserMapper;
import com.psy.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class testMybatisUtils {
    public static void main(String[] args) {
        SqlSession session = MybatisUtil.openSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            int i = mapper.deleteByPrimaryKey(3);
            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
