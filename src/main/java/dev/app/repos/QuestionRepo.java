package dev.app.repos;

import dev.app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
    List<Question> findAllByCategory(String category);

    @Query(value = "SELECT q.id FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numOfQuestions", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(int numOfQuestions, String category);
}
