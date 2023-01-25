package com.reactive.screeningdata.util;

import com.reactive.screeningdata.entity.ScreeningResult;
import com.reactive.screeningdata.entity.ScreeningTask;
import com.reactive.screeningdata.model.ScreeningResultDto;
import com.reactive.screeningdata.model.ScreeningTaskDto;

import java.time.LocalDateTime;

public class TestUtil {

    public static ScreeningResultDto createScreeningResultDto(){

        ScreeningResultDto screeningResultDto = new ScreeningResultDto();

        screeningResultDto.setOperator("Operator Test");
        screeningResultDto.setTpDoc(12345l);
        screeningResultDto.setShipmentNumber( 13415l );
        screeningResultDto.setBookedByCustomerCode( 4141531l );
        screeningResultDto.setBookedByCustomerName( "Customer Name Test" );
        screeningResultDto.setShipperCustomerCode( 143245l );
        screeningResultDto.setShipperCustomerName( "Shipper Name Test" );
        screeningResultDto.setShipperAddressLine1( "Address 1 Test" );
        screeningResultDto.setShipperAddressLine2( "Address 2 Test" );
        screeningResultDto.setConsigneeCustomerCode( 675647l );
        screeningResultDto.setConsigneeCustomerName( "Consignee Name Test" );
        screeningResultDto.setConsigneeAddressLine1( "Address 3 Test" );
        screeningResultDto.setFirstNotifyCustomerCode( 431421l );
        screeningResultDto.setFirstNotifyCustomerName( "Notify Name Test" );
        screeningResultDto.setFirstNotifyAddressLine1( "Address 4 Test" );
        screeningResultDto.setSecondNotifyCustomerCode( 632717l );
        screeningResultDto.setSecondNotifyCustomerName( "Second Notify Name Test" );
        screeningResultDto.setSecondNotifyAddressLine1( "Address 5 Test" );
        screeningResultDto.setCommodityCode( "12341" );
        screeningResultDto.setCommodityDescription( "Desc Test" );
        screeningResultDto.setCargoDocumentationDescription( "Desc 2 Test" );
        screeningResultDto.setContractualCustomerCustomerCode( 231345l );
        screeningResultDto.setContractualCustomerCustomerName( "Con Cust Name Test" );
        screeningResultDto.setHaz( "Haz Test" );
        screeningResultDto.setPorCountryName( "Country Test" );
        screeningResultDto.setPodCountryName( "Country 2 Test" );


        return screeningResultDto;
    }

    public static ScreeningResult createScreeningResult(){

        ScreeningResult screeningResult = new ScreeningResult();

        screeningResult.setOperator("Operator Test");
        screeningResult.setTpDoc(12345l);
        screeningResult.setShipmentNumber( 13415l );
        screeningResult.setBookedByCustomerCode( 4141531l );
        screeningResult.setBookedByCustomerName( "Customer Name Test" );
        screeningResult.setShipperCustomerCode( 143245l );
        screeningResult.setShipperCustomerName( "Shipper Name Test" );
        screeningResult.setShipperAddressLine1( "Address 1 Test" );
        screeningResult.setShipperAddressLine2( "Address 2 Test" );
        screeningResult.setConsigneeCustomerCode( 675647l );
        screeningResult.setConsigneeCustomerName( "Consignee Name Test" );
        screeningResult.setConsigneeAddressLine1( "Address 3 Test" );
        screeningResult.setFirstNotifyCustomerCode( 431421l );
        screeningResult.setFirstNotifyCustomerName( "Notify Name Test" );
        screeningResult.setFirstNotifyAddressLine1( "Address 4 Test" );
        screeningResult.setSecondNotifyCustomerCode( 632717l );
        screeningResult.setSecondNotifyCustomerName( "Second Notify Name Test" );
        screeningResult.setSecondNotifyAddressLine1( "Address 5 Test" );
        screeningResult.setCommodityCode( "12341" );
        screeningResult.setCommodityDescription( "Desc Test" );
        screeningResult.setCargoDocumentationDescription( "Desc 2 Test" );
        screeningResult.setContractualCustomerCustomerCode( 231345l );
        screeningResult.setContractualCustomerCustomerName( "Con Cust Name Test" );
        screeningResult.setHaz( "Haz Test" );
        screeningResult.setPorCountryName( "Country Test" );
        screeningResult.setPodCountryName( "Country 2 Test" );


        return screeningResult;


    }

    public static ScreeningTaskDto createScreeningTaskDto(){

        ScreeningTaskDto screeningTaskDto = new ScreeningTaskDto();

        screeningTaskDto.setResultId( 3l );
        screeningTaskDto.setAssignedTo( "Assigned To Test" );
        screeningTaskDto.setStatus( "TEST" );
        screeningTaskDto.setCreatedAt( LocalDateTime.now() );
        screeningTaskDto.setUpdatedAt( LocalDateTime.now() );

        return screeningTaskDto;

    }

}
