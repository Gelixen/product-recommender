package lt.kslipaitis.recommender.model.recommendation.product;

import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;

public class CurrentAccount extends Product {

    @Override
    public boolean doApply(QuestionnaireAnswersDTO answers) {
        return getIncomeOption(answers) != IncomeOption.NONE
                && getAgeOption(answers) != AgeOption.YOUTH;
    }

}
