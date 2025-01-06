package com.example.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import com.example.data.vo.v1.BooksVO;
import com.example.data.vo.v1.PersonVO;
import com.example.model.Books;
import com.example.model.Person;

public class MockBooks {


    public Books mockEntity() {
        return mockEntity(0);
    }
    
    public BooksVO mockVO() {
        return mockVO(0);
    }
    
    public List<Books> mockEntityList() {
        List<Books> books = new ArrayList<Books>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BooksVO> mockVOList() {
        List<BooksVO> bookss = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            bookss.add(mockVO(i));
        }
        return bookss;
    }
    
    public Books mockEntity(Integer number) {
        Books books = new Books();
        books.setAuthor("Author Test" + number);
        books.setLaunchDate("Launch Date Test" + number);
        books.setPrice("Price Test" + number);
        books.setId(number.longValue());
        books.setTitle("Title Test" + number);
        return books;
    }

    public BooksVO mockVO(Integer number) {
        BooksVO books = new BooksVO();
        books.setAuthor("Author Test" + number);
        books.setLaunchDate("Launch Date Test" + number);
        books.setPrice("Price Test" + number);
        books.setKey(number.longValue());
        books.setTitle("Title Test" + number);
        return books;
    }

}
