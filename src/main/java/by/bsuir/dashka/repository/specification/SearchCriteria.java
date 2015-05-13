package by.bsuir.dashka.repository.specification;

import lombok.Data;

import java.util.Objects;

/**
 * Created by Dashka on 09.05.2015.
 */
@Data
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;

    public SearchCriteria(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

}
