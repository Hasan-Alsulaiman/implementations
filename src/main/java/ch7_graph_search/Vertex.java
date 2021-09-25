package ch7_graph_search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Vertex {
    private final String label;

    public String getLabel() {
        return label;
    }
}
