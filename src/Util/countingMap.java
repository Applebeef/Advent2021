package Util;

import java.util.HashMap;

public class countingMap<K> extends HashMap<K, Long> {
    long defaultValue;

    public countingMap(long defaultValue) {
        this.defaultValue = defaultValue;
    }

    public countingMap() {
        this.defaultValue = 0;
    }

    public void setDefaultValue(long defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * Adds the value to the current value of the corresponding key.
     * Will create the new map entry (key,value) if it doesn't already exist in the map.
     *
     * @param key   The key to add to
     * @param value Amount to be added to the value corresponding to the key.
     */

    public Long addTo(K key, Long value) {
        if (containsKey(key)) {
            return super.put(key, get(key) + value);
        } else {
            return super.put(key, value);
        }
    }

    /**
     * Adds the key to the map with the current default value.
     * replaces current value if the key already exists in the map.
     *
     * @param key The key to be added to the map
     */
    public Long put(K key) {
        return super.put(key, defaultValue);
    }
}
