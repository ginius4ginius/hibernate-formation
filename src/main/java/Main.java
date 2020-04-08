import com.formation.dao.ProduitDao;
import com.formation.dao.ProduitDaoEntityManagerFactory;
import com.formation.dao.ProduitDaoSessionFactory;

public class Main {

    public static void main(String[] args) {

        ProduitDao produitDaoSf= new ProduitDaoSessionFactory();
        //ProduitDao produitDaoEmf= new ProduitDaoEntityManagerFactory();

        produitDaoSf.setup();
        produitDaoSf.searchProduitByNom();
        produitDaoSf.exit();

    }

}
