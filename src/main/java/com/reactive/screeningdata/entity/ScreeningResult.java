package com.reactive.screeningdata.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ScreeningResult {

    @Id
    private Long id;
    private String operator;
    private Long tpDoc;
    private Long shipmentNumber;
    private Long bookedByCustomerCode;
    private String bookedByCustomerName;
    private Long shipperCustomerCode;
    private String shipperCustomerName;
    private String shipperAddressLine1;
    private String shipperAddressLine2;
    private Long consigneeCustomerCode;
    private String consigneeCustomerName;
    private String consigneeAddressLine1;
    private Long firstNotifyCustomerCode;
    private String firstNotifyCustomerName;
    private String firstNotifyAddressLine1;
    private Long secondNotifyCustomerCode;
    private String secondNotifyCustomerName;
    private String secondNotifyAddressLine1;
    private String commodityCode;
    private String commodityDescription;
    private String cargoDocumentationDescription;
    private Long contractualCustomerCustomerCode;
    private String contractualCustomerCustomerName;
    private String haz;
    private String porCountryName;
    private String podCountryName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScreeningResult that = (ScreeningResult) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
