package com.bagandov.surveyCRUD.model.survey;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "survey")
@Data
@NoArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "close_date")
    private Date closeDate;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_id")
    private List<SurveyQuestion> questions;

    public void addQuestion(SurveyQuestion questionToAdd) {

        if(questions == null) {
            questions = new ArrayList<>();
        }

        questions.add(questionToAdd);
    }
}
