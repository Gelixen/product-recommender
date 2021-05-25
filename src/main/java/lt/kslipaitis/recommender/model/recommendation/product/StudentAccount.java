package lt.kslipaitis.recommender.model.recommendation.product;

import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.StudentOption;

public class StudentAccount extends Product {

    @Override
    public boolean doApply(QuestionnaireAnswersDTO answers) {
        return getStudentOption(answers) == StudentOption.YES
                && getAgeOption(answers) != AgeOption.YOUTH;
    }

}
