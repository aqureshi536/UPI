package com.our.dao;

import com.our.model.Error;

public interface ErrorDAO {

	Error getErrorCode(String status);
}
