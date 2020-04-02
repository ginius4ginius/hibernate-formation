import com.formation.dao.BookDao;
import com.formation.dao.BookDaoImpl;

public class Main {

    public static void main(String[] args) {

        BookDao dao = new BookDaoImpl();

        dao.setup();
        dao.delete();
        dao.exit();
    }

}
