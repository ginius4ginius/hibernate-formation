import com.formation.dao.BookDao;
import com.formation.dao.BookDaoEntityManagerFactory;
import com.formation.dao.BookDaoSessionFactory;

public class Main {

    public static void main(String[] args) {

        //BookDao daoSession = new BookDaoSessionFactory();
        BookDao daoEntityManager = new BookDaoEntityManagerFactory();

        daoEntityManager.setup();
        daoEntityManager.delete();
        daoEntityManager.exit();
    }

}
