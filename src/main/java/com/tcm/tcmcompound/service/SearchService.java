package com.tcm.tcmcompound.service;

import java.util.Map;

public interface SearchService {
    Map<String, Object> searchByKeyword(String keyword, String searchType, int pIndex, int size);
}
