package com.jiobit.assessment.domain;

import java.io.Serializable;

/**
 * The DTO is used for the input payload representation.
 */

public class JiobitEntityDto implements Serializable {
    private final double latitude;
    private final double longitude;
    private final int accuracy;

    public JiobitEntityDto(double latitude, double longitude, int accuracy) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getAccuracy() {
        return accuracy;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "latitude = " + latitude + ", " +
                "longitude = " + longitude + ", " +
                "accuracy = " + accuracy + ")";
    }
}
