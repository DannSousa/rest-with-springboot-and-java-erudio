package com.example.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controllers.BooksController;
import com.example.controllers.PersonController;
import com.example.data.vo.v1.BooksVO;
import com.example.data.vo.v1.PersonVO;
import com.example.exceptions.RequiredObjectIsNullException;
import com.example.exceptions.ResourceNotFoundException;
import com.example.mapper.DozerMapper;
import com.example.model.Books;
import com.example.model.Person;
import com.example.repositories.BooksRepository;

@Service
public class BooksServices {
	
	private Logger logger = Logger.getLogger(BooksServices.class.getName());
	
	@Autowired
	BooksRepository repository;
	
	
	
	public List<BooksVO> findAll() {		
		logger.info("Finding all books!");
		
		var books = DozerMapper.parseListObjects(repository.findAll(), BooksVO.class);
		books.stream().forEach(p -> p.add(linkTo(methodOn(BooksController.class).findById(p.getKey())).withSelfRel()));
		return books;
	}
	
	public BooksVO findById(long id) {		
		logger.info("Finding one book!");		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		var vo =  DozerMapper.parseObject(entity, BooksVO.class);
		vo.add(linkTo(methodOn(BooksController.class).findById(id)).withSelfRel());
		return vo;
	}

	public BooksVO create(BooksVO book) {
		if(book == null) throw new RequiredObjectIsNullException();
		logger.info("Creating a book");
		var entity = DozerMapper.parseObject(book, Books.class);
		var vo = DozerMapper.parseObject(repository.save(entity), BooksVO.class);
		vo.add(linkTo(methodOn(BooksController.class).findById(vo.getKey())).withSelfRel());
		return vo;		
	}

	public BooksVO update(BooksVO book) {
		logger.info("Update a book");
		if(book == null) throw new RequiredObjectIsNullException();
		var entity = repository.findById(book.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo = DozerMapper.parseObject(repository.save(entity), BooksVO.class);
		vo.add(linkTo(methodOn(BooksController.class).findById(vo.getKey())).withSelfRel());
		return vo;
		}
	public void  delete(Long id) {
		logger.info("Delete a book");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}
}
