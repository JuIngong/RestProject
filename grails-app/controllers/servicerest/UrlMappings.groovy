package servicerest

class UrlMappings {

    static mappings = {
//        "/$controller/$action?/$id?(.$format)?"{
//            constraints {
//                // apply constraints here
//            }
//        }

        "/"(view: "/index")
        "500"(view: '/error')
        "/library/$id"(controller: "library") {
            action = [GET: "getLibrary", PUT: "editLibrary", DELETE:"delLibrary"]
        }
        "/libraries"(controller: "library") {
            action = [GET: "getLibraries"]
        }
        "/library"(controller: "library") {
            action = [POST: "addLibrary"]
        }
        "/library/$id/books"(controller: "library") {
            action = [GET: "getBooks"]
        }
        "/library/$lId/book/$id"(controller: "library") {
            action = [GET: "getBook", PUT: "editBook", DELETE: "delBook"]
        }
        "/library/$lId/book"(controller: "library") {
            action = [POST: "addBook"]
        }
        "/book/$id"(controller: "book") {
            action = [GET: "getBook", PUT: "editBook", DELETE:"delBook"]
        }
        "/books"(controller: "book") {
            action = [GET: "getBooks"]
        }
        "/book"(controller: "book") {
            action = [POST: "addBook"]
        }
    }
}
