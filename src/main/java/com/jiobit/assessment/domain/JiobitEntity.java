package com.jiobit.assessment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The data persistence entity.
 * The class represents the data model used by JPA and Hibernate ORM to represent the MySQL schema.
 */

@Entity
public class JiobitEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String guid;
  private long timestamp;
  private double latitude;
  private double longitude;
  private int accuracy;

  public JiobitEntity() {
  }

  public JiobitEntity(String guid, long timestamp, double latitude, double longitude, int accuracy) {
    this.guid = guid;
    this.timestamp = timestamp;
    this.latitude = latitude;
    this.longitude = longitude;
    this.accuracy = accuracy;
  }


  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public int getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(int accuracy) {
    this.accuracy = accuracy;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "timestamp = " + timestamp + ", " +
        "guid = " + guid + ", " +
        "latitude = " + latitude + ", " +
        "longitude = " + longitude + ", " +
        "accuracy = " + accuracy + ")";
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}
