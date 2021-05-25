package lt.kslipaitis.recommender.model.recommendation.product;

import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;

public class JuniorSaverAccount extends Product {

    @Override
    protected boolean checkAge(QuestionnaireAnswersDTO answers) {
        return getAgeOption(answers) == AgeOption.YOUTH;
    }

    @Override
    protected boolean checkStudent(QuestionnaireAnswersDTO answers) {
        return true;
    }

    @Override
    protected boolean checkIncome(QuestionnaireAnswersDTO answers) {
        return true;
    }

}
