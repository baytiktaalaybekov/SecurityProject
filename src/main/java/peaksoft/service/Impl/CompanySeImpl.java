package com.example.securityproject.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyInfoResponse;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;
import peaksoft.service.CompanySe;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanySeImpl implements CompanySe {

    private final CompanyRepository companyRepository;


    @Override
    public SimpleResponse saveCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setCountry(companyRequest.getCountry());
        company.setAddress(companyRequest.getAddress());
        company.setPhone_number(companyRequest.getPhone_number());
        companyRepository.save(company);
        return SimpleResponse.builder().
              status(HttpStatus.OK)
                .message("Saved Company").build();
    }

    @Override
    public List<CompanyResponse> getAllCompany() {
        return companyRepository.getAllCompany();
    }

    @Override
    public CompanyResponse getCompanyId(Long id) {
        return companyRepository.getCompanyById(id).orElseThrow(()-> new NullPointerException("Company with id: "+id+"not found"));
    }

    @Override
    public SimpleResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new NullPointerException("Company with id:" + id + "not found"));
        company.setName(companyRequest.getName());
        company.setCountry(companyRequest.getCountry());
        company.setAddress(companyRequest.getAddress());
        company.setPhone_number(companyRequest.getPhone_number());
        companyRepository.save(company);
        return SimpleResponse.builder()
                .status(HttpStatus.OK).message("Update Company").build();
    }

    @Override
    public SimpleResponse deleteCompany(Long id) {
        companyRepository.deleteById(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Delete Company")
                .build();
    }



    @Override
    public CompanyInfoResponse infoCompany(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company with id: " + companyId + "Not found"));
        return CompanyInfoResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .address(company.getAddress())
                .phone_number(company.getPhone_number())
                .course_name(companyRepository.getAllCourseName(companyId)).
                group_name(companyRepository.getAllGroupName(companyId))
                .studentCount(companyRepository.getAllStudentSize(companyId))
                .instructorName(companyRepository.getAllInstructorName(companyId))
                .build();
    }
}
