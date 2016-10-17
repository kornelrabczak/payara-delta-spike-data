package com.thecookiezen.deltaspike;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends EntityRepository<Book, Long> {

    List<Book> findByTitle(String title);

    List<Book> findByTitleAndAuthorAndOrderByCreatedDesc(String title, String author);

    @Query("select b from Book b where b.isbn = ?1")
    Book findByISBNNumber(String ISBN);
}
