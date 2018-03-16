package com.example.jbtang.agi.ui;

import com.example.jbtang.agi.dao.BaseStationinfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 刘洋旭 on 2016/11/29.
 */
public interface GetMap {

    @GET("/cell")
    Call<BaseStationinfo> getLbs(@Query("mcc") int mcc,@Query("mnc") int mnc,@Query("lac") int lac,@Query("ci") int cellid,@Query("output") String output);
}
