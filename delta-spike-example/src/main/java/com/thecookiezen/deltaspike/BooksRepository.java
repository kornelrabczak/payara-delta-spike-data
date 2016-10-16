package com.thecookiezen.deltaspike;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends EntityRepository<Book, Long> {

    List<Book> findByTitle(String title);

}
