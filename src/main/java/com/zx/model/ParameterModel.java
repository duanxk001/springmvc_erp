package com.zx.model;

import java.util.Date;

public class ParameterModel
{
	private Integer parameter_Id;
	private String myid;
	private String name;
	private String value;
	private String description;
	private String group_Type;
	private String state;
	private String status;
	private Object editor;
	private Date created;
	private Date lastmod;
	private Integer creater;
	private Integer modifyer;
	private String editor_Type;
	
	public Integer getParameter_Id() {
		return parameter_Id;
	}
	public void setParameter_Id(Integer parameter_Id) {
		this.parameter_Id = parameter_Id;
	}
	public String getGroup_Type() {
		return group_Type;
	}
	public void setGroup_Type(String group_Type) {
		this.group_Type = group_Type;
	}
	public String getEditor_Type() {
		return editor_Type;
	}
	public void setEditor_Type(String editor_Type) {
		this.editor_Type = editor_Type;
	}
	public String getMyid()
	{
		return myid;
	}
	public void setMyid(String myid )
	{
		this.myid = myid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name )
	{
		this.name = name;
	}
	public String getValue()
	{
		return value;
	}
	public void setValue(String value )
	{
		this.value = value;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description )
	{
		this.description = description;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state )
	{
		this.state = state;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status )
	{
		this.status = status;
	}
	public Object getEditor()
	{
		return editor;
	}
	public void setEditor(Object editor )
	{
		this.editor = editor;
	}
	public Date getCreated()
	{
		return created;
	}
	public void setCreated(Date created )
	{
		this.created = created;
	}
	public Date getLastmod()
	{
		return lastmod;
	}
	public void setLastmod(Date lastmod )
	{
		this.lastmod = lastmod;
	}
	public Integer getCreater()
	{
		return creater;
	}
	public void setCreater(Integer creater )
	{
		this.creater = creater;
	}
	public Integer getModifyer()
	{
		return modifyer;
	}
	public void setModifyer(Integer modifyer )
	{
		this.modifyer = modifyer;
	}
}
