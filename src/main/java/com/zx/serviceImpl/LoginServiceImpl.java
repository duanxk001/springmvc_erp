package com.zx.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.model.MenuModel;
import com.zx.model.ParameterModel;
import com.zx.mybatis.inter.IUserOpration;
import com.zx.service.LoginService;
import com.zx.service.PublicDao;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private PublicDao publicDao;
	
	@Autowired
	IUserOpration userMapper;
	
	public List<ParameterModel> getSystemParameter(){
		List<ParameterModel> list = userMapper.getSystemParameter();
		return list;
	}
	
	public List<MenuModel> getMenu(){
		List<MenuModel> list = new ArrayList<MenuModel>();
		List<MenuModel> temList = userMapper.getAllMenu();
		System.out.println(temList);
		for (MenuModel object : temList)
		{
			if (object.getPid()==null)
			{
				List<MenuModel> childList=new ArrayList<MenuModel>();
				for (MenuModel obj2 : temList)
				{
					if (object.getId().equals(obj2.getPid()))
					{
						childList.add(obj2);
					}
				}
				object.setChild(childList);
				list.add(object);
			}
		}
		return list;
	}
	
	public List<MenuModel> getMenu1(){
		List<MenuModel> list = new ArrayList<MenuModel>();
		String sql = "select * from PERMISSION";
		sql="SELECT p.PERMISSION_ID,p.PID,p.NAME,p.ICONCLS,p.URL FROM PERMISSION AS p\n" +
				"where p.STATUS='A' and p.TYPE='F' and p.ISUSED='Y'";
		List temList = publicDao.findBySQL(sql);
		System.out.println(temList);
		for (Object object : temList)
		{
			Object[] objs=(Object[])object;
			String id = String.valueOf(objs[0]);
			if (objs[1]==null)
			{
				MenuModel menuModel=new MenuModel();
				menuModel.setName(String.valueOf(objs[2]));
				menuModel.setIconCls(String.valueOf(objs[3]));
				menuModel.setUrl(String.valueOf(objs[4]));
				List<MenuModel> childList=new ArrayList<MenuModel>();
				for (Object obj2 : temList)
				{
					MenuModel menuChildModel=new MenuModel();
					Object[] objs2=(Object[])obj2;
					String sid = String.valueOf(objs2[1]);
					if (sid.equals(id))
					{
						menuChildModel.setName(String.valueOf(objs2[2]));
						menuChildModel.setIconCls(String.valueOf(objs2[3]));
						menuChildModel.setUrl(String.valueOf(objs2[4]));
						childList.add(menuChildModel);
					}
				}
				menuModel.setChild(childList);
				list.add(menuModel);
			}
		}
		return list;
	}
}
