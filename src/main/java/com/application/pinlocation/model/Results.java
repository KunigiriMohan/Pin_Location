package com.application.pinlocation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Results {
    Object address_components;
    String formatted_address;
    Geometry geometry;
    Object place_id;
    Object types;


}
