package spring.transactions.service;

import spring.transactions.entity.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    Singer findById(Long id);
    Singer save(Singer singer);
    Long countAllSingers();
}
