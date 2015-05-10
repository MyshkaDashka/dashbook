package by.bsuir.dashka.repository.specification;

import lombok.Data;

/**
 * Created by Dashka on 09.05.2015.
 */
@Data
public class SearchCriteria {
        private String key;
        private String operation;
        private Object value;
}
