package com.application.pinlocation.repository;

import com.application.pinlocation.model.Details;

public interface DetailsRepositoryEM {
    Details saveDetails(Details details);
    Details getDetailsById(Long id);
    void deleteDetailsByid(Long id);
}
