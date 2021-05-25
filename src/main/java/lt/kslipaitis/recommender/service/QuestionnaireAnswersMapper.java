package lt.kslipaitis.recommender.service;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;
import lt.kslipaitis.recommender.model.questionnaire.StudentOption;
import org.springframework.stereotype.Component;

@Component
public class QuestionnaireAnswersMapper {

    public QuestionnaireAnswers map(QuestionnaireAnswersDTO questionnaireAnswersDTO) {
        AgeOption age = AgeOption.valueOf(questionnaireAnswersDTO.getAge());
        StudentOption student = StudentOption.valueOf(questionnaireAnswersDTO.getStudent());
        IncomeOption income = IncomeOption.valueOf(questionnaireAnswersDTO.getIncome());

        return new QuestionnaireAnswers(age, student, income);
    }

}
