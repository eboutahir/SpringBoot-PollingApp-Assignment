package Polling.Quiz.Quiz.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Options")
public class Option {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String textOption;
    private boolean is_correct;
    //private  Integer question_id;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
