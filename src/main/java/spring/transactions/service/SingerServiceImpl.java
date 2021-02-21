package spring.transactions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import spring.transactions.entity.Singer;
import spring.transactions.repository.SingerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@EnableTransactionManagement
@Transactional
public class SingerServiceImpl implements SingerService {

    private SingerRepository repository;

    @Autowired
    public void setSingerRepository(SingerRepository repository) {
        this.repository = repository;
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
    @Transactional(readOnly = true)
    public Long countAllSingers() {
        return repository.countAllSingers();
    }
}
