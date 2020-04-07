import com.adminsys.dao.WebDao;
import com.adminsys.entity.WebEntity;
import com.adminsys.jdk.JdkMapperProxy;

import java.lang.reflect.Proxy;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-20 10-33
 **/

public class TestMybatis02 {
    public static void main(String[] args) {
        WebDao mapper = getMapper(WebDao.class);
        WebEntity webEntity = mapper.selectAll("1");
        System.out.println(webEntity.toString());
    }
    public static <T>T getMapper(Class<T> type){
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new JdkMapperProxy());
    }
}
