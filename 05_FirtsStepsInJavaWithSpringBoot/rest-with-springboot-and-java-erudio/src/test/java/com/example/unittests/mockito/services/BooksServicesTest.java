package com.example.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.data.vo.v1.BooksVO;
import com.example.exceptions.RequiredObjectIsNullException;
import com.example.model.Books;
import com.example.repositories.BooksRepository;
import com.example.services.BooksServices;
import com.example.unittests.mapper.mocks.MockBooks;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BooksServicesTest {
	
	MockBooks input;
	
	@InjectMocks
	private BooksServices service;
	
	@Mock
	BooksRepository repository;
	
	

	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockBooks();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() {
		Books entity = input.mockEntity(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		var result = service.findById(1L);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertNotNull(result.toString().contains("links: [</api/books/v1/1>;rel=\"self\"]"));
		assertEquals("Author Test1", result.getAuthor());
		assertEquals("Launch Date Test1", result.getLaunchDate());
		assertEquals("Price Test1", result.getPrice());
		assertEquals("Title Test1", result.getTitle());
		
		//fail("Not yet implemented");
	}
	
	@Test
	void testFindAll() {
		List<Books> list = input.mockEntityList();
			
		when(repository.findAll()).thenReturn(list);
		
		var books = service.findAll();
		
		assertNotNull(books);
		assertEquals(14, books.size());
		
		var bookOne = books.get(1);
		assertNotNull(bookOne);
		assertNotNull(bookOne.getKey());
		assertNotNull(bookOne.getLinks());
		assertNotNull(bookOne.toString().contains("links: [</api/books/v1/1>;rel=\"self\"]"));
		assertEquals("Author Test1", bookOne.getAuthor());
		assertEquals("Launch Date Test1", bookOne.getLaunchDate());
		assertEquals("Price Test1", bookOne.getPrice());
		assertEquals("Title Test1", bookOne.getTitle());
		
		var bookFour = books.get(4);
		assertNotNull(bookFour);
		assertNotNull(bookFour.getKey());
		assertNotNull(bookFour.getLinks());
		assertNotNull(bookFour.toString().contains("links: [</api/books/v1/4>;rel=\"self\"]"));
		assertEquals("Author Test4", bookFour.getAuthor());
		assertEquals("Launch Date Test4", bookFour.getLaunchDate());
		assertEquals("Price Test4", bookFour.getPrice());
		assertEquals("Title Test4", bookFour.getTitle());
		
		var bookSeven = books.get(7);
		assertNotNull(bookSeven);
		assertNotNull(bookSeven.getKey());
		assertNotNull(bookSeven.getLinks());
		assertNotNull(bookSeven.toString().contains("links: [</api/books/v1/7>;rel=\"self\"]"));
		assertEquals("Author Test7", bookSeven.getAuthor());
		assertEquals("Launch Date Test7", bookSeven.getLaunchDate());
		assertEquals("Price Test7", bookSeven.getPrice());
		assertEquals("Title Test7", bookSeven.getTitle());
		
				
	}


	@Test
	void testCreate() {
		Books entity = input.mockEntity(1);
		Books persisted = entity;
		persisted.setId(1L);
		
		BooksVO vo = input.mockVO(1);
		vo.setKey(1L);
		
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.create(vo);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertNotNull(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Author Test1", result.getAuthor());
		assertEquals("Launch Date Test1", result.getLaunchDate());
		assertEquals("Price Test1", result.getPrice());
		assertEquals("Title Test1", result.getTitle());
		}
	
	@Test
	void testCreateWithNullPerson() {
		
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.create(null);
		});
		
		String expectedMessage = "It is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
		
	}

	@Test
	void testUpdate() {
		Books entity = input.mockEntity(1);
		entity.setId(1L);
		
		Books persisted = entity;
		persisted.setId(1L);
		
		BooksVO vo = input.mockVO(1);
		vo.setKey(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));		
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.update(vo);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertNotNull(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Author Test1", result.getAuthor());
		assertEquals("Launch Date Test1", result.getLaunchDate());
		assertEquals("Price Test1", result.getPrice());
		assertEquals("Title Test1", result.getTitle());	
	}
	
	
	@Test
	void testUpdateWithNullBooks() {
		
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.update(null);
		});
		
		String expectedMessage = "It is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
		
	}


	@Test
	void testDelete() {
		Books entity = input.mockEntity(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		service.delete(1L);		
		
	}

}
