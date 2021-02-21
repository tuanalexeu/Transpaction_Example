package spring.transactions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import spring.transactions.entity.Singer;
import spring.transactions.repository.SingerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class SingerServiceImpl implements SingerService {

    private SingerRepository repository;

    private TransactionTemplate transactionTemplate;

    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Autowired
    public void setSingerRepository(SingerRepository repository) {
        this.repository = repository;
    }


    @Autowired
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Singer save(Singer singer) {
        return repository.save(singer);
    }

    @Override
    public Long countAllSingers() {
        return transactionTemplate.execute(
                transactionStatus -> em
                        .createNamedQuery(Singer.COUNT_ALL, Long.class)
                        .getSingleResult()
        );
    }
}
