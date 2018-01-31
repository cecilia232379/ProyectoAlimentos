package com.inabif.model;

import java.util.List;

public class MenuItemModel {
	
    private String name;

    private MenuItemModel parent;

    private List<MenuItemModel> children;
    
    private String link;

    public MenuItemModel(String name,List<MenuItemModel> children,String link) {
        this.name = name;
        this.children = children;
        this.link = link;
        for (MenuItemModel child : children) {
            child.parent = this;
        }
    }

    public MenuItemModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MenuItemModel getParent() {
        return parent;
    }

    public List<MenuItemModel> getChildren() {
        return children;
    }
    
    public String getLink() {
    	return link;
    }

}
