package Controller.Database;

import Model.Player.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserDAO {
    private SqlSession session;
    private static final String mapperResource = ".\\sql\\mapper\\MapperConfig.xml";
    private final String namespace = "Model.Player.UserInfo.";
    public UserDAO() {
        createSqlSession();
    }

    private void createSqlSession() {
        Reader reader = null;
        try {
            //String resource = System.getProperty("user.dir")+mapperResource;
            //File file = new File(resource);
            //System.out.println(file.exists());
            reader = Resources.getResourceAsReader(mapperResource);

            //reader = Resources.getResourceAsReader("./Resources/sql/mapper/MapperConfig.xml");
            //reader = Resources.getResourceAsReader(System.getProperty("user.dir")+mapperResource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
    }
    public UserInfo signInUser(UserInfo userInfo){
        userInfo = session.selectOne(namespace+"signInUser", userInfo);
        return userInfo;
    }

    public UserInfo selectUserById(UserInfo userInfo){
        userInfo = session.selectOne(namespace+"selectUserById", userInfo);
        return userInfo;
    }

    public List<UserInfo> selectAllUser(){
        List<UserInfo> userInfoList = session.selectList(namespace+"selectAllUser");
        return userInfoList;
    }


    public int insertUserInfo(UserInfo userInfo){
        int result = session.insert(namespace+"insertUser", userInfo);
        session.commit();
        return result;
    }

    public int updateUserInfo(UserInfo userInfo){
        int result = session.insert("updateUser", userInfo);
        session.commit();
        return result;
    }

}
