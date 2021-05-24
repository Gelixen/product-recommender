package lt.kslipaitis.recommender.model.questionnaire;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AgeOption {

    YOUTH("YOUTH","0-17"),
    ADULT("ADULT", "18-64"),
    SENIOR("SENIOR", "65+");

    private final String name;
    private final String description;

}
