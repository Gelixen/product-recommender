package lt.kslipaitis.recommender.service;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.*;
import org.springframework.stereotype.Component;

@Component
public class QuestionnaireAnswersMapper {

    public QuestionnaireAnswers map(QuestionnaireAnswersDTO answersDTO) {
        return QuestionnaireAnswers.builder()
                .age(mapAge(answersDTO))
                .student(mapStudent(answersDTO))
                .income(mapIncome(answersDTO))
                .build();
    }

    private IncomeOption mapIncome(QuestionnaireAnswersDTO answersDTO) {
        return IncomeOption.valueOf(answersDTO.getIncome());
    }

    private StudentOption mapStudent(QuestionnaireAnswersDTO answersDTO) {
        return StudentOption.valueOf(answersDTO.getStudent());
    }

    private AgeOption mapAge(QuestionnaireAnswersDTO answersDTO) {
        return AgeOption.valueOf(answersDTO.getAge());
    }

}
