package lt.kslipaitis.recommender.model.recommendation.product;

import lt.kslipaitis.recommender.model.QuestionnaireAnswersDTO;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;
import lt.kslipaitis.recommender.model.questionnaire.StudentOption;

public abstract class Product {

    public String getName() {
        return getClass().getSimpleName().replaceAll("(.)([A-Z])", "$1 $2");
    }
    
    public abstract boolean doApply(QuestionnaireAnswersDTO answers);
    
    protected AgeOption getAgeOption(QuestionnaireAnswersDTO answers) {
        return AgeOption.valueOf(answers.getAge());
    }

    protected StudentOption getStudentOption(QuestionnaireAnswersDTO answers) {
        return StudentOption.valueOf(answers.getStudent());
    }

    protected IncomeOption getIncomeOption(QuestionnaireAnswersDTO answers) {
        return IncomeOption.valueOf(answers.getIncome());
    }

}
