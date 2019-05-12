package cart

import grails.converters.JSON

class CartController {

    def discountService

    def getAnswerNo1(def params){
        Map result= new HashMap()
        result.answerNo1 = discountService.answer1(params)
        render(contentType:  'application/json',text: "${result as JSON}")
    }

    def getDiscount(def params){
        Map result= new HashMap()
        result.totalDiscount = discountService.getDiscountAmount(params)
        render(contentType:  'application/json',text: "${result as JSON}")
    }
    def getBill(def params){
        Map result= new HashMap()
        result.totalBill = discountService.totalBill(params)
        render(contentType:  'application/json',text: "${result as JSON}")
    }
}
