package servicerest

import grails.converters.JSON
import grails.converters.XML
import io.swagger.annotations.*

@Api(value = "/api", tags = ["Book"], description = "Book Api's")
class BookController {

    @ApiOperation(
            value = "List Books",
            nickname = "books",
            produces = "application/json, application/xml",
            httpMethod = "GET",
            response = Book.class,
            responseContainer = 'list'
    )
    @ApiResponses([
            @ApiResponse(code = 401,
                    message = "Unauthorized."),
            @ApiResponse(code = 403,
                    message = "Access Denied."),
            @ApiResponse(code = 406,
                    message = "Not Acceptable. Error code can only get receive as JSON."),
            @ApiResponse(code = 404,
                    message = "Book Not Found.")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "X-Auth-Token",
                    paramType = "header",
                    required = true,
                    value = "Security token",
                    dataType = "string")

    ])
    def getBooks() {
        def b = Book.all
        withFormat {
            json { render b as JSON }
            xml { render b as XML }
        }
    }

    @ApiOperation(
            value = "Get Book",
            nickname = "book/{id}",
            produces = "application/json, application/xml",
            httpMethod = "GET",
            response = Book.class
    )
    @ApiResponses([
            @ApiResponse(code = 401,
                    message = "Unauthorized."),
            @ApiResponse(code = 403,
                    message = "Access Denied."),
            @ApiResponse(code = 406,
                    message = "Not Acceptable. Error code can only get receive as JSON."),
            @ApiResponse(code = 404,
                    message = "Book Not Found.")

    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "id",
                    paramType = "path",
                    required = true,
                    value = "Id of book to return",
                    dataType = "string"),
            @ApiImplicitParam(name = "X-Auth-Token",
                    paramType = "header",
                    required = true,
                    value = "Security token",
                    dataType = "string")

    ])
    def getBook() {
        def b = Book.get(params.id)
        if (b == null)
            render(status: 404, message: "Book not found")
        else {
            withFormat {
                json { render b as JSON }
                xml { render b as XML }
            }
        }
    }
    @ApiOperation(
            value = "Delete Book",
            nickname = "book/{id}",
            produces = "application/json",
            httpMethod = "DELETE"
    )
    @ApiResponses([
            @ApiResponse(code = 401,
                    message = "Unauthorized."),
            @ApiResponse(code = 403,
                    message = "Access Denied."),
            @ApiResponse(code = 406,
                    message = "Not Acceptable. Error code can only get receive as JSON."),
            @ApiResponse(code = 404,
                    message = "Book Not Found."),
            @ApiResponse(code = 200,
                    message = "Book Deleted.")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "id",
                    paramType = "path",
                    required = true,
                    value = "Id of the book that need to be deleted",
                    dataType = "string"),
            @ApiImplicitParam(name = "X-Auth-Token",
                    paramType = "header",
                    required = true,
                    value = "Security token",
                    dataType = "string")

    ])
    def delBook() {
        def b = Book.get(params.id)
        if (b == null)
            render(status: 404, message: "Book not found")
        else {
            def l = Library.get(b.library.id)
            l.removeFromBooks(b)
            b.delete(flush: true)
            render(status: 200, message: "Book deleted")
        }
    }

    @ApiOperation(
            value = "Edit Book",
            nickname = "book/{id}",
            produces = "application/json",
            consumes = "application/x-www-form-urlencoded, application/json, application/xml",
            httpMethod = "PUT"
    )
    @ApiResponses([
            @ApiResponse(code = 401,
                    message = "Unauthorized."),
            @ApiResponse(code = 403,
                    message = "Access Denied."),
            @ApiResponse(code = 404,
                    message = "Book Not Found."),
            @ApiResponse(code = 406,
                    message = "Not Acceptable. Error code can only get receive as JSON."),
            @ApiResponse(code = 400,
                    message = "Error during update."),
            @ApiResponse(code = 200,
                    message = "Book updated.")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "id",
                    paramType = "path",
                    required = true,
                    value = "Id of the book that need to be updated",
                    dataType = "string"),
            @ApiImplicitParam(name = "X-Auth-Token",
                    paramType = "header",
                    required = true,
                    value = "Security token",
                    dataType = "string"),
            @ApiImplicitParam(name = "name",
                    paramType = "formData",
                    required = false,
                    value = "Updated name of the book",
                    dataType = "string"),
            @ApiImplicitParam(name = "releaseDate",
                    paramType = "formData",
                    required = false,
                    value = "Updated release date of the book",
                    dataType = "date"),
            @ApiImplicitParam(name = "isbn",
                    paramType = "formData",
                    required = false,
                    value = "Updated ISBN of the book",
                    dataType = "string"),
            @ApiImplicitParam(name = "author",
                    paramType = "formData",
                    required = false,
                    value = "Updated author of the book",
                    dataType = "string"),
            @ApiImplicitParam(name = "library.id",
                    paramType = "formData",
                    required = false,
                    value = "Updated library of the book",
                    dataType = "int")

    ])
    def editBook(Book book) {
        if (book.save(flush: true))
            render(status: 200, message: "Book updated")
        else
            render(status: 400, message: "Error during update")
    }

    @ApiOperation(
            value = "Add Book",
            nickname = "book",
            produces = "application/json",
            consumes = "application/x-www-form-urlencoded, application/json, application/xml",
            httpMethod = "POST"
    )
    @ApiResponses([
            @ApiResponse(code = 401,
                    message = "Unauthorized."),
            @ApiResponse(code = 403,
                    message = "Access Denied."),
            @ApiResponse(code = 406,
                    message = "Not Acceptable. Error code can only get receive as JSON."),
            @ApiResponse(code = 400,
                    message = "Error during creation."),
            @ApiResponse(code = 201,
                    message = "Book Created.")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "X-Auth-Token",
                    paramType = "header",
                    required = true,
                    value = "Security token",
                    dataType = "string"),
            @ApiImplicitParam(name = "name",
                    paramType = "formData",
                    required = true,
                    value = "Name of the book",
                    dataType = "string"),
            @ApiImplicitParam(name = "releaseDate",
                    paramType = "formData",
                    required = true,
                    value = "Release date of the book",
                    dataType = "string"),
            @ApiImplicitParam(name = "isbn",
                    paramType = "formData",
                    required = true,
                    value = "ISBN of the book",
                    dataType = "string"),
            @ApiImplicitParam(name = "author",
                    paramType = "formData",
                    required = true,
                    value = "Author of the book",
                    dataType = "string"),
            @ApiImplicitParam(name = "library.id",
                    paramType = "formData",
                    required = true,
                    value = "Library of the book",
                    dataType = "int")

    ])
    def addBook(Book book) {
        if (book.library.id == null) {
            render(status: 400, message: "Cannot add a book without an existing library")
            return
        }
        if (book.save(flush: true))
            render(status: 201, message: "Book created")
        else
            render(status: 400, message: "Error during creation")
    }

    def error405(){
        render(status: 405, message: "Method not allowed")
    }
}
