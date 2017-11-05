package servicerest

import grails.converters.JSON
import grails.converters.XML

class LibraryController {

    def getLibraries() {
        def l = Library.all
        withFormat {
            json { render l as JSON }
            xml { render l as XML }
        }
    }

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

    def delLibrary() {
        def l = Library.get(params.id)
        if (l == null)
            render(status: 404, message: "Library not found")
        else {
            l.delete(flush: true)
            render(status: 200, message: "Library deleted")
        }
    }

    def editLibrary(Library library) {
        if (library.save(flush: true))
            render(status: 200, message: "Library updated")
        else
            render(status: 400, message: "Error during update")
    }

    def addLibrary(Library library) {
        if (library.save(flush: true))
            render(status: 201, message: "Library created")
        else
            render(status: 400, message: "Error during creation")
    }

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

    def delBook() {
        def l = Library.get(params.lId)
        if (l == null)
            render(status: 400, message: "Cannot delete book from non existant library")
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

    def editBook(Book book) {
        def l = Library.get(params.lId)
        if (l == null)
            render(status: 400, message: "Cannot edit book from non existant library")
        else {
            def b = l.books.find {
                it.id == Long.parseLong(params.id)
            }
            if (b == null)
                render(value: 404, message: "Book not found in library")
            else {
                if (book.save(flush: true))
                    render(status: 200, message: "Book updated")
                else
                    render(status: 400, message: "Error during update")
            }
        }
    }

    def addBook(Book book) {
        def l = Library.get(params.lId)
        if (l == null)
            render(status: 400, message: "Cannot add book to non existant library")
        else {
            l.addToBooks(book)
            if (l.save(flush: true))
                render(status: 201, message: "Book created")
            else
                render(status: 400, message: "Error during creation")
        }
    }

    def error405(){
        render(status: 405, message: "Method not allowed")
    }

}
