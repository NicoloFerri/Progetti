package Service;

import Models.ThreeBpFlopIpUnprocessed;
import java.util.List;
import java.util.logging.Logger;

import Utils.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AnalisiService {
    private static final Log log = LogFactory.getLog(AnalisiService.class);

    public static void saveService(List<ThreeBpFlopIpUnprocessed> listOfRecords){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            listOfRecords.stream().forEach( record -> {
                session.save(record);
                log.info("oggetto salvato a db " + record.getFlop() + " " + record.getHand());
            });
            transaction.commit();
            log.info("Fine transazione, completata con successo");

        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
