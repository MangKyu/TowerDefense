package Controller.Database;

import Model.Player.LevelInfo;
import Model.Player.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class LevelDAO {
    private SqlSession session;
    private static final String mapperResource = ".\\sql\\mapper\\MapperConfig.xml";
    private final String namespace = "Model.Player.LevelInfo.";
    public LevelDAO() {
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
    public boolean updateLevelInfo(LevelInfo levelInfo){
        int result = session.update(namespace+"updateLevelInfo", levelInfo);
        session.commit();;
        return result > 0;
    }

    public LevelInfo retrieveLevelInfo(UserInfo userInfo) {
        return session.selectOne(namespace+"retrieveLevelInfo", userInfo);
    }
}
