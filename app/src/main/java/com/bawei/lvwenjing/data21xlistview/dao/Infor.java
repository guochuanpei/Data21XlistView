package com.bawei.lvwenjing.data21xlistview.dao;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by lenovo-pc on 2017/4/21.
 */
@Table(name = "infor")
public class Infor {
    @Column(name = "id", isId = true, autoGen = true)
    private int id;
    @Column(name = "title")
    private String name;
    @Column(name = "data")
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
