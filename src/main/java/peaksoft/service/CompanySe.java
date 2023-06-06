package com.example.securityproject.service;

import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.*;

import java.util.List;

public interface CompanySe {

    SimpleResponse saveCompany(CompanyRequest companyRequest);

    List<CompanyResponse> getAllCompany();

    CompanyResponse getCompanyId(Long id);

    SimpleResponse updateCompany(Long id,CompanyRequest companyRequest);

    SimpleResponse deleteCompany(Long id);

    CompanyInfoResponse infoCompany(Long companyId);
}
