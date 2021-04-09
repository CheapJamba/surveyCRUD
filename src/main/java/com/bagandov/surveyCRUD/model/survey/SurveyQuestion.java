package com.bagandov.surveyCRUD.model.survey;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "survey_question")
@Data
@NoArgsConstructor
public class SurveyQuestion {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "survey_id")
    private Long surveyId;

    @Column(name = "text")
    private String text;

    @Column(name = "placing_order")
    private Integer order;
}
