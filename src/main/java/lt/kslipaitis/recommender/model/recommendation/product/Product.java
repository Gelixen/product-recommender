package lt.kslipaitis.recommender.model.recommendation.product;

import lt.kslipaitis.recommender.model.QuestionnaireAnswers;
import lt.kslipaitis.recommender.model.questionnaire.AgeOption;
import lt.kslipaitis.recommender.model.questionnaire.IncomeOption;
import lt.kslipaitis.recommender.model.questionnaire.StudentOption;

public abstract class Product {

    public String getName() {
        return getClass().getSimpleName().replaceAll("(.)([A-Z])", "$1 $2");
    }

    public boolean doApply(QuestionnaireAnswers answers) {
        return checkAge(answers.getAge()) && checkStudent(answers.getStudent()) && checkIncome(answers.getIncome());
    }

    protected abstract boolean checkAge(AgeOption age);

    protected abstract boolean checkStudent(StudentOption student);

    protected abstract boolean checkIncome(IncomeOption income);

}
