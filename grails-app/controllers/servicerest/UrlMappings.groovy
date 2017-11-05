package servicerest

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "/api/library/$id"(controller: "library") {
            action = [GET: "getLibrary", POST: "error405", PUT: "editLibrary", DELETE: "delLibrary"]
        }
        "/api/libraries"(controller: "library") {
            action = [GET: "getLibraries", POST: "error405", PUT: "error405", DELETE: "error405"]
        }
        "/api/library"(controller: "library") {
            action = [GET: "error405", POST: "addLibrary", PUT: "error405", DELETE: "error405"]
        }
        "/api/library/$id/books"(controller: "library") {
            action = [GET: "getBooks", POST: "error405", PUT: "error405", DELETE: "error405"]
        }
        "/api/library/$lId/book/$id"(controller: "library") {
            action = [GET: "getBook", POST: "error405", PUT: "editBook", DELETE: "delBook"]
        }
        "/api/library/$lId/book"(controller: "library") {
            action = [GET: "error405", POST: "addBook", PUT: "error405", DELETE: "error405"]
        }
        "/api/book/$id"(controller: "book") {
            action = [GET: "getBook", POST: "error405", PUT: "editBook", DELETE: "delBook"]
        }
        "/api/books"(controller: "book") {
            action = [GET: "getBooks", POST: "error405", PUT: "error405", DELETE: "error405"]
        }
        "/api/book"(controller: "book") {
            action = [GET: "error405", POST: "addBook", PUT: "error405", DELETE: "error405"]
        }
    }
}
