package com.application.pinlocation.service;

import com.application.pinlocation.model.Details;

public interface DetailsServiceEM {
    Details saveDetails(Details details);
    Details getDetails(Long addressId);
    void deleteDetailsById(Long id);
}
