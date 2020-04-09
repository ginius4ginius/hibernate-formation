import com.formation.dao.*;
import com.formation.dao.utils.SessionFactoryUtils;
import com.formation.entities.Commande;

public class Main {

    public static void main(String[] args) {

        SessionFactoryUtils utils = new SessionFactoryUtils();


        Dao commandeDaoSf = new CommandeDaoSessionFactory();
        commandeDaoSf.delete();
        utils.exit();

    }

}
