package servicerest

import grails.converters.JSON
import grails.converters.XML

class BookController {

    def getBooks() {
        def b = Book.all
        withFormat {
            json { render b as JSON }
            xml { render b as XML }
        }
    }

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


    def editBook(Book book) {
        if (book.save(flush: true))
            render(status: 200, message: "Book updated")
        else
            render(status: 400, message: "Error during update")
    }

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
