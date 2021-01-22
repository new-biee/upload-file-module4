package com.uploadfile.demo.service;

import com.uploadfile.demo.model.Customer;
import com.uploadfile.demo.model.CustomerForm;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements IServiceCustomer {
    private static Map<Long, Customer> listStudent;

    static {
        listStudent = new HashMap<>();
        listStudent.put(1L, new Customer(1l, "Thành", "thanh@gmail.com", "Hà Nội"));
        listStudent.put(2L, new Customer(2l, "Tuấn Anh", "tuananh@gmail.com", "Hà Đông"));
        listStudent.put(3L, new Customer(3l, "Tú", "tu@gmail.com", "Hải Dương"));
        listStudent.put(4L, new Customer(4l, "Dũng", "dung@gmail.com", "Hải Phòng"));
    }

    @Override
    public List findAll() {
        ArrayList list = new ArrayList(listStudent.values());
        return list;
    }

    @Override
    public Customer findById(long id) {

        return null;
    }

    @Override
    public void update(Customer model) {

    }

    @Override
    public void save(Customer model) {
        Long stt = listStudent.size() + 1L;
        model.setId(stt);
        listStudent.put(stt, model);
    }

    @Override
    public void remove(Long id) {

    }
}
