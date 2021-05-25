package lt.kslipaitis.recommender.model.recommendation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Recommendations {

    private final List<ProductDTO> products;

}
