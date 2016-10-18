package com.thecookiezen.deltaspike;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends EntityRepository<Book, Long> {

    List<Book> findByTitle(String title);

    List<Book> findByTitleAndAuthor(String title, String author);

    List<Book> findByTitleAndAuthorOrderByCreatedDesc(String title, String author);

    @Query("select b from Book b where b.isbn = ?1")
    Optional<Book> findByISBNNumber(String ISBN);
}
