package Polling.Quiz.Quiz.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table ( name = "QuizResults")
public class QuizResult {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idQR;
    //private Integer user_id;
    //private Integer quiz_id;
    private Integer score;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

}
