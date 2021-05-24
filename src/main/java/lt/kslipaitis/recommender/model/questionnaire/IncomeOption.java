package lt.kslipaitis.recommender.model.questionnaire;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum IncomeOption {
    
    NONE("NONE", "0"),
    LOW("LOW", "1-12'000"),
    MID("MID", "12'001-40'000"),
    HIGH("HIGH", "40'001+");

    private final String name;
    private final String description;

}
