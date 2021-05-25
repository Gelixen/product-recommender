package lt.kslipaitis.recommender.model.recommendation.product;

import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;

public class SeniorAccount extends Product {

    @Override
    public boolean doApply(QuestionnaireAnswersDTO answers) {
        return getAgeOption(answers) == AgeOption.SENIOR;
    }

}
