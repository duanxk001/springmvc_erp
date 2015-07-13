package com.zx.mybatis.inter;

import java.util.List;

import com.zx.model.MenuModel;
import com.zx.model.ParameterModel;

public interface IUserOpration {
	
	public List<MenuModel> getAllMenu();
	public List<ParameterModel> getSystemParameter();
}
