package lt.kslipaitis.recommender.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;
import lt.kslipaitis.recommender.model.questionnaire.StudentOption;

@AllArgsConstructor
@Getter
public class QuestionnaireAnswers {

    private final AgeOption age;
    private final StudentOption student;
    private final IncomeOption income;

}
