package com.zx.service;

import java.util.List;

import com.zx.model.MenuModel;
import com.zx.model.ParameterModel;

public interface LoginService {

	public List<MenuModel> getMenu();
	public List<ParameterModel> getSystemParameter();
}
