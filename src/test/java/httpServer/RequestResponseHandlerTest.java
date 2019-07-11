package httpServer;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class RequestResponseHandlerTest {
    @Test
    void acceptsARequestAndOutputsTheExpectedResponse() {
        var clientRequest = "GET / HTTP/1.1";
        var stringReader = new StringReader(clientRequest);
        var input = new BufferedReader(stringReader);
        var expectedResponse = "HTTP/1.1 200 OK";
        var stringWriter = new StringWriter();
        var output = new PrintWriter(stringWriter);
        var requestResponseHandler = new RequestResponseHandler(input, output);

        requestResponseHandler.run();

        assertEquals(expectedResponse, stringWriter.toString());

    }
}