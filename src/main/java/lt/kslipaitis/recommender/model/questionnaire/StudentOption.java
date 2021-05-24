package lt.kslipaitis.recommender.model.questionnaire;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StudentOption {
    
    YES("YES", "Yes"),
    NO("NO", "No");

    private final String name;
    private final String description;

}
