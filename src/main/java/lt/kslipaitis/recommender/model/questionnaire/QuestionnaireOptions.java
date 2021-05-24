package lt.kslipaitis.recommender.model.questionnaire;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class QuestionnaireOptions {

    private final List<AgeOption> ageOptions;
    private final List<StudentOption> studentOptions;
    private final List<IncomeOption> incomeOptions;

}
