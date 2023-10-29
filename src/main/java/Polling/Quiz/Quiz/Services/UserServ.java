package Polling.Quiz.Quiz.Services;



import Polling.Quiz.Quiz.Models.Quiz;
import Polling.Quiz.Quiz.Models.QuizResult;
import Polling.Quiz.Quiz.Models.User;


import java.util.List;
import java.util.Optional;

public interface UserServ {

    User createUser( User user);
    Optional<User> getByIdUser( Integer id);
    List<User> getAllUser();
    void updateUser(User user);
    void deleteUser(Integer id);

    //Method to retrieve all quizzes created by a specific user
    List<Quiz> getQuizzesCreatedByUser( Integer userId);
    //Method to retrieve all quiz results associated with a specific user
    List<QuizResult> getQuizResultsForUser( Integer userId);
    //Method to create a new quiz for a specific user.
    Quiz createQuizForUser(Integer userId, Quiz quiz);
    //Method to delete a user, including their created quizzes and quiz results
    void deleteUserAndAssociatedData(Integer userId);
}
