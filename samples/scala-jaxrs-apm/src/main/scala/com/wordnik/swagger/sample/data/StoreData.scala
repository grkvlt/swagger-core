/**
 *  Copyright 2012 Wordnik, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.wordnik.swagger.sample.data

import collection.mutable.ListBuffer
import com.wordnik.swagger.sample.model.{Order}
import java.util.Date

class StoreData {
  val orders:ListBuffer[Order] = new ListBuffer[Order]()

  {
    orders += createOrder (1, 1, 2, new Date(), "placed")
    orders += createOrder (2, 1, 2, new Date(), "delivered")
    orders += createOrder (3, 2, 2, new Date(), "placed")
    orders += createOrder (4, 2, 2, new Date(), "delivered")
    orders += createOrder (5, 3, 2, new Date(), "placed")
  }

  def findOrderById(orderId:Long):Order = {
    for (order <- orders){
      if (order.getId() == orderId){
        return order
      }
    }
    null
  }

  def placeOrder(order:Order):Unit = {
    for (currentOrder <- orders){
      if (currentOrder.getId() == order.getId()){
        orders -= order
      }
    }
    orders += order
  }

  def deleteOrder(orderId:Long):Unit = {
    for (order <- orders){
      if (order.getId() == orderId){
        orders -= order
      }
    }
  }

  private def createOrder(id:Long, petId:Long, quantity:Int, shipDate:Date, status:String):Order = {
    val order = new Order()
    order.setId(id)
    order.setPetId(petId)
    order.setQuantity(quantity)
    order.setShipDate(shipDate)
    order.setStatus(status)
    order
  }
}