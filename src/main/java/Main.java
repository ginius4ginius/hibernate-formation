import com.formation.dao.*;
import com.formation.dao.utils.EntityManagerFactoryUtils;
import com.formation.dao.utils.SessionFactoryUtils;
import com.formation.entities.Commande;

public class Main {

    public static void main(String[] args) {

        //SessionFactoryUtils utils = new SessionFactoryUtils();
        EntityManagerFactoryUtils utils = new EntityManagerFactoryUtils();

        //Dao commandeDaoSf = new CommandeDaoSessionFactory();
        CommandeDaoEntityManagerFactory commandeDaoEmF = new CommandeDaoEntityManagerFactory();
        commandeDaoEmF.delete();
        utils.exit();

    }

}
