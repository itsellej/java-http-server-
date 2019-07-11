package httpserver;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class RequestSplitterTest {

    @Test
    void returnsTheRequestMethodGet() {
        var stringReader = new StringReader("GET / HTTP/1.1");
        var input = new BufferedReader(stringReader);
        var requestHandler = new RequestHandler(input);
        var request = requestHandler.readResponse();

        var requestMethod = new RequestSplitter(request).getRequestMethod();

        assertEquals("GET", requestMethod);

    }

    @Test
    void returnsTheRequestPathSimpleGet() {
        var stringReader = new StringReader("GET /simple_get HTTP/1.1");
        var input = new BufferedReader(stringReader);
        var requestHandler = new RequestHandler(input);
        var request = requestHandler.readResponse();

        var requestMethod = new RequestSplitter(request).getRequestPath();

        assertEquals("/simple_get", requestMethod);

    }

}