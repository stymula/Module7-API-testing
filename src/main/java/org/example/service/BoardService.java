package org.example.service;

import org.example.utility.ReadableResponse;

public class BoardService extends BaseService{
    public ReadableResponse getBoard(String id) {
        return getRequest( id + "&key=" + readConfigurationFile("key") + "&token=" + readConfigurationFile("token"));
    }
}
