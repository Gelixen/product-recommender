package lt.kslipaitis.recommender.service;

import lt.kslipaitis.recommender.model.questionnaire.*;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Service
public class QuestionnaireService {
    public QuestionnaireOptions getQuestionnaireOptions() {
        return new QuestionnaireOptions(
                asList(AgeOption.values()),
                asList(StudentOption.values()),
                asList(IncomeOption.values())
        );
    }
}
