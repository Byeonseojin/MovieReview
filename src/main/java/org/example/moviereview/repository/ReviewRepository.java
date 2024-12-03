package org.example.moviereview.repository;

import org.example.moviereview.entity.Member;
import org.example.moviereview.entity.Movie;
import org.example.moviereview.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);

    @Modifying
    @Query("delete from Review rw where rw.member = :member")
    void deleteByMember(Member member);
}
