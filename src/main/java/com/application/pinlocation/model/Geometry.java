package com.application.pinlocation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geometry {
    Object bounds;
    Location location;
    Object location_type;
    Object viewport;
}
