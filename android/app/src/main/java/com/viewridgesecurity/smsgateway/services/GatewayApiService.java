package com.viewridgesecurity.smsgateway.services;

import com.viewridgesecurity.smsgateway.dtos.SMSDTO;
import com.viewridgesecurity.smsgateway.dtos.SMSForwardResponseDTO;
import com.viewridgesecurity.smsgateway.dtos.RegisterDeviceInputDTO;
import com.viewridgesecurity.smsgateway.dtos.RegisterDeviceResponseDTO;
import com.viewridgesecurity.smsgateway.dtos.HeartbeatInputDTO;
import com.viewridgesecurity.smsgateway.dtos.HeartbeatResponseDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GatewayApiService {
    @POST("gateway/devices")
    Call<RegisterDeviceResponseDTO> registerDevice(@Header("x-api-key") String apiKey, @Body() RegisterDeviceInputDTO body);

    @PATCH("gateway/devices/{deviceId}")
    Call<RegisterDeviceResponseDTO> updateDevice(@Path("deviceId") String deviceId, @Header("x-api-key") String apiKey, @Body() RegisterDeviceInputDTO body);

    @POST("gateway/devices/{deviceId}/receive-sms")
    Call<SMSForwardResponseDTO> sendReceivedSMS(@Path("deviceId") String deviceId, @Header("x-api-key") String apiKey, @Body() SMSDTO body);

    @PATCH("gateway/devices/{deviceId}/sms-status")
    Call<SMSForwardResponseDTO> updateSMSStatus(@Path("deviceId") String deviceId, @Header("x-api-key") String apiKey, @Body() SMSDTO body);

    @POST("gateway/devices/{deviceId}/heartbeat")
    Call<HeartbeatResponseDTO> heartbeat(@Path("deviceId") String deviceId, @Header("x-api-key") String apiKey, @Body() HeartbeatInputDTO body);
}