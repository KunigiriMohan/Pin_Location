package com.application.pinlocation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PinLocationDetails {
    ArrayList<Results> results;
    HttpStatus status;
}
