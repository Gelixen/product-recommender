package lt.kslipaitis.recommender.model.recommendation.product;

import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;

public class CreditCard extends Product {

    @Override
    public boolean doApply(QuestionnaireAnswersDTO answers) {
        return checkIncome(answers) && checkAge(answers);
    }

    private boolean checkIncome(QuestionnaireAnswersDTO answers) {
        return getIncomeOption(answers) == IncomeOption.MID
                || getIncomeOption(answers) == IncomeOption.HIGH;
    }

    private boolean checkAge(QuestionnaireAnswersDTO answers) {
        return getAgeOption(answers) != AgeOption.YOUTH;
    }

}
