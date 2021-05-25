package lt.kslipaitis.recommender.model.recommendation.product;

import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;

public class CurrentAccount extends Product {

    @Override
    protected boolean checkAge(QuestionnaireAnswersDTO answers) {
        return getAgeOption(answers) != AgeOption.YOUTH;
    }

    @Override
    protected boolean checkStudent(QuestionnaireAnswersDTO answers) {
        return true;
    }

    @Override
    protected boolean checkIncome(QuestionnaireAnswersDTO answers) {
        return getIncomeOption(answers) != IncomeOption.NONE;
    }

}
