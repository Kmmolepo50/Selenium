package Utilities;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class DataTableUtils {

    public static List<Map<String, String>> toListOfMaps(DataTable dataTable) {
        return dataTable.asMaps(String.class, String.class);
    }

    /**
     * Convert single-row DataTable to Map<String, String>.
     * Ideal for one-row credential input.
     */
    public static Map<String, String> toSingleRowMap(DataTable dataTable) {
        return dataTable.asMaps(String.class, String.class).get(0);
    }

    /**
     * Convert DataTable to List<List<String>> — raw access without headers.
     */
    public static List<List<String>> toListOfLists(DataTable dataTable) {
        return dataTable.asLists();
    }

    /**
     * Get a value from a two-column table (field/value pattern).
     */
    public static String getValueFromKey(DataTable dataTable, String key) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        return map.getOrDefault(key, "");
    }
}
