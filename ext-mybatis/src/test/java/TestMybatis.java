import com.adminsys.dao.WebDao;
import com.adminsys.entity.WebEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-20 03-47
 **/

public class TestMybatis {

    public static void main(String[] args) {
        // 定义mybatis文件
        String resource = "mybatis_config.xml";
        try {
            // 获取InputStreamReader
            Reader resourceAsReader = Resources.getResourceAsReader(resource);
            // SqlSessionFactory
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            // 获取Session
            SqlSession sqlSession = build.openSession();
            WebDao mapper = sqlSession.getMapper(WebDao.class);
            System.out.println(mapper.toString());
            WebEntity webEntity = mapper.selectAll("89357yeru");
            System.out.println(webEntity.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}