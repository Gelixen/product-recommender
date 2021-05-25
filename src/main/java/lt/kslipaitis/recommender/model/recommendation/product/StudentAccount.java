package lt.kslipaitis.recommender.model.recommendation.product;

import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.StudentOption;

public class StudentAccount extends Product {

    @Override
    protected boolean checkAge(QuestionnaireAnswersDTO answers) {
        return getAgeOption(answers) != AgeOption.YOUTH;
    }

    @Override
    protected boolean checkStudent(QuestionnaireAnswersDTO answers) {
        return getStudentOption(answers) == StudentOption.YES;
    }

    @Override
    protected boolean checkIncome(QuestionnaireAnswersDTO answers) {
        return true;
    }

}
