package mystore

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/question1"(controller: "cart", action: "getAnswerNo1")
        "/totalDiscount"(controller: "cart", action: "getDiscount")
        "/totalPay"(controller: "cart", action: "getBill")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
