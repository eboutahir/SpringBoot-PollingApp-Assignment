package Polling.Quiz.Quiz.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer question_id;
    private String textQues;
    //private Integer quiz_id ;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }


    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options = new ArrayList<>();
    public List<Option> getOptions(){
        return this.options;
    }

}
