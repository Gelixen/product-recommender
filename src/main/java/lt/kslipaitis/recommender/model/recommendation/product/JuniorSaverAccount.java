package lt.kslipaitis.recommender.model.recommendation.product;

import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;
import lt.kslipaitis.recommender.model.questionnaire.StudentOption;

public class JuniorSaverAccount extends Product {

    @Override
    protected boolean checkAge(AgeOption age) {
        return age == AgeOption.YOUTH;
    }

    @Override
    protected boolean checkStudent(StudentOption student) {
        return true;
    }

    @Override
    protected boolean checkIncome(IncomeOption income) {
        return true;
    }

}
