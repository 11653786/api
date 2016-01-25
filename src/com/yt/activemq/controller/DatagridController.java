package com.yt.activemq.controller;

import com.yt.activemq.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/1/25 0025.
 */
@Controller
public class DatagridController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "list";
    }

    @RequestMapping(value = "/datagrid", method = RequestMethod.POST)
    @ResponseBody
    public Page datagrid(@RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "rows", defaultValue = "10") Integer rows, String sql) {
        return getList(page, sql);
    }


    private Page getList(int page, String where) {
        Page pages = new Page();
        List<User> list = new ArrayList<User>();
        Random random = new Random();
        for (int a = 0; a <= 50; a++) {
            User user = new User();
            user.setName("name" + random.nextInt(100));
            list.add(user);
        }

        if (where != null && !where.equals("")) {
            for (int a = 0; a <= list.size(); a++) {
                if (list.get(a).getName().contains(String.valueOf(page))) {
                    list.remove(list.get(a));
                }
            }
        }
        pages.setRows(list);
        pages.setTotal(list.size());
        return pages;
    }

    class Page {
        private Object rows;
        private int total;

        public Object getRows() {
            return rows;
        }

        public void setRows(Object rows) {
            this.rows = rows;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
}
