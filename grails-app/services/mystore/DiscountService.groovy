package mystore

import grails.transaction.Transactional

import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Transactional
class DiscountService {

    def answer1(def params){
        def input = params.input.split(";")

        Map<String,String> res = new HashMap<>()
        def data
        for(int i = 0; i< input.length ; i++) {
            data = input[i].split("=")
            res.put(data[0], data[1])
        }
        return res

    }

    def validateUser(def params){
        def results = new HashMap()
        def user = User.findById(params.userId)
        if(!user){
            return results.result = "N"; results.message = "User not found";
        }
        results.result = "Y"
        results.message = "Success get user"
        return results
    }

    def getDiscountAmount(def params){
        def user = User.findById(params.userId)
        def totalDiscount
        if("ROLE_EMPLOYEE" == user.role.name){
            totalDiscount = 0.3 * Double.valueOf(params.totalPrice)
        }else if("ROLE_AFFILIATE" == user.role.name){
            totalDiscount = 0.1 * Double.valueOf(params.totalPrice)
        }else{

            def sdf = new SimpleDateFormat("yyyy-MM-dd")
            def userJoinDate = LocalDate.parse(sdf.format(user.dateCreated), DateTimeFormatter.ISO_LOCAL_DATE)
            def today = LocalDate.parse(sdf.format(new Date()), DateTimeFormatter.ISO_LOCAL_DATE)
            Duration diff = Duration.between(userJoinDate.atStartOfDay(), today.atStartOfDay())
            long diffDays = diff.toDays();

            // 2 years = 730 days, assumption 1 year = 365 days
            if(diffDays > 730){
                totalDiscount = 0.05 * Double.valueOf(params.totalPrice)
            }else{
                def price = Double.valueOf(params.totalPrice) / 100
                if(price > 0){
                    totalDiscount = Math.floor(price) * 5
                }else{
                    totalDiscount = 0
                }
            }
        }
        return totalDiscount
    }

    def totalBill(def params){
        return Double.valueOf(params.totalPrice) - getDiscountAmount(params)
    }


}
