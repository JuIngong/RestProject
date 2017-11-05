package servicerest

import grails.converters.JSON
import grails.converters.XML
import io.swagger.annotations.*

@Api(value = "/api", tags = ["Library"], description = "Library Api's")
class LibraryController {

    @ApiOperation(
            value = "List Libraries",
            nickname = "libraries",
            produces = "application/json, application/xml",
            httpMethod = "GET",
            response = Library.class,
            responseContainer = 'list'
    )
    @ApiResponses([
            @ApiResponse(code = 401,
                    message = "Unauthorized."),
            @ApiResponse(code = 403,
                    message = "Access Denied."),
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
    def getLibraries() {
        def l = Library.all
        withFormat {
            json { render l as JSON }
            xml { render l as XML }
        }
    }

    @ApiOperation(
            value = "Get Library",
            nickname = "library/{id}",
            produces = "application/json, application/xml",
            httpMethod = "GET",
            response = Library.class
    )
    @ApiResponses([
            @ApiResponse(code = 401,
                    message = "Unauthorized."),
            @ApiResponse(code = 403,
                    message = "Access Denied."),
            @ApiResponse(code = 404,
                    message = "Library Not Found.")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "id",
                    paramType = "path",
                    required = true,
                    value = "Id of library to return",
                    dataType = "string"),
            @ApiImplicitParam(name = "X-Auth-Token",
                    paramType = "header",
                    required = true,
                    value = "Security token",
                    dataType = "string")

    ])
    def getLibrary() {
        def l = Library.get(params.id)
        if (l == null)
            render(status: 404, message: "Library not found")
        else {
            withFormat {
                json { render l as JSON }
                xml { render l as XML }
            }
        }
    }

    @ApiOperation(
            value = "Delete Library",
            nickname = "library/{id}",
            produces = "application/json",
            httpMethod = "DELETE"
    )
    @ApiResponses([
            @ApiResponse(code = 401,
                    message = "Unauthorized."),
            @ApiResponse(code = 403,
                    message = "Access Denied."),
            @ApiResponse(code = 404,
                    message = "Library Not Found."),
            @ApiResponse(code = 200,
                    message = "Library Deleted.")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "id",
                    paramType = "path",
                    required = true,
                    value = "Id of the library that need to be deleted",
                    dataType = "string"),
            @ApiImplicitParam(name = "X-Auth-Token",
                    paramType = "header",
                    required = true,
                    value = "Security token",
                    dataType = "string")

    ])
    def delLibrary() {
        def l = Library.get(params.id)
        if (l == null)
            render(status: 404, message: "Library not found")
        else {
            l.delete(flush: true)
            render(status: 200, message: "Library deleted")
        }
    }

    @ApiOperation(
            value = "Edit Library",
            nickname = "library/{id}",
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
                    message = "Library Not Found."),
            @ApiResponse(code = 406,
                    message = "Not Acceptable. Error code can only get receive as JSON."),
            @ApiResponse(code = 400,
                    message = "Error during update."),
            @ApiResponse(code = 200,
                    message = "Library updated.")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "id",
                    paramType = "path",
                    required = true,
                    value = "Id of the library that need to be updated",
                    dataType = "string"),
            @ApiImplicitParam(name = "X-Auth-Token",
                    paramType = "header",
                    required = true,
                    value = "Security token",
                    dataType = "string"),
            @ApiImplicitParam(name = "name",
                    paramType = "formData",
                    required = false,
                    value = "Updated name of the library",
                    dataType = "string"),
            @ApiImplicitParam(name = "adresse",
                    paramType = "formData",
                    required = false,
                    value = "Updated adresse of the library",
                    dataType = "string"),
            @ApiImplicitParam(name = "yearCreated",
                    paramType = "formData",
                    required = false,
                    value = "Updated year of creation of the library",
                    dataType = "int")

    ])
    def editLibrary(Library library) {
        if (library.save(flush: true))
            render(status: 200, message: "Library updated")
        else
            render(status: 400, message: "Error during update")
    }

    @ApiOperation(
            value = "Create Library",
            nickname = "library",
            produces = "application/json",
            consumes = "application/json, application/xml, application/x-www-form-urlencoded",
            httpMethod = "POST"
    )
    @ApiResponses([
            @ApiResponse(code = 401,
                    message = "Unauthorized."),
            @ApiResponse(code = 403,
                    message = "Access Denied."),
            @ApiResponse(code = 400,
                    message = "Error during creation."),
            @ApiResponse(code = 406,
                    message = "Not Acceptable. Error code can only get receive as JSON."),
            @ApiResponse(code = 201,
                    message = "Library created.")
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
                    value = "Name of the library",
                    dataType = "string"),
            @ApiImplicitParam(name = "adresse",
                    paramType = "formData",
                    required = true,
                    value = "Adresse of the library",
                    dataType = "string"),
            @ApiImplicitParam(name = "yearCreated",
                    paramType = "formData",
                    required = true,
                    value = "Year of creation of the library",
                    dataType = "int")

    ])
    def addLibrary(Library library) {
        if (library.save(flush: true))
            render(status: 201, message: "Library created")
        else
            render(status: 400, message: "Error during creation")
    }

    @ApiOperation(
            value = "List Books from Library",
            nickname = "library/{id}/books",
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
                    message = "Library Not Found.")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "X-Auth-Token",
                    paramType = "header",
                    required = true,
                    value = "Security token",
                    dataType = "string"),
            @ApiImplicitParam(name = "id",
                    paramType = "path",
                    required = true,
                    value = "Id of the library",
                    dataType = "string")

    ])
    def getBooks() {
        def l = Library.get(params.id)
        if (l == null)
            render(status: 404, message: "Library not found")
        else {
            withFormat {
                json { render l.books as JSON }
                xml { render l.books as XML }
            }
        }
    }

    @ApiOperation(
            value = "Get Book from Library",
            nickname = "library/{lId}/book/{id}",
            produces = "application/json, application/xml",
            httpMethod = "GET",
            response = Book.class
    )
    @ApiResponses([
            @ApiResponse(code = 400,
                    message = "Cannot find book in non existant library."),
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
            @ApiImplicitParam(name = "lId",
                    paramType = "path",
                    required = true,
                    value = "Id of library",
                    dataType = "string"),
            @ApiImplicitParam(name = "X-Auth-Token",
                    paramType = "header",
                    required = true,
                    value = "Security token",
                    dataType = "string")

    ])
    def getBook() {
        def l = Library.get(params.lId)
        if (l == null)
            render(status: 400, message: "Cannot find book in non existant library")
        else {
            def b = l.books.find {
                it.id == Long.parseLong(params.id)
            }
            if (b == null) {
                render(status: 404, message: "Book not found in library")
            } else {
                withFormat {
                    json { render b as JSON }
                    xml { render b as XML }
                }
            }
        }
    }

    @ApiOperation(
            value = "Delete Book from Library",
            nickname = "library/{lId}/book/{id}",
            produces = "application/json",
            httpMethod = "DELETE"
    )
    @ApiResponses([
            @ApiResponse(code = 400,
                    message = "Cannot delete book from non existent library."),
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
            @ApiImplicitParam(name = "lId",
                    paramType = "path",
                    required = true,
                    value = "Id of library",
                    dataType = "string"),
            @ApiImplicitParam(name = "X-Auth-Token",
                    paramType = "header",
                    required = true,
                    value = "Security token",
                    dataType = "string")

    ])
    def delBook() {
        def l = Library.get(params.lId)
        if (l == null)
            render(status: 400, message: "Cannot delete book from non existent library")
        else {
            def b = l.books.find {
                it.id == Long.parseLong(params.id)
            }
            if (b == null)
                render(status: 404, message: "Book not found in library")
            else {
                l.removeFromBooks(b)
                b.delete(flush: true)
                render(status: 200, message: "Book deleted")
            }
        }
    }

    @ApiOperation(
            value = "Edit Book",
            nickname = "library/{lId}/book/{id}",
            produces = "application/json",
            consumes = "application/x-www-form-urlencoded, application/json, application/xml",
            httpMethod = "PUT"
    )
    @ApiResponses([
            @ApiResponse(code = 400,
                    message = "Cannot update book to non existent library."),
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
            @ApiImplicitParam(name = "lId",
                    paramType = "path",
                    required = true,
                    value = "Id of library",
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
                    dataType = "string")

    ])
    def editBook(Book book) {
        def l = Library.get(params.lId)
        if (l == null)
            render(status: 400, message: "Cannot edit book to non existent library")
        else {
            def b = l.books.find {
                it.id == Long.parseLong(params.id)
            }
            if (b == null) {
                def bl = Book.get(params.id)
                if(bl == null){
                    render(status: 404, message: "Book Not Found")
                    return
                }
                def lb = Library.get(bl.library.id)
                lb.removeFromBooks(book)
                l.addToBooks(book)
            }
            if (book.save(flush: true))
                render(status: 200, message: "Book updated")
            else
                render(status: 400, message: "Error during update")

        }
    }

    @ApiOperation(
            value = "Add Book to Library",
            nickname = "library/{lId}/book",
            produces = "application/json",
            consumes = "application/x-www-form-urlencoded, application/json, application/xml",
            httpMethod = "POST"
    )
    @ApiResponses([
            @ApiResponse(code = 400,
                    message = "Cannot add book to non existent library."),
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
            @ApiImplicitParam(name = "lId",
                    paramType = "path",
                    required = true,
                    value = "Id of library",
                    dataType = "string"),
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
                    dataType = "string")

    ])
    def addBook(Book book) {
        def l = Library.get(params.lId)
        if (l == null)
            render(status: 400, message: "Cannot add book to non existent library")
        else {
            l.addToBooks(book)
            if (l.save(flush: true))
                render(status: 201, message: "Book created")
            else
                render(status: 400, message: "Error during creation")
        }
    }

    def error405() {
        render(status: 405, message: "Method not allowed")
    }

}
