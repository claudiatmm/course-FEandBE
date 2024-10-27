package service.serviceImplementations;

import io.restassured.response.Response;
import service.apiServices.BookstoreService;
import service.interfaceServices.BookstoreServiceInterface;

public class BookstoreServiceImpl implements BookstoreServiceInterface {

    private BookstoreService bookstoreService;

    public BookstoreServiceImpl(){
        bookstoreService = new BookstoreService();
    }

    @Override
    public Response addBooksIntoAccount(Object requestBody, String token) {
        return bookstoreService.post(requestBody, "/BookStore/v1/Books", token);
    }

}
